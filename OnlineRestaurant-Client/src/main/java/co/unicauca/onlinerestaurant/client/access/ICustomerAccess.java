package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.domain.Customer;

/**
 * Interface que define los servicios de persistencia de Clientes de la agencia
 *
 * @author Santiago Acuña
 */
public interface ICustomerAccess {

    /**
     * Buscar un cliente utilizando un socket
     *
     * @param id nombre del cliente
     * @return objeto cliente
     * @throws Exception error al buscar un cliente
     */
    public Customer findCustomer(String id) throws Exception;

    /**
     * Buscar cliente utilizando un socket con nombre y clave
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Customer findCustomer(String name, String pws) throws Exception;

    /**
     * Crea un Customer
     *
     * @param customer cliente del restaurante
     * @return devuelve la cedula del cliente creado
     * @throws Exception error crear el cliente
     */
    public String createCustomer(Customer customer) throws Exception;
}
