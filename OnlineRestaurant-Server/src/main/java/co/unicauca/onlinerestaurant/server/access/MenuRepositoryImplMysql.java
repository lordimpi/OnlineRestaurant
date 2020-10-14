/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Dessert;
import co.unicauca.onlinerestaurant.commons.domain.DishEntry;
import co.unicauca.onlinerestaurant.commons.domain.Drink;
import co.unicauca.onlinerestaurant.commons.infra.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.unicauca.onlinerestaurant.commons.domain.MainDish;
import co.unicauca.onlinerestaurant.commons.domain.Menu;
import co.unicauca.onlinerestaurant.commons.domain.Salad;
import co.unicauca.onlinerestaurant.server.domain.services.MainDishService;

/**
 * Repositorio de Menu en MySQL
 *
 * @author soces
 */
public class MenuRepositoryImplMysql implements IMenuRepository {

    /**
     *
     * Conección con Mysql
     * 
     */
    private Connection conn;

    /**
     * @param id cedula
     * @return objeto menu, null si no lo encuentra
     *
     */
    @Override
    public Menu findMenu(String id) {
        Menu menu = null;
        MainDish md = null;
        Drink d = null;
        DishEntry de = null;
        Salad s = null;
        Dessert des = null;

        this.connect();
        try {
            String sql = "SELECT * from menu join maindish on menu.id_maindish=maindish.id_dish  join salad on menu.id_salad=salad.idsalad join dishentry on menu.id_entry=dishentry.idDishEntry  join dessert on menu.id_dessert=dessert.id_dessert   join drink on menu.id_drink=drink.id_drink  where id_menu=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                menu = new Menu();
                md = new MainDish();
                d = new Drink();
                de = new DishEntry();
                s = new Salad();
                des = new Dessert();

                md.setId_mainDishe(res.getString("id_dish"));
                md.setDishPrice(res.getDouble("dish_price"));
                md.setNameDishe(res.getString("dish_name"));

                d.setDrinkPrice(res.getDouble("drink_price"));
                d.setId_Drink(res.getString("id_drink"));
                d.setNameDrink(res.getString("drink_name"));

                de.setCostDishEntry(res.getDouble("costDishEntry"));
                de.setIdDishEntry(res.getString("idDishEntry"));
                de.setNameDishEntry(res.getString("nameDishEntry"));

                s.setCostSalad(res.getDouble("pricesalada"));
                s.setIdhSalad(res.getString("idsalad"));
                s.setNameDishSalad(res.getString("namesalad"));

                des.setCost_Dish_Dessert(res.getInt("dessert_price"));
                des.setId_Dish_Dessert(res.getString("id_dessert"));
                des.setName_Dish_Dessert(res.getString("dessert_name"));

                menu.setId_menu(res.getString("id_menu"));
                menu.setMaindish(md);
                menu.setEntry(de);
                menu.setDrink(d);
                menu.setSalad(s);
                menu.setDessert(des);
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Plato de la base de datos", ex);
        }
        return menu;
    }

    /**     
     * Busca un menu por medio del nombre
     * @param name nombre del menu
     * @return objeto menu 
     */
    @Override
    public Menu findMenubyRN(String name) {
        Menu menu = null;
        MainDish md = null;
        Drink d = null;
        DishEntry de = null;
        Salad s = null;
        Dessert des = null;

        this.connect();
        try {
            String sql = "SELECT * from restaurant join menu on restaurant.id_wmenu=menu.id_menu join maindish on menu.id_maindish=maindish.id_dish  join salad on menu.id_salad=salad.idsalad join dishentry on menu.id_entry=dishentry.idDishEntry  join dessert on menu.id_dessert=dessert.id_dessert join drink on menu.id_drink=drink.id_drink  where name_restaurant=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                menu = new Menu();
                md = new MainDish();
                d = new Drink();
                de = new DishEntry();
                s = new Salad();
                des = new Dessert();

                md.setId_mainDishe(res.getString("id_dish"));
                md.setDishPrice(res.getDouble("dish_price"));
                md.setNameDishe(res.getString("dish_name"));

                d.setDrinkPrice(res.getDouble("drink_price"));
                d.setId_Drink(res.getString("id_drink"));
                d.setNameDrink(res.getString("drink_name"));

                de.setCostDishEntry(res.getDouble("costDishEntry"));
                de.setIdDishEntry(res.getString("idDishEntry"));
                de.setNameDishEntry(res.getString("nameDishEntry"));

                s.setCostSalad(res.getDouble("pricesalada"));
                s.setIdhSalad(res.getString("idsalad"));
                s.setNameDishSalad(res.getString("namesalad"));

                des.setCost_Dish_Dessert(res.getInt("dessert_price"));
                des.setId_Dish_Dessert(res.getString("id_dessert"));
                des.setName_Dish_Dessert(res.getString("dessert_name"));

                menu.setId_menu(res.getString("id_menu"));
                menu.setMaindish(md);
                menu.setEntry(de);
                menu.setDrink(d);
                menu.setSalad(s);
                menu.setDessert(des);
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Plato de la base de datos", ex);
        }
        return menu;
    }

    /**
     * Borra un menu de la base de datos
     *
     * @param id Identificador del menu a borrar
     * @return True si pudo borrar el menu, false de lo contrario 
     */
    @Override
    public boolean deleteMenu(String id) {
        this.connect();
        try {
            String sql = "DELETE FROM menu where id_menu=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Plato de la base de datos", ex);
        }
        return false;
    }

    /**
     * 
     * @param id_menu identificador del menu
     * @param id_dish identificador del plato
     * @param id_drink identificador de la bebida
     * @param id_entry identificador del plato de entrada
     * @param id_salad identificador de la ensalada
     * @param id_dessert identificador del postre
     * @return true si pudo modificar el menu, false de lo contrario >>>>>>>
     * 9f2f38a3abd06fb65268fbe1422d9e65c83b9ee9
     */
    @Override
    public boolean updateMenu(String id_menu, String id_dish, String id_drink, String id_entry, String id_salad, String id_dessert) {
        this.connect();
        try {
            String sql = "UPDATE menu SET id_maindish=?,id_drink=?, id_entry=?, id_salad=?, id_dessert=? where id_menu=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id_dish);
            pstmt.setString(2, id_drink);
            pstmt.setString(3, id_entry);
            pstmt.setString(4, id_salad);
            pstmt.setString(5, id_dessert);
            pstmt.setString(6, id_menu);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al actualizar Plato de la base de datos", ex);
        }
        return false;

    }

    /**
     * Crea un menu en la base de datos
     *
     * @param id_menu Identificador del menu
     * @return true si pudo crear el menu, false de lo contrario
     *
     */
    @Override
    public boolean createMenu(String id_menu) {
        this.connect();
        try {
            String sql = "INSERT INTO menu(id_menu) VALUES (?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id_menu);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Plato de la base de datos", ex);
        }

        return false;

    }

    /**
     * 
     * Permite hacer la conexion con la base de datos
     *
     * @return 1 si pudo conectarse, -1 de lo contrario
     */
    public int connect() {
        try {
            Class.forName(Utilities.loadProperty("server.db.driver"));
            //crea una instancia de la controlador de la base de datos
            String url = Utilities.loadProperty("server.db.url");
            String username = Utilities.loadProperty("server.db.username");
            String pwd = Utilities.loadProperty("server.db.password");
            conn = DriverManager.getConnection(url, username, pwd);
            return 1;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Plato de la base de datos", ex);
        }
        return -1;
    }

    /**
     * Cierra la conexion con la base de datos
     *
     */
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.FINER, "Error al cerrar Connection", ex);
        }
    }
}
