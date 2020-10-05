package co.unicauca.onlinerestaurant.server.access;


import co.unicauca.onlinerestaurant.commons.domain.Menu;
import co.unicauca.onlinerestaurant.commons.infra.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Repositorio de Menu en MySQL
 *
 * @author Ximena
 */
public class MenuRepositoryImplMysql implements IMenuRepository {

    /**
     * Conección con Mysql
     */
    private Connection conn;

    /**
     * Constructor parametrizado
     */
    public MenuRepositoryImplMysql() {
    }

    /**
     * Busca en la bd un menu
     *
     * @param id menu
     * @return objeto menu, null si no lo encuentra
     */
    @Override
    public Menu findMenu(String id) {
        Menu menu = null;

        this.connect();
        try {
            String sql = "SELECT * from menu where idMenu=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                menu = new Menu();
                menu.setIdMenu(res.getInt("idMenu"));
                menu.setEntry(res.getString("entry"));
                menu.setSalad(res.getString("salad"));
                menu.setSalad(res.getString("mainDishes"));
                menu.setSalad(res.getString("dessert"));
                menu.setSalad(res.getString("drink"));
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Menu de la base de datos", ex);
        }
        return menu;
    }

    /**
     * Crear un reguistro para la tabla menu
     *
     * @param menu: objeto de tipo Menu
     * @return: id del menu
     */
    @Override
    public int createMenu(Menu menu) {

        try {

            this.connect();
            String sql = "INSERT INTO menu(idMenu, entry, salad, mainDishes, dessert, drink) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, menu.getIdMenu());
            pstmt.setString(2, menu.getEntry());
            pstmt.setString(3, menu.getSalad());
            pstmt.setString(4, menu.getMainDishes());
            pstmt.setString(5, menu.getDessert());
            pstmt.setString(6, menu.getDrink());

            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return menu.getIdMenu();
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
