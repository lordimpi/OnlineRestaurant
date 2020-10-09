package co.unicauca.onlinerestaurant.commons.domain;

/**
 * Clase Administrador Restaurante
 *
 * @author Ximena
 */
public class Administrator extends User {

    /**
     * Constructor parametrizado
     *
     * @param id cedula
     * @param firstName nombres
     * @param lastName apellidos
     * @param address dirección
     * @param mobile celular
     * @param email email
     * @param rol sexo
     */
    public Administrator(String id, String firstName, String lastName, String address, String mobile, String email, String rol) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.rol = rol;
    }
        /**
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
