package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.domain.Restaurant;

/**
 * Interface que define los servicios de persistencia del Restaurante
 *
 * @author Santiago Acuña
 */
public interface IRestaurantAccess {

    /**
     * Buscar un restaurante utilizando un socket
     *
     * @param id del restaurante
     * @return objeto restaurante
     * @throws Exception error al buscar un restaurante
     */
    public Restaurant findRestaurant(String id) throws Exception;

    /**
     * Crea un Restaurante
     *
     * @param restaurant restaurante
     * @return devuelve el del restaurante creado
     * @throws Exception error crear el restaurante
     */
    public String createCustomer(Restaurant restaurant) throws Exception;

}
