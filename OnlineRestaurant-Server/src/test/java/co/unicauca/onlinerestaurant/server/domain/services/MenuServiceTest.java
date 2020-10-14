package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.Menu;
import co.unicauca.onlinerestaurant.server.access.Factory;
import co.unicauca.onlinerestaurant.server.access.IMenuRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mariat Trujillo
 */
public class MenuServiceTest {
    
    public MenuServiceTest() {
    }
//    /**
//     * Test of findMenu method, of class MenuService.
//     */
//    @Test
//    public void testFindMenu() {
//        System.out.println("findMenu");
//        String id = "1";
//        IMenuRepository repo = Factory.getInstance().getRepositoryMenu();
//        MenuService instance = new MenuService(repo);
//        Menu expResult = new Menu();
//        
//        expResult.setId_menu("1");
//        
//        Menu result = instance.findMenu(id);
//        assertEquals(expResult.getId_menu(), result.getId_menu());
//       
//        //Buscando uno ya creado
//        result = instance.findMenu("10");
//        assertEquals(null, result);
//        
//        
//    }
//
//    /**
//     * Test of findMenubyRN method, of class MenuService.
//     */
//    @Test
//    public void testFindMenubyRN() {
//        System.out.println("findMenubyRN");
//        String name = "mister pollo";
//        IMenuRepository repo = Factory.getInstance().getRepositoryMenu();
//        MenuService instance = new MenuService(repo);
//       
//        Menu expResult =new Menu();
//        expResult.setId_menu("1");
//        Menu result = instance.findMenubyRN(name);
//        assertEquals(expResult.getId_menu(), result.getId_menu());
//        
//        //Buscando uno no existente
//        result = instance.findMenubyRN("1");
//        assertEquals(null, result);
//    }
//    /**
//     * Test of updateMenu method, of class MenuService.
//     */
//    @Test
//    public void testUpdateMenu() {
//        System.out.println("updateMenu");
//        String id_menu = "1";
//        String id_dish = "1";
//        String id_drink = "1";
//        String id_entry = "1";
//        String id_salad = "1";
//        String id_dessert = "1";
//        IMenuRepository repo = Factory.getInstance().getRepositoryMenu();
//        MenuService instance = new MenuService(repo);
//        boolean expResult = true;
//        boolean result = instance.updateMenu(id_menu, id_dish, id_drink, id_entry, id_salad, id_dessert);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of createMenu method, of class MenuService.
//     */
//    @Test
//    public void testCreateMenu() {
//        System.out.println("createMenu");
//        String id_menu = "17";
//        IMenuRepository repo = Factory.getInstance().getRepositoryMenu();
//        MenuService instance = new MenuService(repo);
//        boolean expResult = true;
//        boolean result = instance.createMenu(id_menu);
//        assertEquals(expResult, result);
//    }
//    
//     /**
//     * Test of deleteMenu method, of class MenuService.
//     */
//    @Test
//    public void testDeleteMenu() {
//        System.out.println("deleteMenu");
//        String id = "15";
//        IMenuRepository repo = Factory.getInstance().getRepositoryMenu();
//        MenuService instance = new MenuService(repo);
//        boolean expResult = true;
//        boolean result = instance.deleteMenu(id);
//        assertEquals(expResult, result);
//    }
}
