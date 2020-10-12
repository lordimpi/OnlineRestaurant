package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mariat Trujillo
 */
public class MainDishServiceTest {
    
    public MainDishServiceTest() {
    }
    /**
     * Test of findMainDish method, of class MainDishService.
     */
    @Test
    public void testFindMainDish() {
        System.out.println("findMainDish");
        String id = "";
        MainDishService instance = null;
        MainDish expResult = null;
        MainDish result = instance.findMainDish(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteMainDish method, of class MainDishService.
     */
    @Test
    public void testDeleteMainDish() {
        System.out.println("deleteMainDish");
        String id = "";
        MainDishService instance = null;
        boolean expResult = false;
        boolean result = instance.deleteMainDish(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateMainDish method, of class MainDishService.
     */
    @Test
    public void testUpdateMainDish() {
        System.out.println("updateMainDish");
        String id = "";
        String name = "";
        String price = "";
        MainDishService instance = null;
        boolean expResult = false;
        boolean result = instance.updateMainDish(id, name, price);
        assertEquals(expResult, result);
    }

    /**
     * Test of createMainDish method, of class MainDishService.
     */
    @Test
    public void testCreateMainDish() {
        System.out.println("createMainDish");
        MainDish mainDish = null;
        MainDishService instance = null;
        String expResult = "";
        String result = instance.createMainDish(mainDish);
        assertEquals(expResult, result);
    }
    
}
