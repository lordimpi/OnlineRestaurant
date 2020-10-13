/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Drink;

/**
 *
 * @author Mariat Trujillo
 */
public interface IDrinkRepository {
    
    public Drink findDrink(String id);

    public boolean createDrink(Drink drink);
    
    public boolean deleteDrink(String id);

    
}
