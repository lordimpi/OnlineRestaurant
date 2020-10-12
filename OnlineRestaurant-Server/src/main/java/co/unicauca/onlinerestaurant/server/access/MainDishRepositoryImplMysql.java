package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;
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
    public String createMainDish(String id, String name, String cost) {

        Double price = Double.parseDouble(cost);

        this.connect();
        try {
            String sql = "INSERT INTO maindish(id_dish, dish_name, dish_price) VALUES (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, price);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Plato de la base de datos", ex);
        }

        return "";
    }

    @Override
    public boolean deleteDish(String id) {
                    this.connect();
        try {
            String sql = "DELETE FROM maindish where id_dish=? ";
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

    /**
     * Permite actualizar un plato en la base de datos
     *
     * @param id identificador del plato
     * @param name Nombredel plato
     * @param price Precio del plato
     */
    @Override
    public boolean updateDish(String id, String name, String price) {
        //UPDATE `maindish` SET `id_dish`=[value-1],`dish_name`=[value-2],`dish_price`=[value-3] WHERE 1
        Double DPrice = Double.parseDouble(price);
        //System.out.println("el id "+id+" el nombre "+name+" el precio "+price+" el precio en entero "+DPrice);
        this.connect();
        try {
            String sql = "UPDATE maindish SET dish_name=?, dish_price=? where id_dish=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setDouble(2, DPrice);
            pstmt.setString(3, id);
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al actualizar Plato de la base de datos", ex);
        }
        return false;
    }

    /**
     * metodo que perimte listar los restaurantes
     *
     * @return list
     */
    @Override
    public List<MainDish> list() {
        List<MainDish> platos = new ArrayList<>();
        try {

            String sql = "SELECT * FROM maindish";
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                MainDish newmaindish = new MainDish();

                newmaindish.setId_mainDishe(res.getString("id_dish"));
                newmaindish.setNameDishe(res.getString("dish_name"));
                newmaindish.setDishPrice(Double.parseDouble(res.getString("dish_price")));

                platos.add(newmaindish);
            }
            //this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al Selecionar los datos de la tabla maindish de la base de datos", ex);
        }
        return platos;
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
