package co.unicauca.onlinerestaurant.server.app;

import co.unicauca.onlinerestaurant.server.infra.OnlineRestaurantServerSocket;

/**
 * Aplicación principal que lanza el servidor en un hilo
 *
 * @author Santiago Acuña
 */
public class OnlineRestaurantApplication {

    public static void main(String args[]) {
        OnlineRestaurantServerSocket server = new OnlineRestaurantServerSocket();
        server.start();
    }
}
