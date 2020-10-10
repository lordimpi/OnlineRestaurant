package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Dessert;

/**
 *Interfaz de repositorios de los postres
 * 
 * @author Camilo Otaya
 */
public interface IDessertRepository {

    public Dessert findDessert(String id);

    public String createDessert(Dessert dish);
}
