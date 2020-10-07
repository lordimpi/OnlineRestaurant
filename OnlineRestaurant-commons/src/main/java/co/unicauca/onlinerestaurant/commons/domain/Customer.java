package co.unicauca.onlinerestaurant.commons.domain;

import java.util.Date;

/**
 * Cliente del Restaurante
 *
 * @author Santiago Acuña
 */
public class Customer extends User {

    /**
     * Constructor parametrizado
     *
     * @param id cedula
     * @param firstName nombres
     * @param lastName apellidos
     * @param address dirección
     * @param mobile celular
     * @param email email
     * @param gender sexo
     */
    public Customer(String id, String firstName, String lastName, String address, String mobile, String email, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.gender = gender;
    }

    /**
     * Constructor por defecto
     */
    public Customer() {

    }
}
