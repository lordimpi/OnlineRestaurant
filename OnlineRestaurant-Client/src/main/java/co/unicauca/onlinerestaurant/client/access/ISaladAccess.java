/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.domain.Salad;

/**
 *
 * @author soces
 */
public interface ISaladAccess {

    public Salad findSalad(String id)throws Exception;
    
}
