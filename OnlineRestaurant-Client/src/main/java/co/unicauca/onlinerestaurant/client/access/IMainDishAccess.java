package co.unicauca.onlinerestaurant.client.access;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;

/**
 * Interfaz donde se declara un crud para platos
 * @author Santiago Acuña
 */
public interface IMainDishAccess {

    /**
     * Buscar un plato utilizando un socket
     *
     * @param id identificado del plato principal
     * @return objeto plato
     * @throws Exception error al buscar un plato
     */
    public MainDish findMainDish(String id) throws Exception;

    /**
     * Actualiza un plato utilizando un socket
     *
     * @param id Identificador del plato
     * @param name Nombre del plato
     * @param price Precio del plato
     * @return objeto plato
     * @throws Exception error al actualizar el plato
     */
    public MainDish updateMainDish(String id, String name, String price) throws Exception;

    /**
     * Elimina un plato utilizando un socket
     *
     * @param id Identificador del plato
     * @throws Exception error al actualizar el plato
     */
    public boolean deleteMainDish(String id) throws Exception;

    /**
     * Crea un plato utilizando un socket
     *
     * @param mainDish Plato del restaurante
     * @return Devuelve el id del plato creado
     * @throws Exception error crear el plato
     */
    public String createMainDish(MainDish mainDish) throws Exception;

}
