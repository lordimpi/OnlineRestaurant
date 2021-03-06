package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.Customer;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.commons.infra.Utilities;
import co.unicauca.onlinerestaurant.server.access.ICustomerRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de clientes. Da acceso a la lógica de negocio
 *
 * @author Santiago Acuña
 */
public class CustomerService {

    /**
     * Repositorio de clientes
     */
    ICustomerRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo ICustomerRepository
     */
    public CustomerService(ICustomerRepository repo) {
        this.repo = repo;
    }

    /**
     * Buscar un cliente
     *
     * @param id cedula
     * @return objeto tipo Customer
     */
    public Customer findCustomer(String id) {
        return repo.findCustomer(id);
    }

    /**
     * busca cliente
     *
     * @param name nombre
     * @param pws contraseña
     * @return objeto tipo customer
     */
    public Customer findCustomer(String name, String pws) {
        return repo.findCustomer(name);
    }

    /**
     * Crea un nuevo customer. Aplica validaciones de negocio
     *
     * @param customer cliente
     * @return true si pudo crear, false de lo contrario
     */
    public boolean createCustomer(Customer customer) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (customer.getId().isEmpty() || customer.getFirstName().isEmpty()
                || customer.getLastName().isEmpty() || customer.getEmail().isEmpty()
                || customer.getRol().isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "id, nombres, apellidos, email y género son obligatorios. "));
        }

        if (!customer.getEmail().contains("@")) {
            errors.add(new JsonError("400", "BAD_REQUEST", "Email debe tener una @. "));
        }

        if (!(customer.getRol().equalsIgnoreCase("M") || customer.getRol().equalsIgnoreCase("F"))) {
            errors.add(new JsonError("400", "BAD_REQUEST", "Sexo debo ser M o F. "));
        }

        if (!Utilities.isNumeric(customer.getMobile())) {
            errors.add(new JsonError("400", "BAD_REQUEST", "Teléfono móvil debe contener sólo dígitos "));

        }
        // Que no esté repetido

        Customer customerSearched = this.findCustomer(customer.getFirstName());
        if (customerSearched != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "La cédula ya existe. "));
        }

        if (!errors.isEmpty()) {
            return false;
        }
        return repo.createCustomer(customer);
    }

}
