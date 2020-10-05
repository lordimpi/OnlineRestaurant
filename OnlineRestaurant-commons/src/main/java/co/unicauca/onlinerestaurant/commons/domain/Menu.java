package co.unicauca.onlinerestaurant.commons.domain;

/**
 * Menu del restaurante
 *
 * @author Ximena
 */
public class Menu {

    /**
     * Id menu
     */
    private int idMenu;

    /**
     * Entrada
     */
    private String entry;
    /**
     * Ensalada
     */
    private String salad;
    /**
     * platos Principales
     */
    private String mainDishes;
    /**
     * postre
     */
    private String dessert;
    /**
     * Bebida
     */
    private String drink;

    /**
     * Constructor por defecto
     */
    public Menu() {
    }

    /**
     * Constructor
     *
     * @param idMenu idmenu
     * @param entry entrada
     * @param salad ensalada
     * @param mainDishes platos principales
     * @param dessert postre
     * @param drink bebida
     */
    public Menu(int idMenu, String entry, String salad, String mainDishes, String dessert, String drink) {
        this.idMenu = idMenu;
        this.entry = entry;
        this.salad = salad;
        this.mainDishes = mainDishes;
        this.dessert = dessert;
        this.drink = drink;
    }

    //Getters and Setters
    public int getIdMenu() {
        return idMenu;
    }

    public String getEntry() {
        return entry;
    }

    public String getSalad() {
        return salad;
    }

    public String getMainDishes() {
        return mainDishes;
    }

    public String getDessert() {
        return dessert;
    }

    public String getDrink() {
        return drink;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public void setSalad(String salad) {
        this.salad = salad;
    }

    public void setMainDishes(String mainDishes) {
        this.mainDishes = mainDishes;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

}
