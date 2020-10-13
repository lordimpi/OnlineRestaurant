package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.DishEntry;
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
 * Repositorio platos de entrada Mysql
 *
 * @author Ximena Gallego
 */
public class DishEntryRepositoryImplMysql implements IDishEntryRepository {
      /**
     * Conección con Mysql
     */
    private Connection conn;
    /**
     * Constructor por defecto
     */
    public DishEntryRepositoryImplMysql() {
   
    }
    /**
     * Metodo encargado de buscar un plato de entrada en BD     
     * @param id identificador de plato de entrada
     * @return un objeto de plato de entrada 
     */
    @Override
    public DishEntry findDishEntry(String id) {
        DishEntry dishEntry = null;

        this.connect();
        try {
            String sql = "SELECT * from dishentry where idDishEntry=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                dishEntry = new DishEntry();
                dishEntry.setIdDishEntry(res.getString("idDishEntry"));
                dishEntry.setNameDishEntry(res.getString("nameDishEntry"));
                dishEntry.setCostDishEntry((int) res.getDouble("costDishEntry"));               

            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar plato de entrada de la base de datos", ex);
        }
        return dishEntry;
    }

    @Override
    public boolean createDish(DishEntry entry) {
        try {

            this.connect();
            String sql = "INSERT INTO dishentry(idDishEntry, nameDishEntry, costDishEntry) VALUES (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, entry.getIdDishEntry());
            pstmt.setString(2, entry.getNameDishEntry());
            pstmt.setDouble(3, entry.getCostDishEntry());         
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return false;
    }

    @Override
    public boolean deleteDishEntry(int id) {
        try {

            this.connect();
            String sql = "DELETE FROM dishentry WHERE=";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);           
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al Eliminar el registro", ex);
        }
        return false;
    }

    @Override
    public List<DishEntry> listDishEntry() {
        List<DishEntry> DishEntry = new ArrayList<>();
        try {

            String sql = "SELECT idDishEntry, nameDishEntry, costDishEntry from dishentry";
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();            
            while (res.next()) {
                DishEntry newDishEntry = new DishEntry();
                newDishEntry.setIdDishEntry(res.getString("idDishEntry"));
                newDishEntry.setNameDishEntry(res.getString("nameDishEntry"));
                newDishEntry.setCostDishEntry((int) res.getDouble("costDishEntry"));
                DishEntry.add(newDishEntry);                
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al Selecionar los datos de platos de Entrada de la base de datos", ex);
        }
        return DishEntry; 
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
