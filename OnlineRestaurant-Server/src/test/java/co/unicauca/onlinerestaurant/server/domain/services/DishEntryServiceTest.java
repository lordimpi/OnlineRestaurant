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
        DishEntry expResult = new DishEntry();

        expResult.setIdDishEntry("1");
        expResult.setNameDishEntry("salchichitas");

        DishEntry result = instance.findDishEntry(id);
        assertEquals(expResult.getIdDishEntry(), result.getIdDishEntry());
        assertEquals(expResult.getNameDishEntry(), result.getNameDishEntry());

        //Buscando uno ya creado
        result = instance.findDishEntry("90");
        assertEquals(null, result);

    }

}
