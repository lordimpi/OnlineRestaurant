/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;
import co.unicauca.onlinerestaurant.commons.domain.Menu;

/**
 *
 * @author soces
 */
public interface IMenuRepository {

    public Menu findMenu(String id);
    
    public boolean deleteMenu(String id);

    public boolean updateMenu(String id, MainDish md);

    public String createMenu(String id_menu);
    
    public Menu findMenubyRN(String rname);
    
}
