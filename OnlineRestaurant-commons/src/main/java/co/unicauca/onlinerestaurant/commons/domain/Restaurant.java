
package co.unicauca.onlinerestaurant.commons.domain;

/**
 *
 * @author Ximena
 */
public class Restaurant {
    /**
     * identificador del restaurante
     */
    private String idRestaurant;
    /**
     * Nombre del restaurante
     */
    private String NameRestaurant;
    /**
     * direccion del restaurante
     */
    private String addressRestaurant;    
    /**
     * telefono del restaurante
     */
    private String phone;
    /**
     * Constructor parametrizado
     * @param idRestaurant  id  
     * @param NameRestaurant nombre
     * @param addressRestaurant direccion
     * @param phone telefono
     */
    public Restaurant(String idRestaurant, String NameRestaurant, String addressRestaurant, String phone) {
        this.idRestaurant = idRestaurant;
        this.NameRestaurant = NameRestaurant;
        this.addressRestaurant = addressRestaurant;
        this.phone = phone;
    }
    /**
     * Constructor por defecto
     */
    public Restaurant() {
    }
    /**
     * Getters and seters
     * @return 
     */
    public String getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getNameRestaurant() {
        return NameRestaurant;
    }

    public void setNameRestaurant(String NameRestaurant) {
        this.NameRestaurant = NameRestaurant;
    }

    public String getAddressRestaurant() {
        return addressRestaurant;
    }

    public void setAddressRestaurant(String addressRestaurant) {
        this.addressRestaurant = addressRestaurant;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }      
}
