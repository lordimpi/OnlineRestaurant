package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;

/**
 * Interfaz de repositorios de platos
 *
 * @author Santiago Acuña
 */
public interface IMainDishRepository {

    public MainDish findDish(String id);

    public String createDish(MainDish dish);
    
    public void deleteDish(String id);

}
