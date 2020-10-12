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
 *
 * @author soces
 */
public class MenuRepositoryImplMysql implements IMenuRepository {

    private Connection conn;
    
    
    @Override
    public Menu findMenu(String id) {
      Menu menu = null;
      MainDish md=null;
      Drink d=null;
      DishEntry de=null;
      Salad s=null;
      Dessert des=null;
      
        this.connect();
        try {
            String sql = "SELECT * from menu join maindish on menu.id_maindish=maindish.id_dish  join salad on menu.id_salad=salad.idsalad join dishentry on menu.id_entry=dishentry.idDishEntry  join dessert on menu.id_dessert=dessert.id_dessert   join drink on menu.id_drink=drink.id_drink  where id_menu=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                menu = new Menu();
                md=new MainDish();
                d=new Drink();
                de=new DishEntry();
                s=new Salad();
                des=new Dessert();
                
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
    
     @Override
    public Menu findMenubyRN(String name) {
      Menu menu = null;
      MainDish md=null;
      Drink d=null;
      DishEntry de=null;
      Salad s=null;
      Dessert des=null;
      
        this.connect();
        try {
            String sql = "SELECT * from restaurant join menu on restaurant.id_wmenu=menu.id_menu join maindish on menu.id_maindish=maindish.id_dish  join salad on menu.id_salad=salad.idsalad join dishentry on menu.id_entry=dishentry.idDishEntry  join dessert on menu.id_dessert=dessert.id_dessert join drink on menu.id_drink=drink.id_drink  where name_restaurant=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                menu = new Menu();
                md=new MainDish();
                d=new Drink();
                de=new DishEntry();
                s=new Salad();
                des=new Dessert();
                
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

    @Override
    public boolean updateMenu(String id, MainDish md) {
       String id_dish;
       id_dish=md.getId_mainDishe();
       this.connect();
        try {
            String sql = "UPDATE menu SET id_dish=? where id_dish=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id_dish );
            pstmt.setString(2, id);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al actualizar Plato de la base de datos", ex);
        }
        return false;
       
    }

    @Override
    public String createMenu(String id_menu) {
        this.connect();
        try {
            String sql = "INSERT INTO menu(id_menu) VALUES (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id_menu);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Plato de la base de datos", ex);
        }

        return "";
    
    
    }
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
