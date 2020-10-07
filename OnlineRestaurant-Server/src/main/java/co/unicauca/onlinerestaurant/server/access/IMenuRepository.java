package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Menu;

/**
 * Interface del respositorio de Menu
 *
 * @author Ximena
 */
public interface IMenuRepository {

    /**
     * Busca un Menu por su id
     *
     * @param id cedula del cliente
     * @return objeto de tipo Menu
     */
    public Menu findMenu(String id);

    public int createMenu(Menu menu);
}
