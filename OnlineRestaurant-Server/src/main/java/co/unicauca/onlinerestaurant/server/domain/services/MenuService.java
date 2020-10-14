package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.Menu;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.server.access.IMenuRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de Menu. Da acceso a la lógica de negocio
 *
 * @author soces
 */
public class MenuService {

    /**
     * Repositorio de platos
     */
    IMenuRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo IMainDishRepository
     */
    public MenuService(IMenuRepository repo) {
        this.repo = repo;
    }

    /**
     * Metodo de busqueda de plato principal
     *
     * @param id identificador del plato
     * @return objeto de tipo menu
     */
    public Menu findMenu(String id) {
        return repo.findMenu(id);
    }

    /**
     * Metodo que busca un menu por medio del nombre del restaurante
     *
     * @param name nombre del restaurante
     * @return true si lo encontro, false de lo contrario
     */
    public Menu findMenubyRN(String name) {
        return repo.findMenubyRN(name);
    }

    /**
     * Metodo que eliminar un menu
     *
     * @param id identificador del menu
     * @return true si pudo borrar, false de lo contrario
     */
    public boolean deleteMenu(String id) {
        return repo.deleteMenu(id);
    }

    /**
     * Metodo encargado de actualizar un plato
     *
     * @param id_menu identificador del menu
     * @param id_dish identificador del plato principal
     * @param id_drink identificador de la bebida
     * @param id_entry identificador el plato de entrada
     * @param id_salad identificador de la ensalada
     * @param id_dessert identificador del postre
     * @return true si pudo actualizar, false de lo contrario
     */
    public boolean updateMenu(String id_menu, String id_dish, String id_drink, String id_entry, String id_salad, String id_dessert) {
        return repo.updateMenu(id_menu, id_dish, id_drink, id_entry, id_salad, id_dessert);
    }

    /**
     * Crea un nuevo mainDish.Aplica validaciones de negocio
     *
     * @param id_menu identificador del menu
     * @return true si pudo crear, false de lo contrario
     */
    public boolean createMenu(String id_menu) {
        List<JsonError> errors = new ArrayList<>();
        // Validaciones y reglas de negocio
        if (id_menu.isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "id, nombre y precio son obligatorios. "));
        }
        // Que no esté repetido
        if (!errors.isEmpty()) {
            return false;
        }
        return repo.createMenu(id_menu);
    }
}
