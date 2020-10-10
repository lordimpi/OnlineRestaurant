package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar un repositorio concreto
 *
 * @author Santiago Acuña, Ximena Gallego
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
     * Método que crea una instancia concreta de la jerarquia
     * ICustomerRepository
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public ICustomerRepository getRepository() {
        String type = Utilities.loadProperty("customer.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        ICustomerRepository result = null;

        switch (type) {
            case "default":
                break;
            case "mysql":
                result = new CustomerRepositoryImplMysql();
                break;
        }

        return result;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia
     * ICustomerRepository
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public IMainDishRepository getRepository2() {
        String type = Utilities.loadProperty("maindish.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        IMainDishRepository result = null;

        switch (type) {
            case "default":
                break;
            case "mysql":
                result = new MainDishRepositoryImplMysql();
                break;
        }

        return result;

    }

    public IDishEntryRepository getRepository3() {
        String type = Utilities.loadProperty("dishentry.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        IDishEntryRepository result = null;

        switch (type) {
            case "default":
                break;
            case "mysql":
                result = new DishEntryRepositoryImplMysql();
                break;
        }

        return result;
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IDessertRepository
     *
     * @return una clase hija de la abstracción IRepositorioPostres
     */
    public IDessertRepository getRepository4() {
        String type = Utilities.loadProperty("dessert.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        IDessertRepository result = null;

        switch (type) {
            case "default":
                break;
            case "mysql":
                result = new DessertRepositoryImplMysql();
                break;
        }

        return result;
    }    

    public IRestaurantRepository getRepository5() {
        String type = Utilities.loadProperty("restaurant.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        IRestaurantRepository result = null;

        switch (type) {
            case "default":
                break;
            case "mysql":
                result = new RestaurantRepositoryImplMysql();
                break;
        }

        return result;
    }
    
}
