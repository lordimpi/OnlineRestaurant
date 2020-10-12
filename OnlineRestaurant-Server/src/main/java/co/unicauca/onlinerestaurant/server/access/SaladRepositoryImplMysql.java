package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Salad;
import co.unicauca.onlinerestaurant.commons.infra.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Repositorio de Ensalada en MySQL
 *
 * @author Ximena
 */
public class SaladRepositoryImplMysql implements ISaladRepository {

    /**
     * Conección con Mysql
     */
    private Connection conn;

    /**
     * Constructor por defecto
     */
    public SaladRepositoryImplMysql() {
    }

    /**
     * Metodo encargado de Buscar Ensalada
     *
     * @param id
     * @return
     */
    @Override
    public Salad findSalad(String id) {
        Salad salad = null;
        this.connect();
        try {
            String sql = "SELECT * from salad where idsalad=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                salad = new Salad();
                salad.setIdhSalad(res.getString("idsalad"));
                salad.setNameDishSalad(res.getString("namesalad"));
                salad.setCostSalad(res.getDouble("pricesalada"));
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Ensalada de la base de datos", ex);
        }
        return salad;
    }

    /**
     * Metodo encargado de crear Ensalada
     *
     * @param id identificador
     * @param name nombre
     * @param cost costo
     * @return
     */
    @Override
    public String createSalad(String id, String name, double cost) {
        this.connect();
        try {
            String sql = "INSERT INTO salad(idsalad, namesalad, pricesalada) VALUES (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, cost);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Ensalada de la base de datos", ex);
        }
        return "";
    }

    /**
     * Metodo encargado de Actualizar Ensalada
     *
     * @param id identificador
     * @param name nombre
     * @param cost costo
     */
    @Override
    public boolean updateSalad(String id, String name, double cost) {
        this.connect();
        try {
            String sql = "UPDATE salad SET namesalad=" + "?" + ", pricesalada=" + "?" + "where idsalad=" + "?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setDouble(2, cost);
            pstmt.setString(3, id);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al actualizar Ensalada de la base de datos", ex);
        }
        return false;
    }

    /**
     * Metodo encargado de Eliminar Ensalada
     *
     * @param id identificador
     */
    @Override
    public boolean deleteSalad(String id) {  
        this.connect();
        try {
            String sql = "DELETE FROM salad where idsalad=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al Eliminar ensalada de la base de datos", ex);
        }
        return false;
    }

    /**
     * Permite hacer la conexion con la base de datos
     *
     * @return
     */
    private int connect() {
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
    private void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.FINER, "Error al cerrar Connection", ex);
        }
    }

}
