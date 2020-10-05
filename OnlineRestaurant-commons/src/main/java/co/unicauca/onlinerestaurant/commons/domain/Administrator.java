package co.unicauca.onlinerestaurant.commons.domain;

/**
 * Clase Administrador Restaurante
 *
 * @author Ximena
 */
public class Administrator {

    /**
     * id administrador
     */
    private int idAdministrador;
    /**
     * Nombre Administrador
     */
    private String nombreAdm;
    /**
     * Apellido Administrador
     */
    private String apellidoadm;
    /**
     * Movil
     */
    private String mobile;

    /**
     * usuario
     */
    private String userAdm;
    /**
     * contraseña
     */
    private String password;

    /**
     * Constructor por defecto
     */
    public Administrator() {
    }

    /**
     * constructor parametrizado
     *
     * @param idAdministrador id
     * @param nombreAdm nombre
     * @param apellidoadm apellido
     * @param mobile movil
     * @param userAdm usuario
     * @param password contraseña
     */
    public Administrator(int idAdministrador, String nombreAdm, String apellidoadm, String mobile, String userAdm, String password) {
        this.idAdministrador = idAdministrador;
        this.nombreAdm = nombreAdm;
        this.apellidoadm = apellidoadm;
        this.mobile = mobile;
        this.userAdm = userAdm;
        this.password = password;
    }

    /**
     * Getters and Setters
     *
     * @return
     */

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public String getNombreAdm() {
        return nombreAdm;
    }

    public String getApellidoadm() {
        return apellidoadm;
    }

    public String getMobile() {
        return mobile;
    }

    public String getUserAdm() {
        return userAdm;
    }

    public String getPassword() {
        return password;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public void setNombreAdm(String nombreAdm) {
        this.nombreAdm = nombreAdm;
    }

    public void setApellidoadm(String apellidoadm) {
        this.apellidoadm = apellidoadm;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setUserAdm(String userAdm) {
        this.userAdm = userAdm;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
