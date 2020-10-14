package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.Restaurant;
import co.unicauca.onlinerestaurant.server.access.Factory;
import co.unicauca.onlinerestaurant.server.access.IRestaurantRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Santiago Acuña
 */
public class RestaurantServiceTest {

    public RestaurantServiceTest() {
    }

    /**
     * Test of listRestaurant method, of class RestaurantService.
     */
    @Test
    public void testListRestaurant() {

        System.out.println("listRestaurant");
        List<Restaurant> Restaurants = new ArrayList<>();
        List<Restaurant> Resperado = new ArrayList<>();
        Restaurants.add(new Restaurant("1", "mister pollo", "calle 50", "312333222", "1"));
        Restaurants.add(new Restaurant("7", "Andres carne de res", "carrera 12 con calle 10", "312333222", "7"));

        IRestaurantRepository repo = Factory.getInstance().getRepository5();
        RestaurantService instance = new RestaurantService(repo);
        Resperado = instance.listRestaurant();

        assertEquals(Resperado.get(0).getIdRestaurant(), Restaurants.get(0).getIdRestaurant());
        assertEquals(Resperado.get(0).getNameRestaurant(), Restaurants.get(0).getNameRestaurant());
        assertEquals(Resperado.get(0).getAddressRestaurant(), Restaurants.get(0).getAddressRestaurant());
        assertEquals(Resperado.get(0).getPhone(), Restaurants.get(0).getPhone());
        assertEquals(Resperado.get(0).getIdmenu(), Restaurants.get(0).getIdmenu());

        assertEquals(Resperado.get(Resperado.size() - 1).getIdRestaurant(), Restaurants.get(Restaurants.size() - 1).getIdRestaurant());
        assertEquals(Resperado.get(Resperado.size() - 1).getNameRestaurant(), Restaurants.get(Restaurants.size() - 1).getNameRestaurant());
        assertEquals(Resperado.get(Resperado.size() - 1).getAddressRestaurant(), Restaurants.get(Restaurants.size() - 1).getAddressRestaurant());
        assertEquals(Resperado.get(Resperado.size() - 1).getPhone(), Restaurants.get(Restaurants.size() - 1).getPhone());
        assertEquals(Resperado.get(Resperado.size() - 1).getIdmenu(), Restaurants.get(Restaurants.size() - 1).getIdmenu());
    }

}
