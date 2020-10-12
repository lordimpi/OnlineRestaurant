/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.Salad;
import co.unicauca.onlinerestaurant.server.access.Factory;
import co.unicauca.onlinerestaurant.server.access.ISaladRepository;
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
public class SaladServiceTest {
    
    public SaladServiceTest() {
    }

    /**
     * Test of findSalad method, of class SaladService.
     */
    @Test
    public void testFindSalad() {
        System.out.println("findSalad");
        String id = "2";
        ISaladRepository repo = Factory.getInstance().getRepository6();
        SaladService instance = new SaladService(repo);
        String expResult = "ok";
        Salad result = instance.findSalad(id);
        assertEquals(expResult, result.getIdSalad());
    }

    /**
     * Test of createSalad method, of class SaladService.
     */
    @Test
    public void testCreateSalad() {
        System.out.println("createSalad");
        Salad salad = null;
        ISaladRepository repo = Factory.getInstance().getRepository6();
        SaladService instance = new SaladService(repo);
        String expResult = "ok";
        String result = instance.createSalad(salad);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateSalad method, of class SaladService.
     */
    @Test
    public void testUpdateSalad() {
        System.out.println("updateSalad");
        String id = "2";
        String name = "ensalada cesar";
        Double cost = null;
        ISaladRepository repo = Factory.getInstance().getRepository6();
        SaladService instance = new SaladService(repo);
        boolean expResult = true;
        boolean result = instance.updateSalad(id, name, cost);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteSalad method, of class SaladService.
     */
    @Test
    public void testDeleteSalad() {
        System.out.println("deleteSalad");
        String id = "1";
        ISaladRepository repo = Factory.getInstance().getRepository6();
        SaladService instance = new SaladService(repo);
        boolean expResult = true;
        boolean result = instance.deleteSalad(id);
        assertEquals(expResult, result);
    }
    
}
