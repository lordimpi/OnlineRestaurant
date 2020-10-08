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
     * metodo encargado de crear un cliente
     * @param customer
     * @return una cadena información
     */
    public String createCustomer(Customer customer);
   
    /**
     * lista de clientes 
     * @return 
     */
    public List<Customer> list();

    public boolean deleteCustomer(int id);

    public List<Customer> Costomers();

}
