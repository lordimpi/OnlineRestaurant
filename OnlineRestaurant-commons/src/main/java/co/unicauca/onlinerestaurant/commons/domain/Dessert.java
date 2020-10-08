/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.commons.domain;

/**
 *
 * @author alejo
 */
public class Dessert {
        /**
     * Identificacion
     */
    private String id_Dish_Dessert;
    /**
     * Nombre
     */
    private String name_Dish_Dessert;
    /**
     * valor
     */
    private int cost_Dish_Dessert;

    public String getId_Dish_Dessert() {
        return id_Dish_Dessert;
    }

    public void setId_Dish_Dessert(String id_Dish_Dessert) {
        this.id_Dish_Dessert = id_Dish_Dessert;
    }

    public String getName_Dish_Dessert() {
        return name_Dish_Dessert;
    }

    public void setName_Dish_Dessert(String name_Dish_Dessert) {
        this.name_Dish_Dessert = name_Dish_Dessert;
    }

    public int getCost_Dish_Dessert() {
        return cost_Dish_Dessert;
    }

    public void setCost_Dish_Dessert(int cost_Dish_Dessert) {
        this.cost_Dish_Dessert = cost_Dish_Dessert;
    }
    
}
