/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;
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

    public void deleteMenu(String id) {
        repo.deleteMenu(id);
    }

    /**
     * Metodo encargado de actualizar un plato
     *
    * @param id identificador
     * @param name nombre
     * @param price precio
     */
    public void updateMenu(String id, MainDish md) {
        repo.updateMenu(id, md);
    }

    /**
     * Crea un nuevo mainDish. Aplica validaciones de negocio
     *
     * @param mainDish plato
     * @return devuelve el id del plato creado
     */
    public String createMenu(String id_menu) {
        List<JsonError> errors = new ArrayList<>();
        // Validaciones y reglas de negocio
        if (id_menu.isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "id, nombre y precio son obligatorios. "));
        }
        // Que no esté repetido
        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }
        return repo.createMenu(id_menu);
    }
}