package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Customer;
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
 * Repositorio de Clientes en MySQL
 *
 * @author Santiago Acuña, Ximena gallego
 */
public class CustomerRepositoryImplMysql implements ICustomerRepository {

    /**
     * Conección con Mysql
     */
    private Connection conn;

    public CustomerRepositoryImplMysql() {

    }

    /**
     * Busca en la bd un customer
     *
     * @param id cedula
     * @return objeto customer, null si no lo encuentra
     */
    @Override
    public Customer findCustomer(String id) {
        Customer customer = null;

        this.connect();
        try {
            String sql = "SELECT * from customers where id=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                customer = new Customer();
                customer.setId(res.getString("id"));
                customer.setFirstName(res.getString("first_name"));
                customer.setLastName(res.getString("last_name"));
                customer.setAddress(res.getString("address"));
                customer.setMobile(res.getString("mobile"));
                customer.setGender(res.getString("gender"));
                customer.setEmail(res.getString("email"));

            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return customer;
    }

    @Override
    public String createCustomer(Customer customer) {
      
        try {

            this.connect();
            String sql = "INSERT INTO customers(id, first_name, last_name, address, mobile, email, gender) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customer.getId());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getLastName());
            pstmt.setString(4, customer.getAddress());
            pstmt.setString(5, customer.getMobile());
            pstmt.setString(6, customer.getEmail());
            pstmt.setString(7, customer.getGender());

            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return customer.getId();

    }   

    @Override
    public boolean deleteCustomer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> Costomers() {
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
     * Metodo publico encargado de lista los Objetos de tipo Customers
     *
     * @return: objetos Customers
     */
    @Override
    public List<Customer> list() {
        List<Customer> Customer = new ArrayList<>();
        try {

            String sql = "SELECT id, firstName,lastName,address, mobile,email,gender FROM customers";
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();            
            while (res.next()) {
                Customer newCustomer = new Customer();
                newCustomer.setId(res.getString("id"));
                newCustomer.setFirstName(res.getString("firsName"));
                newCustomer.setFirstName(res.getString("lastName"));
                newCustomer.setFirstName(res.getString("address"));
                newCustomer.setFirstName(res.getString("mobile"));
                newCustomer.setFirstName(res.getString("email"));
                newCustomer.setFirstName(res.getString("gender"));
                               
                Customer.add(newCustomer);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al Selecionar los datos de la tabla customer de la base de datos", ex);
        }
        return Customer;
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
