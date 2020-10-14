package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Salad;

/**
 * Interface del respositorio de Ensaladas
 *
 * @author Ximena
 */
public interface ISaladRepository {

    /**
     * Busca una ensalada por su ID
     *
     * @param id identificador por ensalada
     * @return objeto de tipo salad
     */
    public Salad findSalad(String id);

    /**
     * metodo encargdo de crear una ensalada
     *
     * @param id identificador
     * @param name nombre
     * @param cost costo
     * @return True si crear la ensalda, false de lo contrario
     */
    public boolean createSalad(String id, String name, double cost);

    /**
     * Metodo encargado de actualizar ensalada
     *
     * @param id dentificador de ensalada
     * @param name nombre
     * @param cost precio
     * @return true si pudo actualizar, false de lo contrario
     */
    public boolean updateSalad(String id, String name, double cost);

    /**
     * Metod encargado de eliminar ensalada
     *
     * @param id identificador de ensalda
     * @return true si pudo borrar, false de lo contrario
     */
    public boolean deleteSalad(String id);

}
