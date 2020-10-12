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
     * @return
     */
    public String createSalad(String id, String name, String cost);

    /**
     * Metodo encargado de actualizar ensalada
     *
     * @param id dentificador de ensalada
     * @param name nombre
     * @param cost precio
     */
    public boolean updateSalad(String id, String name, String cost);

    /**
     * Metod encargado de eliminar ensalada
     *
     * @param id identificador
     */
    public boolean deleteSalad(String id);

}
