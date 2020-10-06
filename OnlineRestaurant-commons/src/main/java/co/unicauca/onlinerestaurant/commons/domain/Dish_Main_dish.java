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
public class Dish_Main_dish{
    /**
     * Identificador
     */
     private String id_Dish_Main_Dish;
    /**
     * Nombre
     */
    private String name_Dish_Main_Dish;
    /**
     * valor
     */
    private int cost_Dish_Main_Dish;

    public String getId_Dish_Main_Dish() {
        return id_Dish_Main_Dish;
    }

    public void setId_Dish_Main_Dish(String id_Dish_Main_Dish) {
        this.id_Dish_Main_Dish = id_Dish_Main_Dish;
    }

    public String getName_Dish_Main_Dish() {
        return name_Dish_Main_Dish;
    }

    public void setName_Dish_Main_Dish(String name_Dish_Main_Dish) {
        this.name_Dish_Main_Dish = name_Dish_Main_Dish;
    }

    public int getCost_Dish_Main_Dish() {
        return cost_Dish_Main_Dish;
    }

    public void setCost_Dish_Main_Dish(int cost_Dish_Main_Dish) {
        this.cost_Dish_Main_Dish = cost_Dish_Main_Dish;
    }

    
}
