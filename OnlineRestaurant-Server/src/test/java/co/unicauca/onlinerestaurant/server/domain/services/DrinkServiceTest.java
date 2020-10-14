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
        String id = "1";
        IDrinkRepository repo = Factory.getInstance().getRepositoryDrink();
        DrinkService instance = new DrinkService(repo);
        Drink expResult = new Drink();
        
        expResult.setDrinkPrice(2000);
        expResult.setId_Drink("1");
        expResult.setNameDrink("cerveza poker");
        
        Drink result = instance.findDrink(id);
        assertEquals(expResult.getNameDrink(), result.getNameDrink());
        assertEquals(expResult.getId_Drink(),result.getId_Drink());
    }

//    /**
//     * Test of deleteDrink method, of class DrinkService.
//     */
//    @Test
//    public void testDeleteDrink() {
//        System.out.println("deleteDrink");
//        String id = "12";
//        IDrinkRepository repo = Factory.getInstance().getRepositoryDrink();
//        DrinkService instance = new DrinkService(repo);
//        boolean expResult = true;
//        boolean result = instance.deleteDrink(id);
//        assertEquals(expResult, result);
//    }
}
