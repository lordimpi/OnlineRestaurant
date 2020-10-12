/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.DishEntry;
import co.unicauca.onlinerestaurant.server.access.Factory;
import co.unicauca.onlinerestaurant.server.access.IDishEntryRepository;
import java.util.List;
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
public class DishEntryServiceTest {
    
    public DishEntryServiceTest() {
    }
    /**
     * Test of findDishEntry method, of class DishEntryService.
     */
    @Test
    public void testFindDishEntry() {
        System.out.println("findDishEntry");
        String id = "1";
        IDishEntryRepository repo = Factory.getInstance().getRepository3();
        DishEntryService instance = new DishEntryService(repo);
        String expResult = "ok";
        DishEntry result = instance.findDishEntry(id);
        assertEquals(expResult, result.getIdDishEntry());
        
        //Buscando uno ya creado
        result = instance.findDishEntry("1");
        assertEquals("", result);
        
    }

    /**
     * Test of createDishEntry method, of class DishEntryService.
     */
    @Test
    public void testCreateDishEntry() {
        System.out.println("createDishEntry");
        DishEntry dishentry = null;
        IDishEntryRepository repo = Factory.getInstance().getRepository3();
        DishEntryService instance = new DishEntryService(repo);
        String expResult = "ok";
        String result = instance.createDishEntry(dishentry);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of listDishEntry method, of class DishEntryService.
     */
    @Test
    public void testListDishEntry() {
        System.out.println("listDishEntry");
        IDishEntryRepository repo = Factory.getInstance().getRepository3();
        DishEntryService instance = new DishEntryService(repo);
        List<DishEntry> expResult = null;
        List<DishEntry> result = instance.listDishEntry();
        assertEquals(expResult, result);
    }
    
}
