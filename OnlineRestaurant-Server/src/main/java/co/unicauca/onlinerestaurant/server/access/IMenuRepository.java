/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;
import co.unicauca.onlinerestaurant.commons.domain.Menu;

/**
 * Interface del respositorio de Menu
 * @author soces
 */
public interface IMenuRepository {
    /**
     * Busca un menu por su ID
     * @param id identificador 
     * @return objeto de tipo menu
     */
    public Menu findMenu(String id);
    /**
     * Elimina un menu por su id
     * @param id identificador
     * @return true o false 
     */
    public boolean deleteMenu(String id);
    /**
     * Actualiza menu
     * @param id_menu idmenu
     * @param id_dish  idPlato
     * @param id_drink id bebida
     * @param id_entry  idEntrada
     * @param id_salad   idensalada
     * @param id_dessert idpostre
     * @return true o false
     */
    public boolean updateMenu(String id_menu,String id_dish,String id_drink,String id_entry,String id_salad,String id_dessert);
   
    public String createMenu(String id_menu);
    
    public Menu findMenubyRN(String rname);
    
}
