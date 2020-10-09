package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Dish_Dessert;
import co.unicauca.onlinerestaurant.commons.infra.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Repositorio de postres en MySQL
 *
 * @author Camilo Otaya Bravo
 */
public class Dish_DessertRepositoryImplMysql implements IDish_DessertRepository {

    /**
     * Conección con Mysql
     */
    private Connection conn;

    /**
     * Constructor por defecto
     */
    public Dish_DessertRepositoryImplMysql() {

    }

    /**
     * busca en la base de datos un postre
     *
     * @param id identificador del postre
     * @return objeto postre, null si no lo encuentra
     */
    @Override
    public Dish_Dessert findDessert(String id) {
        Dish_Dessert dishdessert = null;

        this.connect();
        try {
            String sql = "SELECT * from desserts where id_dessert=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                dishdessert = new Dish_Dessert();
                dishdessert.setId_Dish_Dessert(res.getString("id_dessert"));
                dishdessert.setName_Dish_Dessert(res.getString("dessert_name"));
                dishdessert.setCost_Dish_Dessert(res.getInt("dessert_cost"));

            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Dish_DessertRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar el postre de la base de datos", ex);
        }
        return dishdessert;
    }
    /**
     * crea en la base de datos un postre
     * 
     * @param dish
     * @return 
     */

    
    @Override
    public String  createDessert(Dish_Dessert dish) {
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
