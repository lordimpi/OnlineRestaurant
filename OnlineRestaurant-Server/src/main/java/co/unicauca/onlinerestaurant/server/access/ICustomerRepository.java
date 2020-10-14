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
     * @return Un customer en concreto
     */
    public Customer findCustomer(String name, String pws);

    /**
     * metodo encargado de crear un cliente
     *
     * @param customer
     * @return una cadena información
     */
    public boolean createCustomer(Customer customer);

    /**
     * lista de clientes
     *
     * @return Una lista de customers
     */
    public List<Customer> list();

    /**
     * Mtodo para borrar customer
     *
     * @param id Identificador del customer
     * @return True si pudo eliminar, False de lo contrario
     */
    public boolean deleteCustomer(int id);

}
