package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;

/**
 * Interfaz de repositorios de platos
 *
 * @author Santiago Acuña, Ximena Gallego
 */
public interface IMainDishRepository {

    public MainDish findDish(String id);

    public String createMainDish(String id,String name,String price);

    /**
     * Metodo encargado de actualizar plato
     *
     * @param id identificador del plato
     * @return cadena confirmando el estado
     */
    public void updateDish(String id,String name,String price);
    
    public void deleteDish(String id);

}
