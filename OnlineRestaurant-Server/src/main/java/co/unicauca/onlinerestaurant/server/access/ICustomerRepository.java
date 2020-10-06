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
     * Busca un Customer por su ceduka
     *
     * @param id cedula del cliente
     * @return objeto de tipo Customer
     */
    public Customer findCustomer(String id);

    public String createCustomer(Customer customer);

    public boolean deleteCustomer(int id);

    public List<Customer> Costomers();

}
