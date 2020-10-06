package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.onlinerestaurant.client.access.IMainDishAccess;
import co.unicauca.onlinerestaurant.commons.domain.MainDish;

/**
 *
 * @author Santiago Acuña
 */
public class MainDishService {

    private final IMainDishAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IMainDishService
     */
    public MainDishService(IMainDishAccess service) {
        this.service = service;
    }
    
        /**
     * Busca un plato en el servidor remoto
     *
     * @param id identificador del plato
     * @return Objeto tipo Plato, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public MainDish findMainDish(String id) throws Exception {
        return service.findMainDish(id);

    }

    public String createMainDish(MainDish mainDish) throws Exception {
        return service.createMainDish(mainDish);

    }

}
