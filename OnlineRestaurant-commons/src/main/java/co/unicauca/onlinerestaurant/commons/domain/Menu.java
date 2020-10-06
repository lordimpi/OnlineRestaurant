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
    Dish_Dessert Dessert;
    Dish_Entry Entry;
    Dish_Main_dish Main_Dish;
    Dish_Salad Salad;
    Drink Drink;
    String Id_menu;
    int Total_cost;

    public Menu(Dish_Dessert Dessert, Dish_Entry Entry, Dish_Main_dish Main_Dish, Dish_Salad Salad, Drink Drink, String Id_menu) {
        this.Dessert = Dessert;
        this.Entry = Entry;
        this.Main_Dish = Main_Dish;
        this.Salad = Salad;
        this.Drink = Drink;
        this.Id_menu = Id_menu;
        this.Total_cost();
    }
    
    
    public Dish_Dessert getDessert() {
        return Dessert;
    }

    public void setDessert(Dish_Dessert Dessert) {
        this.Dessert = Dessert;
    }

    public Dish_Entry getEntry() {
        return Entry;
    }

    public void setEntry(Dish_Entry Entry) {
        this.Entry = Entry;
    }

    public Dish_Main_dish getMain_Dish() {
        return Main_Dish;
    }

    public void setMain_Dish(Dish_Main_dish Main_Dish) {
        this.Main_Dish = Main_Dish;
    }

    public Dish_Salad getSalad() {
        return Salad;
    }

    public void setSalad(Dish_Salad Salad) {
        this.Salad = Salad;
    }

    public Drink getDrink() {
        return Drink;
    }

    public void setDrink(Drink Drink) {
        this.Drink = Drink;
    }

    public String getId_menu() {
        return Id_menu;
    }

    public void setId_menu(String Id_menu) {
        this.Id_menu = Id_menu;
    }

    public int getTotal_cost() {
        return Total_cost;
    }

    private void Total_cost() {
        this.Total_cost = this.Dessert.getCost_Dish_Dessert()+this.Drink.getCost_drink()+this.Entry.getCost_Dish_Entry()+this.Main_Dish.getCost_Dish_Main_Dish()+this.Salad.getCost_Dish_Salad();
    }
    
    
    
}
