package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.Dessert;
import co.unicauca.onlinerestaurant.server.access.Factory;
import co.unicauca.onlinerestaurant.server.access.IDessertRepository;
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
public class DessertServiceTest {
    
    public DessertServiceTest() {
    }
    /**
     * Test of findDessert method, of class DessertService.
     */
    @Test
    public void testFindDessert() {
        System.out.println("findDessert");
        String id = "1";
        IDessertRepository repo = Factory.getInstance().getRepository4();
        DessertService instance = new DessertService(repo);
        String expResult = "ok";
        Dessert result = instance.findDessert(id);
        assertEquals(expResult, result.getId_Dish_Dessert());
        
        //Buscando un postre ya creado
        result = instance.findDessert("1");
        assertEquals("", result);
    }

    /**
     * Test of createDessert method, of class DessertService.
     */
    @Test
    public void testCreateDessert() {
        System.out.println("createDessert");
        Dessert dish = null;
        IDessertRepository repo = Factory.getInstance().getRepository4();
        DessertService instance = new DessertService(repo);
        String expResult = "";
        String result = instance.createDessert(dish);
        assertEquals(expResult, result);
       
    }
    
}
