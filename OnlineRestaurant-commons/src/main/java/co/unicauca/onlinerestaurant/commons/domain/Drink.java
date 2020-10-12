package co.unicauca.onlinerestaurant.commons.domain;

/**
 *
 * @author alejo
 */
public class Drink {
   
    private String id_Drink;
    
    private String nameDrink;
    
    private double drinkPrice;

    public Drink(String id_Drink, String nameDrink, double drinkPrice) {
        this.id_Drink = id_Drink;
        this.nameDrink = nameDrink;
        this.drinkPrice = drinkPrice;
    }

    public Drink() {
    }

    public String getId_Drink() {
        return id_Drink;
    }

    public void setId_Drink(String id_Drink) {
        this.id_Drink = id_Drink;
    }

    public String getNameDrink() {
        return nameDrink;
    }

    public void setNameDrink(String nameDrink) {
        this.nameDrink = nameDrink;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    
}
