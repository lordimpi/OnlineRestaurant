package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Dessert;

/**
 *Interfaz de repositorios de los postres
 * 
 * @author Camilo Otaya
 */
public interface IDessertRepository {
    

    /**
     * metodo para buscar un postre
     * @param id
     * @return 
     */
    public Dessert findDessert(String id);

    /**
     * metodo para crear un postre
     * @param dish
     * @return 
     */
    public String createDessert(Dessert dish);
}
