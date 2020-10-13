/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.server.domain.services;
import co.unicauca.onlinerestaurant.commons.domain.Menu;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.server.access.IMenuRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
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
     * Metodo busqueda de plato principal
     *
     * @param id
     * @return
     */
    public Menu findMenu(String id) {
        return repo.findMenu(id);
    }
    
    
    public Menu findMenubyRN(String name) {
        return repo.findMenubyRN(name);
    }

    public boolean deleteMenu(String id) {
        return repo.deleteMenu(id);
    }

    /**
     * Metodo encargado de actualizar un plato
     *
    * @param id identificador
     * @param name nombre
     * @param price precio
     */
    public boolean updateMenu(String id_menu,String id_dish,String id_drink,String id_entry,String id_salad,String id_dessert) {
        return repo.updateMenu(id_menu,id_dish,id_drink,id_entry,id_salad,id_dessert);
    }

    /**
     * Crea un nuevo mainDish. Aplica validaciones de negocio
     *
     * @param mainDish plato
     * @return devuelve el id del plato creado
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
