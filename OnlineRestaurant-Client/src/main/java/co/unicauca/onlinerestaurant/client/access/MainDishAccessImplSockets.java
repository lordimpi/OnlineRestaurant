package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.client.infra.OnlineRestaurantSocket;
import co.unicauca.onlinerestaurant.commons.domain.MainDish;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago Acuña
 */
public class MainDishAccessImplSockets implements IMainDishAccess {

    private OnlineRestaurantSocket mySocket;

    public MainDishAccessImplSockets() {

        this.mySocket = new OnlineRestaurantSocket();
    }

    /**
     * Busca un Plato. Utiliza socket para pedir el servicio al servidor
     *
     * @param id identificador del plato
     * @return Objeto MainDish
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public MainDish findMainDish(String id) throws Exception {

        String jsonResponse = null;
        String requestJson = findMainDishRequestJson(id);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(CustomerAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(CustomerAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el customer
                MainDish mainDish = jsonToMainDish(jsonResponse);
                return mainDish;
            }
        }

    }
    
    @Override
    public MainDish updateMainDish(String id, String name, String price) throws Exception {

        String jsonResponse = null;
        String requestJson = updateMainDishRequestJson(id,name,price);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(CustomerAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(CustomerAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el customer
                MainDish mainDish = jsonToMainDish(jsonResponse);
                return mainDish;
            }
        }

    }
    

    @Override
    public String createMainDish(MainDish mainDish) throws Exception {

        String jsonResponse = null;
        String requestJson = createMainDishRequestJson(mainDish);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(MainDishAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(MainDishAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del customer 
                return mainDish.getId_mainDishe();
            }

        }

    }

    /**
     * Extra los mensajes de la lista de errores
     *
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    /**
     * Convierte el jsonError a un array de objetos jsonError
     *
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     * @param idMainDish identificación del plato
     * @return solicitud de consulta del cliente en formato Json, algo como:
     * {"resource":"maindish","action":"get","parameters":[{"name":"id","value":"98000001"}]}
     */
    private String findMainDishRequestJson(String idMainDish) {

        Protocol protocol = new Protocol();
        protocol.setResource("maindish");
        protocol.setAction("get");
        protocol.addParameter("id_dish", idMainDish);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }
    /**
     * crea una solicitud json para ser enviada por el socket
     * @param idMainDish
     * @return 
     */
    
     private String updateMainDishRequestJson(String id,String name, String price) {

        Protocol protocol = new Protocol();
        protocol.setResource("maindish");
        protocol.setAction("set");
        protocol.addParameter("id_dish",id);
        protocol.addParameter("name",name);
        protocol.addParameter("price",price);
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }
    

    /**
     * Crea la solicitud json de creación del maindish para ser enviado por el
     * socket
     *
     * @param mainDish objeto customer
     * @return devulve algo como:
     * {"resource":"maindish","action":"post","parameters":[{"name":"id","value":"980000012"},{"name":"fistName","value":"Juan"},...}]}
     */
    private String createMainDishRequestJson(MainDish mainDish) {

        Protocol protocol = new Protocol();
        protocol.setResource("maindish");
        protocol.setAction("post");
        protocol.addParameter("id_dish", mainDish.getId_mainDishe());
        protocol.addParameter("dish_name", mainDish.getNameDishe());
        protocol.addParameter("dish_price", Double.toString(mainDish.getDishPrice()));

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }

    /**
     * Convierte jsonMainDish, proveniente del server socket, de json a un
     * objeto MainDish
     *
     * @param jsonMainDish objeto cliente en formato json
     */
    private MainDish jsonToMainDish(String jsonMainDish) {

        Gson gson = new Gson();
        MainDish mainDish = gson.fromJson(jsonMainDish, MainDish.class);

        return mainDish;

    }

}
