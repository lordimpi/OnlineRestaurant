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
    public Menu findMenuDish(String id) throws Exception {
        return service.findMenu(id);

    }

    public void updateMenu(String id, String id_dish) throws Exception {
        service.updateMenu(id, id_dish);
    }

    public void deleteMenu(String id) throws Exception {
        service.deleteMenu(id);
    }

    public String createMenu(String id) throws Exception {
        return service.createMenu(id);
    }


}
