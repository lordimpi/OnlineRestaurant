package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;

/**
 *
 * @author Santiago Acuña
 */
public interface IMainDishAccess {

    /**
     * Buscar un cliente utilizando un socket
     *
     * @param id identificado del plato principal
     * @return objeto plato
     * @throws Exception error al buscar un plato
     */
    public MainDish findMainDish(String id) throws Exception;

    /**
     * Actualiza un MainDish
     *
     * @param id identificador del plato
     * @return objeto plato
     * @throws Exception error al actualizar el plato
     */
    public MainDish updateMainDish(String id, String name, String price) throws Exception;

    public void deleteMainDish(String id) throws Exception;

    /**
     * Crea un Customer
     *
     * @param mainDish plato del restaurante
     * @return devuelve el id del plato creado
     * @throws Exception error crear el plato
     */
    public String createMainDish(MainDish mainDish) throws Exception;

}
