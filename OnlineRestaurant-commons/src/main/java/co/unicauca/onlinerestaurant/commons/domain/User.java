/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.commons.domain;

/**
 *
 * @author Santiago Acuña
 */
public class User {

    /**
     * Cedula
     */
    protected String id;
    /**
     * Nombres
     */
    protected String firstName;
    /**
     * Apellidos
     */
    protected String lastName;
    /**
     * Dirección de residencia
     */
    protected String address;
    /**
     * Teléfono Móvil
     */
    protected String mobile;
    /**
     * Email
     */
    protected String email;
    /**
     * Rol
     */
    protected String rol;
      /**
     * Constructor por defecto
     */
    public User() {
    }
    
    /*
     * Getters and Setters
     *
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
