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
     * identificador del menu
     */
    private String id_menu;
    /**
     * identificador del plato principal
     */
    private MainDish maindish;
    
    //getters y setters

    public String getId_menu() {
        return id_menu;
    }

    public void setId_menu(String id_menu) {
        this.id_menu = id_menu;
    }

    public MainDish getMaindish() {
        return maindish;
    }

    public void setMaindish(MainDish maindish) {
        this.maindish = maindish;
    }
    
    
    
}
