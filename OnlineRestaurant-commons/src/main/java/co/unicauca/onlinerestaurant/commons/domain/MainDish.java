package co.unicauca.onlinerestaurant.commons.domain;

/**
 * 
 * @author Santiago Acuña
 */
public class MainDish {
    
    private String id_mainDishe;
    
    private String nameDishe;
    
    private double dishPrice;

    public MainDish(String id_mainDishe, String nameDishe, double dishPrice) {
        this.id_mainDishe = id_mainDishe;
        this.nameDishe = nameDishe;
        this.dishPrice = dishPrice;
    }

    public MainDish() {
    }

    public String getId_mainDishe() {
        return id_mainDishe;
    }

    public void setId_mainDishe(String id_mainDishe) {
        this.id_mainDishe = id_mainDishe;
    }

    public String getNameDishe() {
        return nameDishe;
    }

    public void setNameDishe(String nameDishe) {
        this.nameDishe = nameDishe;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }
    
}
