/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;
import co.unicauca.onlinerestaurant.commons.domain.Menu;

 /**
 * Interfaz de repositorios de Menus
 *
 * @author soces
 */
public interface IMenuRepository {

    /**
     * Declaracion del metodo buscar plato
     *
     * @param id Identificador de un menu
     * @return un menu
     */
    public Menu findMenu(String id);

    /**
     * Declaracion del metodo elimar menu
     *
     * @param id identificador del menu
     * @return true si pudo borrar, false de lo contrario
     */
    public boolean deleteMenu(String id);

    /**
     * Declaracion del metodo actualizar menu
     *
     * @param id_menu identificador del menu
     * @param id_dish identificador del plato
     * @param id_drink identificador de la bebida
     * @param id_entry identificador del plato de entrada
     * @param id_salad identificador de la ensalada
     * @param id_dessert identificador del postre
     * @return true si pudo actualizar, false de lo contrario
     */
    public boolean updateMenu(String id_menu, String id_dish, String id_drink, String id_entry, String id_salad, String id_dessert);

    /**
     * Declaracion del metodo crear menu
     *
     * @param id_menu identificador del menu
     * @return true si pudo crear el menu, false de lo contrario
     */
    public boolean createMenu(String id_menu);

    /**
     * Declaracion del metodo buscar menu por medio del nombre del restaurante
     *
     * @param rname Nombre del restaurante
     * @return objeto tipo menu
     */

    public Menu findMenubyRN(String rname);

}
