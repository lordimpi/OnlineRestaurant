package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Administrator;
import co.unicauca.onlinerestaurant.commons.infra.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Repositorio de Administrador en MySQL
 *
 * @author Ximena
 */
public class AdministratorRepositoryImplMysql implements IAdministratorRepository {

    /**
     * Conección con Mysql
     */
    private Connection conn;

    /**
     * Constructor parametrizado
     */
    public AdministratorRepositoryImplMysql() {
    }

    @Override
    public Administrator findAdmistrator(String id) {
        Administrator adm = null;

        this.connect();
        try {
            String sql = "SELECT * from administrator where idAdministrador=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                adm = new Administrator();
                adm.setIdAdministrador(res.getInt("idAdministrador"));
                adm.setNombreAdm(res.getString("nombreAdm"));
                adm.setApellidoadm(res.getString("apellidoadm"));
                adm.setMobile(res.getString("mobile"));
                adm.setUserAdm(res.getString("userAdm"));
                adm.setPassword(res.getString("password"));                
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Administrador de la base de datos", ex);
        }
        return adm;
    }

    @Override
    public int createAdministrator(Administrator adm) {
       try {

            this.connect();
            String sql = "INSERT INTO administrator(idAdministrador, nombreAdm, apellidoadm, mobile, userAdm, password) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, adm.getIdAdministrador());
            pstmt.setString(2, adm.getNombreAdm());
            pstmt.setString(3, adm.getApellidoadm());
            pstmt.setString(4, adm.getMobile());
            pstmt.setString(5, adm.getUserAdm());
            pstmt.setString(6, adm.getPassword());

            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return adm.getIdAdministrador();
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
