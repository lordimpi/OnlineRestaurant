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
     * @param restaurant de tipo restaurant 
     * @return cadena 
     */
    public String createRestaurant(Restaurant restaurant);
    /**
     *  Metodo encargado de actualizar un restaurante 
     * @param id identificador de restaurante
     * @return 
     */
    public String updateDish(String id);
    /**
     * Metodo encargado de remover un restaurante 
     * @param id identificador 
     * @return true o false 
     */
    public boolean removeRestaurant(String id);
    /**
     * Metodo encargado de lista objetos de tipo restaurante
     * @return 
     */
    public List<Restaurant> list();

}
