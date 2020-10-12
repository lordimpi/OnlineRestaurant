package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Drink;
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
 * @author Mariat Trujillo
 */
public class DrinkRepositoryImplMysql implements IDrinkRepository{
    /**
     * Conección con Mysql
     */
    private Connection conn;

    public DrinkRepositoryImplMysql() {
    }
    
    
    
    /**
     * Busca en la bd una bebida
     *
     * @param id identificador de la bebida
     * @return objeto plato, null si no lo encuentra
     */
    @Override
    public Drink findDrink(String id) {
            
        Drink drink = null;

        this.connect();
        try {
            String sql = "SELECT * from maindish where id_dish=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                drink = new Drink();
                drink.setId_Drink(res.getString("id_drink"));
                drink.setNameDrink(res.getString("drink_name"));
                drink.setDrinkPrice(res.getDouble("drink_price"));
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Plato de la base de datos", ex);
        }
        return drink;
        
    }
    @Override
    public void deleteDrink(String id) {
            
        Drink drink = null;

        this.connect();
        try {
            String sql = "DELETE FROM maindish where id_dish=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Plato de la base de datos", ex);
        }
    }

    @Override
    public String createDrink(Drink drink) {
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
