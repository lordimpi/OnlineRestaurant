package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar CustomerServiceImplSockets o cualquier
 * otro que se cree en el futuro.
 *
 * @author Santiago Acuña
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia ICustomerService
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public ICustomerAccess getCustomerService() {

        ICustomerAccess result = null;
        String type = Utilities.loadProperty("customer.service");

        switch (type) {
            case "default":
                result = new CustomerAccessImplSockets();
                break;
        }

        return result;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IMainDishService
     *
     * @return una clase hija de la abstracción IRepositorioPlatoPrincipal
     */
    public IMainDishAccess getMainDishService() {

        IMainDishAccess result = null;
        String type = Utilities.loadProperty("maindish.service");

        switch (type) {
            case "default":
                result = new MainDishAccessImplSockets();
                break;
        }

        return result;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IDessertService
     *
     * @return una clase hija de la abstracción IRepositorioPostre
     */
    public IDessertAccess getDessertService() {

        IDessertAccess result = null;
        String type = Utilities.loadProperty("dessert.service");

        switch (type) {
            case "default":
                result = new DessertAccessImplSockets();
                break;
        }

        return result;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IRestaurantService
     *
     * @return una clase hija de la abstracción IRepositorioRestaurante
     */
    public IRestaurantAccess getRestaurantService() {

        IRestaurantAccess result = null;
        String type = Utilities.loadProperty("restaurant.service");

        switch (type) {
            case "default":
                result = new RestaurantAccessImplSockets();
                break;
        }

        return result;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IRestaurantService
     *
     * @return una clase hija de la abstracción IRepositorioRestaurante
     */
    public IMenuAccess getMenuService() {

        IMenuAccess result = null;
        String type = Utilities.loadProperty("restaurant.service");

        switch (type) {
            case "default":
                result = new MenuAccessImplSockets();
                break;
        }

        return result;
    }
}
