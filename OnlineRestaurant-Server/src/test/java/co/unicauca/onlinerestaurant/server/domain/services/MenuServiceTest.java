package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.Menu;
import co.unicauca.onlinerestaurant.server.access.Factory;
import co.unicauca.onlinerestaurant.server.access.IMenuRepository;
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
public class MenuServiceTest {
    
    public MenuServiceTest() {
    }
    /**
     * Test of findMenu method, of class MenuService.
     */
    @Test
    public void testFindMenu() {
        System.out.println("findMenu");
        String id = "1";
        IMenuRepository repo = Factory.getInstance().getRepositoryMenu();
        MenuService instance = new MenuService(repo);
        String expResult = "ok";
        Menu result = instance.findMenu(id);
        assertEquals(expResult, result.getId_menu());
       
        //Buscando uno ya creado
        result = instance.findMenu("1");
        assertEquals("", result);
        
        
    }

    /**
     * Test of findMenubyRN method, of class MenuService.
     */
    @Test
    public void testFindMenubyRN() {
        System.out.println("findMenubyRN");
        String name = "Mr. Pollo";
        IMenuRepository repo = Factory.getInstance().getRepositoryMenu();
        MenuService instance = new MenuService(repo);
        String expResult = "ok";
        Menu result = instance.findMenubyRN(name);
        assertEquals(expResult, result.getId_menu());
        
        //Buscando uno ya creado
        result = instance.findMenubyRN("1");
        assertEquals("", result);
    }
    /**
     * Test of updateMenu method, of class MenuService.
     */
    @Test
    public void testUpdateMenu() {
        System.out.println("updateMenu");
        String id_menu = "";
        String id_dish = "";
        String id_drink = "";
        String id_entry = "";
        String id_salad = "";
        String id_dessert = "";
        IMenuRepository repo = Factory.getInstance().getRepositoryMenu();
        MenuService instance = new MenuService(repo);
        boolean expResult = true;
        boolean result = instance.updateMenu(id_menu, id_dish, id_drink, id_entry, id_salad, id_dessert);
        assertEquals(expResult, result);
    }

    /**
     * Test of createMenu method, of class MenuService.
     */
    @Test
    public void testCreateMenu() {
        System.out.println("createMenu");
        String id_menu = "10";
        IMenuRepository repo = Factory.getInstance().getRepositoryMenu();
        MenuService instance = new MenuService(repo);
        String expResult = "ok";
        String result = instance.createMenu(id_menu);
        assertEquals(expResult, result);
        
        //Creando uno ya creado
        result = instance.createMenu("1");
        assertEquals("", result);
    }
    
     /**
     * Test of deleteMenu method, of class MenuService.
     */
    @Test
    public void testDeleteMenu() {
        System.out.println("deleteMenu");
        String id = "10";
        IMenuRepository repo = Factory.getInstance().getRepositoryMenu();
        MenuService instance = new MenuService(repo);
        boolean expResult = true;
        boolean result = instance.deleteMenu(id);
        assertEquals(expResult, result);
    }
}
