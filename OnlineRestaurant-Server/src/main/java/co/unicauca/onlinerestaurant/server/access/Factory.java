package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar un repositorio concreto
 *
 * @author Santiago Acuña, Ximena Gallego,Alejandro Rodriguez
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
     * IMainDishRepository
     *
     * @return una clase hija de la abstracción IMainDishRepository
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

    /**
     * Método que crea una instancia concreta de la jerarquia
     * IDishEntryRepository
     *
     * @return una clase hija de la abstracción IDishEntryRepository
     */
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

    /**
     * Método que crea una instancia concreta de la jerarquia
     * IRestaurantRepository
     *
     * @return una clase hija de la abstracción IRepositorioRestaurantes
     */
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

    public ISaladRepository getRepository6() {
        String type = Utilities.loadProperty("salad.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        ISaladRepository result = null;

        switch (type) {
            case "default":
                break;
            case "mysql":
                result = new SaladRepositoryImplMysql();
                break;
        }
        return result;
    }

    public IDrinkRepository getRepositoryDrink() {
        String type = Utilities.loadProperty("drink.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        IDrinkRepository result = null;

        switch (type) {
            case "default":
                break;
            case "mysql":
                result = new DrinkRepositoryImplMysql();
                break;
        }

        return result;
    }

    public IMenuRepository getRepositoryMenu() {
        String type = Utilities.loadProperty("menu.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        IMenuRepository result = null;

        switch (type) {
            case "default":
                break;
            case "mysql":
                result = new MenuRepositoryImplMysql();
                break;
        }
        return result;
    }


}
