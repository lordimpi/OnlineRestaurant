package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Drink;

/**
 * Interfaz de repositorios de bebidas
 *
 * @author Mariat Trujillo
 */
public interface IDrinkRepository {

    /**
     * Declaracion del metodo buscar bebidas
     *
     * @param id identificador de la bebida
     * @return Objeto tipo bebida
     */
    public Drink findDrink(String id);

    /**
     * Declaracion del metodo crear bebida
     *
     * @param drink objeto bebida
     * @return true si pudo crear la bebida, false de lo contrario
     */
    public boolean createDrink(Drink drink);

    /**
     * Declaracion del metodo eliminar bebida
     *
     * @param id identificador de la bebida
     * @return true si pudo borrar, false de lo contrario
     */
    public boolean deleteDrink(String id);

}
