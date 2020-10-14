package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.MainDish;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.server.access.IMainDishRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Acuña
 */
public class MainDishService {

    /**
     * Repositorio de platos
     */
    IMainDishRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo IMainDishRepository
     */
    public MainDishService(IMainDishRepository repo) {
        this.repo = repo;
    }

    /**
     * Metodo busqueda de plato principal
     *
     * @param id identificador del plato principal
     * @return objeto tipo plato principal
     */
    public MainDish findMainDish(String id) {
        return repo.findDish(id);
    }

    /**
     * Lista todos los platos principales
     *
     * @return lista de platos principales
     */
    public List<MainDish> listMainDish() {
        return repo.list();
    }

    /**
     * Elimina un plato principal
     *
     * @param id identificador del plato principal
     * @return true si pudo borrar, false de lo contrario
     */
    public boolean deleteMainDish(String id) {
        return repo.deleteDish(id);
    }

    /**
     * Metodo encargado de actualizar un plato
     *
     * @param id identificador
     * @param name nombre
     * @param price precio
     * @return true si pudo actualizar, false de lo contrario
     */
    public boolean updateMainDish(String id, String name, String price) {
        return repo.updateDish(id, name, price);
    }

    /**
     * Crea un nuevo mainDish. Aplica validaciones de negocio
     *
     * @param mainDish plato
     * @return true si pudo crear, false de lo contrario
     */
    public boolean createMainDish(MainDish mainDish) {
        List<JsonError> errors = new ArrayList<>();

        String id = mainDish.getId_mainDishe();
        String name = mainDish.getNameDishe();
        String precio = Double.toString(mainDish.getDishPrice());
        // Validaciones y reglas de negocio
        if (id.isEmpty() || mainDish.getNameDishe().isEmpty()
                || precio.isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "id, nombre y precio son obligatorios. "));
        }
        // Que no esté repetido
        if (!errors.isEmpty()) {
            return false;
        }
        return repo.createMainDish(id, name, precio);
    }

}
