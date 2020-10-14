/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.client.infra.OnlineRestaurantSocket;
import co.unicauca.onlinerestaurant.commons.domain.Salad;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soces
 */
public class SaladAccessImplSockets implements ISaladAccess {

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private OnlineRestaurantSocket mySocket;

    public SaladAccessImplSockets() {
        mySocket = new OnlineRestaurantSocket();
    }

    /**
     * Busca un Customer. Utiliza socket para pedir el servicio al servidor
     *
     * @param id del postre para el menú
     * @return Objeto Postre
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public Salad findSalad (String id) throws Exception {
        String jsonResponse = null;
        String requestJson = findSaladRequestJson(id);
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
                //Encontró el postre
                Salad salad = jsonToSalad(jsonResponse);
                return salad;
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
     *
     * @param idCustomer identificación del cliente
     * @return solicitud de consulta del cliente en formato Json, algo como:
     * {"resource":"customer","action":"get","parameters":[{"name":"id","value":"98000001"}]}
     */
    private String findSaladRequestJson(String idDessert) {

        Protocol protocol = new Protocol();
        protocol.setResource("salad");
        protocol.setAction("get");
        protocol.addParameter("id_salad", idDessert);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Convierte jsonCustomer, proveniente del server socket, de json a un
     * objeto Customer
     *
     * @param jsonDessert objeto cliente en formato json
     */
    private Salad jsonToSalad(String jsonSalad) {

        Gson gson = new Gson();
        Salad salad = gson.fromJson(jsonSalad, Salad.class);

        return salad;

    }


}
