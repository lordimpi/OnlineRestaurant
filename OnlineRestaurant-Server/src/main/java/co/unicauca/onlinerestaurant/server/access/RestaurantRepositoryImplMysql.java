package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Restaurant;
import co.unicauca.onlinerestaurant.commons.infra.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Repositorio de Restaurante en MySQL
 *
 * @author Ximena Gallego
 */
public class RestaurantRepositoryImplMysql implements IRestaurantRepository{
    /**
     * Conección con Mysql
     */
    private Connection conn;
    /**
     * Constructor por defecto 
     */
    public RestaurantRepositoryImplMysql() {

    }
   
    @Override
    public Restaurant findRestaurant(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String createRestaurant(Restaurant restaurant) {
           try {

            this.connect();
            String sql = "INSERT INTO Restaurant(idRestaurant, restaurantName, restaurantDirection, phone) VALUES (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, restauran.getId());
//            pstmt.setString(2, customer.getFirstName());
//            pstmt.setString(3, customer.getLastName());
//            pstmt.setString(4, customer.getAddress());
//            pstmt.setString(5, customer.getMobile());
//            pstmt.setString(6, customer.getEmail());
//            pstmt.setString(7, customer.getGender());

            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro de restaurnat", ex);
        }
        return restaurant.getId();
    }

    @Override
    public boolean removeRestaurant(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Restaurant> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
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
