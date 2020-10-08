/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.commons.domain;

/**
 *
 * @author soces
 */
public class Menu {
    /**
     * Id del menu
     */
    private int IdMenu;
    private String Entry;
    private String Salad;
    private String MainDish;
    private String Drink;
    private String Dessert; 

    public int getIdMenu() {
        return IdMenu;
    }

    public void setIdMenu(int IdMenu) {
        this.IdMenu = IdMenu;
    }

    public String getEntry() {
        return Entry;
    }

    public void setEntry(String Entry) {
        this.Entry = Entry;
    }

    public String getSalad() {
        return Salad;
    }

    public void setSalad(String Salad) {
        this.Salad = Salad;
    }

    public String getMainDish() {
        return MainDish;
    }

    public void setMainDish(String MainDish) {
        this.MainDish = MainDish;
    }

    public String getDrink() {
        return Drink;
    }

    public void setDrink(String Drink) {
        this.Drink = Drink;
    }

    public String getDessert() {
        return Dessert;
    }

    public void setDessert(String Dessert) {
        this.Dessert = Dessert;
    }
    
    
}
