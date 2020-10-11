package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.Restaurant;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.server.access.IRestaurantRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de Restaurante. Da acceso a la lógica de negocio
 *
 * @author Ximena
 */
public class RestaurantService {

    /**
     * Repositorio de Restaurante
     */
    IRestaurantRepository repo;

    /**
     * Constructor parametrizado
     *
     * @param repo repositorio de tipo IRestaurantRepository
     */
    public RestaurantService(IRestaurantRepository repo) {
        this.repo = repo;
    }

    /**
     * Metodo que busca un restaurante
     *
     * @param id identificador restaurante
     * @return
     */
    public Restaurant findRestaurant(String id) {
        return repo.findRestaurant(id);
    }
    
    public List<Restaurant> listRestaurant(){
        return repo.list();
    }
    
    /**
     * Metodo para crear un restaurante
     *
     * @param restaurant tipo restaurante
     * @return cadena
     */
    public String createRestaurant(Restaurant restaurant) {
        List<JsonError> errors = new ArrayList<>();

        String id = restaurant.getIdRestaurant();
        String name = restaurant.getNameRestaurant();
        String direccion = restaurant.getAddressRestaurant();
        String telefono = restaurant.getPhone();
        String idmenu = restaurant.getPhone();
        // Validaciones y reglas de negocio
        if (id.isEmpty() || restaurant.getNameRestaurant().isEmpty()
                || direccion.isEmpty() || telefono.isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "id, nombre, direcion y relefono son obligatorios. "));
        }
        // Que no esté repetido
        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }
        return repo.createRestaurant(restaurant);
    }

    /**
     * Metodo de actualizar un restaurante
     *
     * @param id identificador del restaurante
     * @param name nombre
     * @param address direccion
     * @param phone telefono
     * @param idmenu id del menu
     */
    public void updateRestaurant(String id, String name, String address, String phone, String idmenu) {
        repo.updateRestaurant(id, name, address, phone, idmenu);
    }

    /**
     * Metodo de eliminar un restaurante
     *
     * @param id identificador
     */
    public void removeRestaurant(String id) {
        repo.removeRestaurant(id);
    }

}
