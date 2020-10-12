/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.Drink;
import co.unicauca.onlinerestaurant.server.access.Factory;
import co.unicauca.onlinerestaurant.server.access.IDrinkRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mariat Trujillo
 */
public class DrinkServiceTest {
    
    public DrinkServiceTest() {
    }
    /**
     * Test of findDrink method, of class DrinkService.
     */
    @Test
    public void testFindDrink() {
        System.out.println("findDrink");
        String id = "";
        IDrinkRepository repo = Factory.getInstance().getRepositoryDrink();
        DrinkService instance = new DrinkService(repo);
        String expResult = "ok";
        Drink result = instance.findDrink(id);
        assertEquals(expResult, result.getId_Drink());
    }

    /**
     * Test of deleteDrink method, of class DrinkService.
     */
    @Test
    public void testDeleteDrink() {
        System.out.println("deleteDrink");
        String id = "2";
        IDrinkRepository repo = Factory.getInstance().getRepositoryDrink();
        DrinkService instance = new DrinkService(repo);
        boolean expResult = true;
        boolean result = instance.deleteDrink(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of createDrink method, of class DrinkService.
     */
    @Test
    public void testCreateDrink() {
        System.out.println("createDrink");
        Drink drink = null;
        IDrinkRepository repo = Factory.getInstance().getRepositoryDrink();
        DrinkService instance = new DrinkService(repo);
        String expResult = "ok";
        String result = instance.createDrink(drink);
        assertEquals(expResult, result);
    }
    
}
