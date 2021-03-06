package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Restaurant;
import java.util.List;

/**
 * Interface del respositorio de Restaurante
 *
 * @author Ximena Gallego
 */
public interface IRestaurantRepository {

    /**
     * Busca un restaurante por ide del restaurante
     *
     * @param id identificador del restaurante
     * @return objeto de tipo restaurante
     */
    public Restaurant findRestaurant(String id);

    /**
     * metodo encargado de crear un restaurante
     *
     * @param restaurant de tipo restaurant
     * @return true si pudo crear
     */
    public boolean createRestaurant(Restaurant restaurant);

    /**
     * Metodo encargado de actualizar un restaurante
     *
     * @param id identificador restaurante
     * @param name nombre restaurante
     * @param address direccion
     * @param phone telefono
     * @param idmenu id del menu
     * @return true si pudo actualizar, false de lo contrario
     */
    public boolean updateRestaurant(String id, String name, String address, String phone, String idmenu);

    /**
     * Metodo encargado de remover un restaurante
     *
     * @param id identificador
     * @return true si pudo remover, false de lo contrario
     */
    public boolean removeRestaurant(String id);

    /**
     * Metodo encargado de lista objetos de tipo restaurante
     *
     * @return Lista de restaurantes
     */
    public List<Restaurant> list();

}
