
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
     *  id del menu
     */
    private Menu wmenu;
    /**
     * Constructor parametrizado 
     * @param idRestaurant identificador del restaurante 
     * @param NameRestaurant nombre del restaurante
     * @param addressRestaurant direccion 
     * @param phone telefono
     * @param wmenu menu de la semana
     */
    public Restaurant(String idRestaurant, String NameRestaurant, String addressRestaurant, String phone,String id_menu) {
        this.idRestaurant = idRestaurant;
        this.NameRestaurant = NameRestaurant;
        this.addressRestaurant = addressRestaurant;
        this.phone = phone;
        this.wmenu = new Menu();
        this.wmenu.setId_menu(id_menu);
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

    public Menu getWmenu() {
        return wmenu;
    }

    public void setWmenu(Menu wmenu) {
        this.wmenu = wmenu;
    }
    
}
