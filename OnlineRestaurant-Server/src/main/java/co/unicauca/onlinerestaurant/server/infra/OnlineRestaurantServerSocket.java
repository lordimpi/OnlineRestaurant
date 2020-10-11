package co.unicauca.onlinerestaurant.server.infra;

import co.unicauca.onlinerestaurant.commons.domain.Customer;
import co.unicauca.onlinerestaurant.commons.domain.DishEntry;
import co.unicauca.onlinerestaurant.commons.domain.Dessert;
import co.unicauca.onlinerestaurant.commons.domain.MainDish;
import co.unicauca.onlinerestaurant.commons.domain.Restaurant;
import co.unicauca.onlinerestaurant.commons.domain.Salad;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.commons.infra.Protocol;
import co.unicauca.onlinerestaurant.commons.infra.Utilities;
import co.unicauca.onlinerestaurant.server.access.Factory;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.unicauca.onlinerestaurant.server.domain.services.CustomerService;
import co.unicauca.onlinerestaurant.server.access.ICustomerRepository;
import co.unicauca.onlinerestaurant.server.access.IDishEntryRepository;
import co.unicauca.onlinerestaurant.server.domain.services.DishEntryService;
import co.unicauca.onlinerestaurant.server.access.IMainDishRepository;
import co.unicauca.onlinerestaurant.server.domain.services.DessertService;
import co.unicauca.onlinerestaurant.server.domain.services.MainDishService;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import co.unicauca.onlinerestaurant.server.access.IDessertRepository;
import co.unicauca.onlinerestaurant.server.access.IRestaurantRepository;
import co.unicauca.onlinerestaurant.server.access.ISaladRepository;
import co.unicauca.onlinerestaurant.server.domain.services.RestaurantService;
import co.unicauca.onlinerestaurant.server.domain.services.SaladService;

/**
 * Servidor Socket que está escuchando permanentemente solicitudes de los
 * clientes. Cada solicitud la atiende en un hilo de ejecución
 *
 */
public class OnlineRestaurantServerSocket implements Runnable {

    /**
     * Servicio de clientes
     */
    private final CustomerService service;
    /**
     * Servicio de platos principales
     */
    private final MainDishService mdService;
    /**
     * Servicio de platos de entradas
     */
    private final DishEntryService deService;
    /**
     * Servicio de Restaurante
     */
    private final RestaurantService rService;
    /**
     * Servicio de platos principales
     */
    private final DessertService dService;
    /**
     * Servicio de Ensalada
     */
    private final SaladService saService;
    /**
     * Server Socket, la orejita
     */
    private static ServerSocket ssock;
    /**
     * Socket por donde se hace la petición/respuesta
     */
    private static Socket socket;
    /**
     * Permite leer un flujo de datos del socket
     */
    private Scanner input;
    /**
     * Permite escribir un flujo de datos del scoket
     */
    private PrintStream output;
    /**
     * Puerto por donde escucha el server socket
     */
    private static final int PORT = Integer.parseInt(Utilities.loadProperty("server.port"));

    /**
     * Constructor
     */
    public OnlineRestaurantServerSocket() {
        // Se hace la inyección de dependencia
        ICustomerRepository repository = Factory.getInstance().getRepository();
        IMainDishRepository mdRespository = Factory.getInstance().getRepository2();
        IDishEntryRepository deRespository = Factory.getInstance().getRepository3();
        IDessertRepository dRepository = Factory.getInstance().getRepository4();
        IRestaurantRepository rRepository = Factory.getInstance().getRepository5();
        ISaladRepository saRepository = Factory.getInstance().getRepository6();

        service = new CustomerService(repository);
        mdService = new MainDishService(mdRespository);
        deService = new DishEntryService(deRespository);
        dService = new DessertService(dRepository);
        rService = new RestaurantService(rRepository);
        saService = new SaladService(saRepository);
    }

    /**
     * Arranca el servidor y hace la estructura completa
     */
    public void start() {
        openPort();

        while (true) {
            waitToClient();
            throwThread();
        }
    }

    /**
     * Lanza el hilo
     */
    private static void throwThread() {
        new Thread(new OnlineRestaurantServerSocket()).start();
    }

    /**
     * Instancia el server socket y abre el puerto respectivo
     */
    private static void openPort() {
        try {
            ssock = new ServerSocket(PORT);
            Logger.getLogger("Server").log(Level.INFO, "Servidor iniciado, escuchando por el puerto {0}", PORT);
        } catch (IOException ex) {
            Logger.getLogger(OnlineRestaurantServerSocket.class.getName()).log(Level.SEVERE, "Error del server socket al abrir el puerto", ex);
        }
    }

    /**
     * Espera que el cliente se conecta y le devuelve un socket
     */
    private static void waitToClient() {
        try {
            socket = ssock.accept();
            Logger.getLogger("Socket").log(Level.INFO, "Socket conectado");
        } catch (IOException ex) {
            Logger.getLogger(OnlineRestaurantServerSocket.class.getName()).log(Level.SEVERE, "Eror al abrir un socket", ex);
        }
    }

    /**
     * Cuerpo del hilo
     */
    @Override
    public void run() {
        try {
            createStreams();
            readStream();
            closeStream();

        } catch (IOException ex) {
            Logger.getLogger(OnlineRestaurantServerSocket.class.getName()).log(Level.SEVERE, "Eror al leer el flujo", ex);
        }
    }

    /**
     * Crea los flujos con el socket
     *
     * @throws IOException
     */
    private void createStreams() throws IOException {
        output = new PrintStream(socket.getOutputStream());
        input = new Scanner(socket.getInputStream());
    }

    /**
     * Lee el flujo del socket
     */
    private void readStream() {
        if (input.hasNextLine()) {
            // Extrae el flujo que envió la aplicación cliente
            String request = input.nextLine();
            processRequest(request);

        } else {
            output.flush();
            String errorJson = generateErrorJson();
            output.println(errorJson);
        }
    }

    /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     * json que viene de esta manera:
     * "{"resource":"customer","action":"get","parameters":[{"name":"id","value":"1"}]}"
     *
     */
    private void processRequest(String requestJson) {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);

        switch (protocolRequest.getResource()) {
            case "customer":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un customer
                    processGetCustomer(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un customer    
                    processPostCustomer(protocolRequest);
                }
                break;
            case "maindish":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un customer
                    processGetMainDish(protocolRequest);
                }

                if (protocolRequest.getAction().equals("put")) {
                    // Consultar un customer
                    processSetMainDish(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un customer    
                    processPostMainDish(protocolRequest);
                }
                if (protocolRequest.getAction().equals("delete")) {
                    // Eliminar un customer    
                    processdeleteMainDish(protocolRequest);
                }
                break;
            case "dishentry":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un plato de entrada
                    processGetDishEntry(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un plato de entrada
                    processPostDishEntry(protocolRequest);
                }
                break;
            case "Dessert":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un postre
                    processGetDessert(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un postre    
                    processPostDessert(protocolRequest);
                }
                break;
            case "restaurant":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un restaurant
                    processGetRestaurant(protocolRequest);
                }

                if (protocolRequest.getAction().equals("put")) {
                    // Agrega un restaurante
                    processPostRestaurant(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // actualiza un restaurante  
                    processPostRestaurantn(protocolRequest);
                }
                if (protocolRequest.getAction().equals("delete")) {
                    // Eliminar un resturante    
                    processDeleteRestaurantn(protocolRequest);
                }
                break;
            case "salad":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar una ensalada
                    processGetSalad(protocolRequest);
                }

                if (protocolRequest.getAction().equals("put")) {
                    // Agrega un restaurante
                    processSetSalad(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // actualiza un restaurante  
                    processPostSalad(protocolRequest);
                }
                if (protocolRequest.getAction().equals("delete")) {
                    // Eliminar un resturante    
                    processDeleteSalad(protocolRequest);
                }
                break;
        }

    }

    /**
     * Procesa la solicitud de consultar un customer
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetCustomer(Protocol protocolRequest) {
        // Extraer la cedula del primer parámetro
        String name = protocolRequest.getParameters().get(0).getValue();
        String pws = protocolRequest.getParameters().get(1).getValue();

        Customer customer = service.findCustomer(name, pws);
        if (customer == null) {
            String errorJson = generateNotFoundErrorJson("Usuario no registrado");
            output.println(errorJson);
        } else {
            output.println(objectToJSON(customer));
        }
    }

    private void processGetMainDish(Protocol protocolRequest) {
        // Extraer el identificador del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        MainDish mainDish = mdService.findMainDish(id);
        if (mainDish == null) {
            String errorJson = generateNotFoundErrorJson("Plato no encontrado. El Id no existe");
            output.println(errorJson);
        } else {
            output.println(objectToJSONMD(mainDish));
        }
    }

    private void processdeleteMainDish(Protocol protocolRequest) {
        // Extraer el identificador del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        mdService.deleteMainDish(id);
    }

    private void processSetMainDish(Protocol protocolRequest) {
        // Extraer el identificador del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        String name = protocolRequest.getParameters().get(1).getValue();
        String price = protocolRequest.getParameters().get(2).getValue();
        mdService.updateMainDish(id, name, price);
        MainDish mainDish = mdService.findMainDish(id);
        if (mainDish == null) {
            String errorJson = generateNotFoundErrorJson("Plato no encontrado. El Id no existe");
            output.println(errorJson);
        } else {
            output.println(objectToJSONMD(mainDish));
        }
    }

    /**
     * Procesa la solicitud de actualizar ensalada
     *
     * @param protocolRequest
     */
    private void processPostSalad(Protocol protocolRequest) {
        // Extraer el identificador del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        String name = protocolRequest.getParameters().get(1).getValue();
        String coste = protocolRequest.getParameters().get(2).getValue();
        saService.updateSalad(id, name, coste);
        Salad salad = saService.findSalad(id);
        if (salad == null) {
            String errorJson = generateNotFoundErrorJson("Plato no encontrado. El Id no existe");
            output.println(errorJson);
        } else {
            output.println(objectToJSONRSA(salad));
        }
    }

    /**
     * Procesa la solicitud de agregar un plato de entrada
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetDishEntry(Protocol protocolRequest) {
        // Extraer la cedula del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        DishEntry dishEntry = deService.findDishEntry(id);
        if (dishEntry == null) {
            String errorJson = generateNotFoundErrorJson("Plato de entrada no encontrado. El Id no existe");
            output.println(errorJson);
        } else {
            output.println(objectToJSONDE(dishEntry));
        }
    }

    /**
     * Procesa la solicitud de consultar un postre
     *
     * @param protocolRequest
     */
    private void processGetDessert(Protocol protocolRequest) {
        // Extraer el identificador del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        Dessert Dessert = dService.findDessert(id);
        if (Dessert == null) {
            String errorJson = generateNotFoundErrorJson("Plato no encontrado. El Id no existe");
            output.println(errorJson);
        } else {
            output.println(objectToJSOND(Dessert));
        }
    }

    /**
     * Procesa la solicitud de agregar un plato de entrada
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetRestaurant(Protocol protocolRequest) {

        String id = protocolRequest.getParameters().get(0).getValue();
        Restaurant restaurant = rService.findRestaurant(id);
        if (restaurant == null) {
            String errorJson = generateNotFoundErrorJson("Restaurante no encontrado. El Id no existe");
            output.println(errorJson);
        } else {
            output.println(objectToJSONRE(restaurant));
        }
    }

    /**
     * Procesa la solicitud de buscar una ensalada
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetSalad(Protocol protocolRequest) {

        String id = protocolRequest.getParameters().get(0).getValue();
        Salad salad = saService.findSalad(id);
        if (salad == null) {
            String errorJson = generateNotFoundErrorJson("Ensalada no encontrada. El Id no existe");
            output.println(errorJson);
        } else {
            output.println(objectToJSONRSA(salad));
        }
    }

    /**
     * Procesa la solicitud de agregar un customer
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processPostCustomer(Protocol protocolRequest) {
        Customer customer = new Customer();
        // Reconstruir el customer a partir de lo que viene en los parámetros
        customer.setId(protocolRequest.getParameters().get(0).getValue());
        customer.setFirstName(protocolRequest.getParameters().get(1).getValue());
        customer.setLastName(protocolRequest.getParameters().get(2).getValue());
        customer.setAddress(protocolRequest.getParameters().get(3).getValue());
        customer.setEmail(protocolRequest.getParameters().get(4).getValue());
        customer.setRol(protocolRequest.getParameters().get(5).getValue());
        customer.setMobile(protocolRequest.getParameters().get(6).getValue());

        String response = service.createCustomer(customer);
        output.println(response);
    }

    /**
     * Procesa la solicitud de agregar un plato
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processPostMainDish(Protocol protocolRequest) {
        MainDish mainDish = new MainDish();
        // Reconstruir el customer a partid de lo que viene en los parámetros
        mainDish.setId_mainDishe(protocolRequest.getParameters().get(0).getValue());
        mainDish.setNameDishe(protocolRequest.getParameters().get(1).getValue());
        mainDish.setDishPrice(Double.parseDouble(protocolRequest.getParameters().get(2).getValue()));

        String response = mdService.createMainDish(mainDish);
        output.println(response);
    }

    private void processPostDessert(Protocol protocolRequest) {
        Dessert dessert = new Dessert();
        // Reconstruir el customer a partid de lo que viene en los parámetros
        dessert.setId_Dish_Dessert(protocolRequest.getParameters().get(0).getValue());
        dessert.setName_Dish_Dessert(protocolRequest.getParameters().get(1).getValue());
        dessert.setCost_Dish_Dessert(Integer.parseInt(protocolRequest.getParameters().get(2).getValue()));

        String response = dService.createDessert(dessert);
        output.println(response);
    }

    /**
     * Proceso la solicitud de agregar un plato de entrada
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processPostDishEntry(Protocol protocolRequest) {
        DishEntry dishEntry = new DishEntry();
        // Reconstruir el plato de entrda a partir de lo que viene en los parámetros
        dishEntry.setIdDishEntry(protocolRequest.getParameters().get(0).getValue());
        dishEntry.setNameDishEntry(protocolRequest.getParameters().get(1).getValue());
        dishEntry.setCostDishEntry(Double.parseDouble(protocolRequest.getParameters().get(2).getValue()));
        String response = deService.createDishEntry(dishEntry);
        output.println(response);
    }

    /**
     * procesa la solicitud de agragar un restaurante
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processPostRestaurant(Protocol protocolRequest) {
        Restaurant restaurant = new Restaurant();
        // Reconstruir el restaurantea partir de lo que viene en los parámetros
        restaurant.setIdRestaurant(protocolRequest.getParameters().get(0).getValue());
        restaurant.setNameRestaurant(protocolRequest.getParameters().get(0).getValue());
        restaurant.setAddressRestaurant(protocolRequest.getParameters().get(0).getValue());
        restaurant.setPhone(protocolRequest.getParameters().get(0).getValue());
        restaurant.setIdmenu(protocolRequest.getParameters().get(0).getValue());

        String response = rService.createRestaurant(restaurant);
        output.println(response);
    }

    /**
     * Procesa la actualizacion de un restaurante
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processPostRestaurantn(Protocol protocolRequest) {
        // Extraer el identificador del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        String name = protocolRequest.getParameters().get(1).getValue();
        String address = protocolRequest.getParameters().get(2).getValue();
        String phone = protocolRequest.getParameters().get(2).getValue();
        String idmenu = protocolRequest.getParameters().get(2).getValue();
        rService.updateRestaurant(id, name, address, phone, idmenu);
        Restaurant restaurant = rService.findRestaurant(id);
        if (restaurant == null) {
            String errorJson = generateNotFoundErrorJson("Restaurant no encontrado. El Id no existe");
            output.println(errorJson);
        } else {
            output.println(objectToJSONMRES(restaurant));
        }
    }

    /**
     * Proceso para agregar una ensalada
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processSetSalad(Protocol protocolRequest) {
        Salad salad = new Salad();
        // Reconstruir el restaurantea partir de lo que viene en los parámetros
        salad.setIdhSalad(protocolRequest.getParameters().get(0).getValue());
        salad.setNameDishSalad(protocolRequest.getParameters().get(0).getValue());
        salad.setCostSalad(protocolRequest.getParameters().get(0).getValue());
        String response = saService.createSalad(salad);
        output.println(response);
    }

    /**
     * Proceso para eliminar un restaurante
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processDeleteRestaurantn(Protocol protocolRequest) {
        String id = protocolRequest.getParameters().get(0).getValue();
        rService.removeRestaurant(id);
    }

    /**
     * proceso para eliminar una ensalada
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processDeleteSalad(Protocol protocolRequest) {
        String id = protocolRequest.getParameters().get(0).getValue();
        saService.deleteSalad(id);
    }

    /**
     * Genera un ErrorJson de cliente no encontrado
     *
     * @return error en formato json
     */
    private String generateNotFoundErrorJson(String errorMsg) {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage(errorMsg);
//        error.setMessage("Cliente no encontrado. Cédula no existe");
        errors.add(error);

        Gson gson = new Gson();
        String errorsJson = gson.toJson(errors);

        return errorsJson;
    }

    /**
     * Genera un ErrorJson genérico
     *
     * @return error en formato json
     */
    private String generateErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("400");
        error.setError("BAD_REQUEST");
        error.setMessage("Error en la solicitud");
        errors.add(error);

        Gson gson = new Gson();
        String errorJson = gson.toJson(errors);

        return errorJson;
    }

    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void closeStream() throws IOException {
        output.close();
        input.close();
        socket.close();
    }

    /**
     * Convierte el objeto Customer a json para que el servidor lo envie como
     * respuesta por el socket
     *
     * @param customer cliente
     * @return customer en formato json
     */
    private String objectToJSON(Customer customer) {
        Gson gson = new Gson();
        String strObject = gson.toJson(customer);
        return strObject;
    }

    /**
     * Convierte el objeto MainDish a json para que el servidor lo envie como
     * respuesta por el socket
     *
     * @param mainDish plato
     * @return MainDish en formato json
     */
    private String objectToJSONMD(MainDish mainDish) {
        Gson gson = new Gson();
        String strObject = gson.toJson(mainDish);
        return strObject;
    }

    /**
     * Convierte el objeto DishEntry a json para que el servidor lo envie como
     * respuesta por el socket
     *
     * @param dishEntry plato de entrada
     * @return DishEntry en formato json
     */
    private String objectToJSONDE(DishEntry dishEntry) {
        Gson gson = new Gson();
        String strObject = gson.toJson(dishEntry);
        return strObject;
    }

    /**
     * Convierte el objeto Dessert a json para que el servidor lo envie como
     * respuesta por el socket
     *
     * @param Dessert
     * @
     *
     * return
     */
    private String objectToJSOND(Dessert Dessert) {
        Gson gson = new Gson();
        String strObject = gson.toJson(Dessert);
        return strObject;
    }

    /**
     * Convierte el objeto Restaurante a json para que el servidor lo envie como
     * respuesta por el socket
     *
     *
     * @param restaurant restaurante
     * @return Restaurant en formato Json
     */
    private String objectToJSONRE(Restaurant restaurant) {
        Gson gson = new Gson();
        String strObject = gson.toJson(restaurant);
        return strObject;
    }

    /**
     * Covierte el objeto Restaurante a Json para que el servidor lo envie como
     * respuesta por el socket
     *
     * @param restaurant restaurante
     * @return restaurante en formato Json
     */
    private String objectToJSONMRES(Restaurant restaurant) {
        Gson gson = new Gson();
        String strObject = gson.toJson(restaurant);
        return strObject;
    }

    private String objectToJSONRSA(Salad salad) {
        Gson gson = new Gson();
        String strObject = gson.toJson(salad);
        return strObject;
    }
}
