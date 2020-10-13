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
            String sql = "SELECT * from drink where id_drink=? ";
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
    public boolean deleteDrink(String id) {
           
        this.connect();
        try {
            String sql = "DELETE FROM drink where id_drink=? ";
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
    public boolean createDrink(Drink drink) {
    
        try {

            this.connect();
            String sql = "INSERT INTO drink(id_drink, name_drink,drink_price) VALUES (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, drink.getId_Drink());
            pstmt.setString(2,drink.getNameDrink() );
            pstmt.setDouble(3,drink.getDrinkPrice());          
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
      return false;


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
