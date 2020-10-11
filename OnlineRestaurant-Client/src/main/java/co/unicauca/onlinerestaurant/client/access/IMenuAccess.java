package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.domain.Menu;

/**
 * Interface que define los servicios de persistencia del Menu
 *
 * @author Santiago Acuña
 */
public interface IMenuAccess {

    public Menu findMenu(String id) throws Exception;

    public void updateMenu(String id, String id_dish) throws Exception;

    public void deleteMenu(String id) throws Exception;

    public String createMenu(String id) throws Exception;

}
