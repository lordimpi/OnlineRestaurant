package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Dish_Dessert;

/**
 *Interfaz de repositorios de los postres
 * 
 * @author Camilo Otaya
 */
public interface IDish_DessertRepository {

    public Dish_Dessert findDessert(String id);

    public String createDessert(Dish_Dessert dish);
}
