/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.onlinerestaurant.client.access.ISaladAccess;
import co.unicauca.onlinerestaurant.commons.domain.Salad;

/**
 *
 * @author soces
 */
public class SaladService {
    
     private final ISaladAccess service;
     
     public SaladService(ISaladAccess service) {
        this.service = service;
    }
     
    public Salad findSalad(String id) throws Exception {
        return service.findSalad(id);

    }
    
}
