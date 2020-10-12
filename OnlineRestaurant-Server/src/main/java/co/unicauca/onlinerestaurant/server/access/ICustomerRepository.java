package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Customer;
import java.util.List;

/**
 * Interface del respositorio de clientes
 *
 * @author Santiago Acuña
 */
public interface ICustomerRepository {

    /**
     * Busca un Customer por su cedula
     *
     * @param id cedula del cliente
     * @return objeto de tipo Customer
     */
    public Customer findCustomer(String id);

    /**
     * Buscar con nombre y contraseña
     *
     * @param name nombre
     * @param pws contraseña
     * @return
     */
    public Customer findCustomer(String name, String pws);

    /**
     * metodo encargado de crear un cliente
     *
     * @param customer
     * @return una cadena información
     */
    public String createCustomer(Customer customer);

    /**
     * lista de clientes
     *
     * @return
     */
    public List<Customer> list();
    /**
     * metodo para borrar customer
     * @param id
     * @return 
     */

    public boolean deleteCustomer(int id);
    
    /**
     * metodo Lista de customers
     * @return 
     */

    public List<Customer> Costomers();

}
