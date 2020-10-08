package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;

/**
 * Interfaz de repositorios de platos
 *
 * @author Santiago Acuña, Ximena Gallego
 */
public interface IMainDishRepository {

    public MainDish findDish(String id);

    public String createDish(MainDish dish);

    /**
     * Metodo encargado de actualizar plato
     *
     * @param id identificador del plato
     * @return cadena confirmando el estado
     */
    public String updateDish(String id);

}
