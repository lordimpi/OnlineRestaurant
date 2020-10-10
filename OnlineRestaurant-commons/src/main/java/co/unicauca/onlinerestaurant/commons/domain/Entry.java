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
public class Entry  {
    /**
     * Identificador
     */
     private String id_Dish_Entry;
    /**
     * Nombre
     */
    private String name_Dish_Entry;
    /**
     * valor
     */
    private int cost_Dish_Entry;

    public String getId_Dish_Entry() {
        return id_Dish_Entry;
    }

    public void setId_Dish_Entry(String id_Dish_Entry) {
        this.id_Dish_Entry = id_Dish_Entry;
    }

    public String getName_Dish_Entry() {
        return name_Dish_Entry;
    }

    public void setName_Dish_Entry(String name_Dish_Entry) {
        this.name_Dish_Entry = name_Dish_Entry;
    }

    public int getCost_Dish_Entry() {
        return cost_Dish_Entry;
    }

    public void setCost_Dish_Entry(int cost_Dish_Entry) {
        this.cost_Dish_Entry = cost_Dish_Entry;
    }

    
}
