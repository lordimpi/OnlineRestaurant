package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;
import co.unicauca.onlinerestaurant.commons.infra.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago Acuña
 */
public class MainDishRepositoryImplMysql implements IMainDishRepository {

    /**
     * Conección con Mysql
     */
    private Connection conn;

    public MainDishRepositoryImplMysql() {
    }     
    
    /**
     * Busca en la bd un plato
     *
     * @param id identificador de plato
     * @return objeto plato, null si no lo encuentra
     */
    @Override
    public MainDish findDish(String id) {
            
        MainDish mainDish = null;

        this.connect();
        try {
            String sql = "SELECT * from maindish where id_dish=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                mainDish = new MainDish();
                mainDish.setId_mainDishe(res.getString("id_dish"));
                mainDish.setNameDishe(res.getString("dish_name"));
                mainDish.setDishPrice(res.getDouble("dish_price"));
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Plato de la base de datos", ex);
        }
        return mainDish;
        
    }

    @Override
    public String createDish(MainDish dish) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Permite actualizar un plato en la base de datos 
     * @param id identificador del plato
     * @return cadena
     */
    @Override
    public String updateDish(String id) {
        //UPDATE `maindish` SET `id_dish`=[value-1],`dish_name`=[value-2],`dish_price`=[value-3] WHERE 1
        MainDish mainDish = null;

        this.connect();
        try {
            String sql = "UPDATE maindish SET id_dish="+"?"+"dish_name="+"?"+"dish_price="+"?"+"where=";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                mainDish = new MainDish();
                mainDish.setId_mainDishe(res.getString("id_dish"));
               // mainDish.setNameDishe(res.getString("dish_name"));
                //mainDish.setDishPrice(res.getDouble("dish_price"));
                return "id_dish="+mainDish.getId_mainDishe()+"dish_name="+mainDish.getNameDishe()+"dish_price="+mainDish.getDishPrice();
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al actualizar Plato de la base de datos", ex);
        }
        return mainDish.getId_mainDishe();
        
    }
        /**
     * Permite hacer la conexion con la base de datos
     *
     * @return
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