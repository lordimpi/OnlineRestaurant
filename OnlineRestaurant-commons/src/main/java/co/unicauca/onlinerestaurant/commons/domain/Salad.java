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
public class Salad {

    /**
     * Identificador
     */
    private String idSalad;
    /**
     * Nombre
     */
    private String nameSalad;
    /**
     * valor
     */
    private double costSalad;

    public String getIdSalad() {
        return idSalad;
    }

    public void setIdhSalad(String idSalad) {
        this.idSalad = idSalad;
    }

    public String getNameSalad() {
        return nameSalad;
    }

    public void setNameDishSalad(String nameSalad) {
        this.nameSalad = nameSalad;
    }

    public double getCostSalad() {
        return costSalad;
    }

    public void setCostSalad(double costSalad) {
        this.costSalad = costSalad;
    }

}
