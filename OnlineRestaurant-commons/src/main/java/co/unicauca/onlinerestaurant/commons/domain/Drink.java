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
public class Drink {
    private String id_drink;
    /**
     * Nombre
     */
    private String name_drink;
    /**
     * valor
     */
    private int cost_drink;

    public String getId_drink() {
        return id_drink;
    }

    public void setId_drink(String id_drink) {
        this.id_drink = id_drink;
    }

    public String getName_drink() {
        return name_drink;
    }

    public void setName_drink(String name_drink) {
        this.name_drink = name_drink;
    }

    public int getCost_drink() {
        return cost_drink;
    }

    public void setCost_drink(int cost_drink) {
        this.cost_drink = cost_drink;
    }
    
    
}
