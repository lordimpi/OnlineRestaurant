/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.domain.DishEntry;

/**
 *
 * @author soces
 */
public interface IEntryAccess {
      /**
     * Buscar un postre utilizando un socket
     *
     * @param id identificado del postre principal
     * @return objeto postre
     * @throws Exception error al buscar un plato
     */
    public DishEntry findEntry(String id) throws Exception;
    
}
