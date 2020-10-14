package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.DishEntry;
import java.util.List;

/**
 * Interfaz de repositorio de plato de entrada
 *
 * @author Ximena Gallego
 */
public interface IDishEntryRepository {

    /**
     * Busca un plato de entrada por su identificador
     *
     * @param id identificador de plato de entrada
     * @return objeto de tipo entrada
     */
    public DishEntry findDishEntry(String id);

    /**
     * metodo encargado de crear un plato de entrada
     *
     * @param entry entrada
     * @return true si pudo crear, false de lo contrario
     */
    public boolean createDish(DishEntry entry);

    /**
     * Metodo encargado de eliminar un plato de entrada
     *
     * @param id identificador del plato de entrada
     * @return true si pudo borrar, false de lo contrario
     */
    public boolean deleteDishEntry(int id);

    /**
     * Metodo encargado de listar los objetos platos de entrada
     *
     * @return lista de platos de entrada
     */
    public List<DishEntry> listDishEntry();

}
