package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.domain.Drink;

/**
 *
 * @author Mariat Trujillo
 */
public interface IDrinkAccess {
    /**
     * Buscar un cliente utilizando un socket
     *
     * @param id identificado de la bebida principal
     * @return objeto bebida
     * @throws Exception error al buscar un plato
     */
    public Drink findDrink(String id) throws Exception;
    public boolean deleteDrink(String id) throws Exception;

    /**
     * Crea un Customer
     *
     * @param Drink bebida del restaurante
     * @return devuelve el id de la bebida creada
     * @throws Exception error crear el plato
     */
    public boolean createDrink(Drink drink) throws Exception;
    
    
    
}
