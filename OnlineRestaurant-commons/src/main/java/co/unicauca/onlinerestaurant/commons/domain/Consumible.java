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
public abstract class Consumible {
    
     private String id;
    
    private String name;
    private double Price;

    public Consumible(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.Price = price;
    }

    public Consumible() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    

    
}
