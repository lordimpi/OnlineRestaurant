package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.domain.Menu;

/**
 * Interface que define los servicios de persistencia del Menu
 *
 * @author Santiago Acuña
 */
public interface IMenuAccess {

    public Menu findMenu(String id) throws Exception;

    public Menu findMenubyRN(String name) throws Exception;
    
    public boolean updateMenu(String id, String id_dish) throws Exception;

    public boolean deleteMenu(String id) throws Exception;

    public String createMenu(String id) throws Exception;

}
