package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Menu;
import co.unicauca.onlinerestaurant.commons.domain.Restaurant;
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

/**
 * Repositorio de Restaurante en MySQL
 *
 * @author Ximena Gallego
 */
public class RestaurantRepositoryImplMysql implements IRestaurantRepository {

    /**
     * Conección con Mysql
     */
    private Connection conn;

    /**
     * Constructor por defecto
     */
    public RestaurantRepositoryImplMysql() {

    }

    /**
     * Metodo encargado de buscar un restaurante
     *
     * @param id identificador del restaurante
     * @return objeto de tipo restaurante
     */
    @Override
    public Restaurant findRestaurant(String id) {
        Restaurant restaurant = null;
        Menu wmenu=null;
        this.connect();
        try {
            String sql = "SELECT * from restaurant where id=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                restaurant = new Restaurant();
                restaurant.setIdRestaurant(res.getString("idres"));
                restaurant.setNameRestaurant(res.getString("nameres"));
                restaurant.setAddressRestaurant(res.getString("addressres"));
                restaurant.setAddressRestaurant(res.getString("phoneres"));
              //  restaurant.setIdmenu(res.getString("idmenu"));

            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Restauran de la base de datos", ex);
        }
        return restaurant;
    }

    /**
     * Metodo que permite crear un restaurante
     *
     * @param restaurant restaurante
     * @return cadena
     */
    @Override
    public String createRestaurant(Restaurant restaurant) {
        try {

            this.connect();
            String sql = "INSERT INTO Restaurant(idRes, nameres,addressres, phoneres,idmenu) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, restaurant.getIdRestaurant());
            pstmt.setString(2, restaurant.getNameRestaurant());
            pstmt.setString(3, restaurant.getAddressRestaurant());
            pstmt.setString(4, restaurant.getPhone());
          //  pstmt.setString(5, restaurant.getIdmenu());

            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro de restaurnat", ex);
        }
        return restaurant.getIdRestaurant();
    }

    /**
     * Metodo que perimite para actualizar un restaurante
     *
     * @param id identificador del restaurante
     * @param name nombre del restaurante
     * @param address direcion
     * @param phone telefono
     * @param idmenu id del menu
     * @return
     */
    @Override
    public boolean updateRestaurant(String id, String name, String address, String phone, String idmenu) {

        this.connect();
        try {
            String sql = "UPDATE restaurant SET nameres=" + "?" + ", addressres=" + "?" + ",phoneres=" + "?" + ", idmenu=" + "?" + "where idres=" + "?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, phone);
            pstmt.setString(4, idmenu);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al actualizar Restaurante en la base de datos", ex);
        }
        return false;
    }

    /**
     * Metodo encargado de eliminara un restaurante
     *
     * @param id
     * @return
     */
    @Override
    public boolean removeRestaurant(String id) {
        try {

            this.connect();
            String sql = "DELETE FROM Restaurant WHERE= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al Eliminar un registro de restaurnat", ex);
        }
        return false;
    }

    /**
     * metodo que perimte listar los restaurantes
     *
     * @return list
     */
    @Override
    public List<Restaurant> list() {
        List<Restaurant> restaurants = new ArrayList<>();
        try {

            String sql = "SELECT * FROM restaurant";
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                Restaurant newrestaurant = new Restaurant();

                newrestaurant.setIdRestaurant(res.getString("idres"));
                newrestaurant.setNameRestaurant(res.getString("nameres"));
                newrestaurant.setAddressRestaurant(res.getString("addressres"));
                newrestaurant.setPhone(res.getString("phoneres"));
               // newrestaurant.setIdmenu(res.getString("idmenu"));

                restaurants.add(newrestaurant);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al Selecionar los datos de la tabla restaurant de la base de datos", ex);
        }
        return restaurants;
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
