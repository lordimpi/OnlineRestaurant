package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;
import java.util.List;

/**
 * Interfaz de repositorios de platos
 *
 * @author Santiago Acuña, Ximena Gallego
 */
public interface IMainDishRepository {

    /**
     * Metodo encargado de buscar un plato principal
     *
     * @param id Identificador del plato
     * @return Retorna un plato
     */
    public MainDish findDish(String id);

    /**
     * Metodo encargado de crear un plato principal
     *
     * @param id Identificador del plato principal
     * @param name Nombre del plato principal
     * @param price Precio del plato principal
     * @return Retorna el identificador del plato principal creado
     */
    public boolean createMainDish(String id, String name, String price);

    /**
     * Metodo encargado de actualizar plato
     *
     * @param id identificador del plato
     * @param name Nombre del plato
     * @param price Precio del plato
     * @return true si pudo actualizar, false de lo contrario
     */
    public boolean updateDish(String id, String name, String price);

    /**
     * Declaracion del metodo borrar plato
     *
     * @param id identificador del plato
     * @return true si pudo borrar, false de lo contrario
     */
    public boolean deleteDish(String id);

    /**
     * Metodo encargado de lista objetos de tipo plato principal
     *
     * @return Lista de platos principales
     */
    public List<MainDish> list();
}
