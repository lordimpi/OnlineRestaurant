package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Dessert;

/**
 * Interfaz de repositorios de los postres
 *
 * @author Camilo Otaya
 */
public interface IDessertRepository {

    /**
     * metodo para buscar un postre
     *
     * @param id identificador del postre
     * @return obejot tipo postre
     */
    public Dessert findDessert(String id);

}
