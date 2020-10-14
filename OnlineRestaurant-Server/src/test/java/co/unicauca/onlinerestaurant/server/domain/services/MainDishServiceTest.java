package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;
import co.unicauca.onlinerestaurant.server.access.Factory;
import co.unicauca.onlinerestaurant.server.access.IMainDishRepository;
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
        String id = "1";
        IMainDishRepository repo = Factory.getInstance().getRepository2();
        MainDishService instance = new MainDishService(repo);
        MainDish expResult = new MainDish();
        
        
        expResult.setId_mainDishe("1");
        expResult.setNameDishe("rabano");
        
        MainDish result = instance.findMainDish(id);
        assertEquals(expResult.getNameDishe(), result.getNameDishe());
    }

    /**
     * Test of deleteMainDish method, of class MainDishService.
     */
    @Test
    public void testDeleteMainDish() {
        System.out.println("deleteMainDish");
        String id = "100";
        IMainDishRepository repo = Factory.getInstance().getRepository2();
        MainDishService instance = new MainDishService(repo);
        boolean expResult = true;
        boolean result = instance.deleteMainDish(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateMainDish method, of class MainDishService.
     */
    @Test
    public void testUpdateMainDish() {
        System.out.println("updateMainDish");
        String id = "1";
        String name = "rabano";
        String price = "5000";
        IMainDishRepository repo = Factory.getInstance().getRepository2();
        MainDishService instance = new MainDishService(repo);
        boolean expResult = true;
        boolean result = instance.updateMainDish(id, name, price);
        assertEquals(expResult, result);
    }

    /**
     * Test of createMainDish method, of class MainDishService.
     */
    @Test
    public void testCreateMainDish() {
        System.out.println("createMainDish");
        MainDish mainDish = new MainDish();
        
        mainDish.setDishPrice(10000);
        mainDish.setNameDishe("prubas Server");
        mainDish.setId_mainDishe("100");
        
        IMainDishRepository repo = Factory.getInstance().getRepository2();
        MainDishService instance = new MainDishService(repo);
        boolean expResult = true;
        String result = instance.createMainDish(mainDish);
        assertEquals(expResult, result);
    }

}
