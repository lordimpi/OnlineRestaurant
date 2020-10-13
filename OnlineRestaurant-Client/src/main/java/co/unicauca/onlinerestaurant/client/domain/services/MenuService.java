/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.onlinerestaurant.client.access.IMenuAccess;
import co.unicauca.onlinerestaurant.commons.domain.Menu;

/**
 * 
 * @author Santiago Acuña
 */
public class MenuService {
    
    private final IMenuAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IMainDishService
     */
    public MenuService(IMenuAccess service) {
        this.service = service;
    }

    /**
     * Busca un plato en el servidor remoto
     *
     * @param id identificador del plato
     * @return Objeto tipo Plato, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Menu findMenu(String id) throws Exception {
        return service.findMenu(id);

    }
    
    public Menu findbyMenubyRN(String name) throws Exception {
        return service.findMenubyRN(name);

    }

    public boolean updateMenu(String id, String id_dish,String id_drink,String id_entry,String id_salad,String id_dessert) throws Exception {
        return service.updateMenu(id, id_dish,id_drink,id_entry,id_salad,id_dessert);
    }

    public boolean deleteMenu(String id) throws Exception {
        return service.deleteMenu(id);
    }

    public boolean createMenu(String id) throws Exception {
        return service.createMenu(id);
    }


}
