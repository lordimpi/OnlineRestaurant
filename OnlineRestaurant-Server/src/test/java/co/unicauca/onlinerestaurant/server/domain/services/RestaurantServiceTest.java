/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.Restaurant;
import co.unicauca.onlinerestaurant.server.access.Factory;
import co.unicauca.onlinerestaurant.server.access.IRestaurantRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Santiago Acuña
 */
public class RestaurantServiceTest {

    public RestaurantServiceTest() {
    }
//
//    /**
//     * Test of findRestaurant method, of class RestaurantService.
//      */
//    @Test
//    public void testListRestaurant() {
//        System.out.println("listRestaurant");
//        List<Restaurant> Restaurants = new ArrayList<>();
//        List<Restaurant> Resperado = new ArrayList<>();
//        Restaurants.add(new Restaurant("1", "Pedro parrilla", "calle 23 5-21", "3213342118", "10"));
//        Restaurants.add(new Restaurant("2", "Sabores de mi Tierra", "calle 23 5-31", "3124447771", "20"));
//
//        IRestaurantRepository repo = Factory.getInstance().getRepository5();
//        RestaurantService instance = new RestaurantService(repo);
//        Resperado = instance.listRestaurant();
//        
//        assertEquals(Resperado.get(0).getIdRestaurant(), Restaurants.get(0).getIdRestaurant());
//        assertEquals(Resperado.get(0).getNameRestaurant(), Restaurants.get(0).getNameRestaurant());
//        assertEquals(Resperado.get(0).getAddressRestaurant(), Restaurants.get(0).getAddressRestaurant());
//        assertEquals(Resperado.get(0).getPhone(), Restaurants.get(0).getPhone());
//        assertEquals(Resperado.get(0).getIdmenu(), Restaurants.get(0).getIdmenu());
//        
//        assertEquals(Resperado.get(1).getIdRestaurant(), Restaurants.get(1).getIdRestaurant());
//        assertEquals(Resperado.get(1).getNameRestaurant(), Restaurants.get(1).getNameRestaurant());
//        assertEquals(Resperado.get(1).getAddressRestaurant(), Restaurants.get(1).getAddressRestaurant());
//        assertEquals(Resperado.get(1).getPhone(), Restaurants.get(1).getPhone());
//        assertEquals(Resperado.get(1).getIdmenu(), Restaurants.get(1).getIdmenu());
//    }

}
