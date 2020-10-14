package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.DishEntry;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.server.access.IDishEntryRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de platos de entrada. Da acceso a la lógica de negocio
 *
 * @author Ximena Gallego
 */
public class DishEntryService {

    /**
     * Repositorio de platos de entrada
     */
    IDishEntryRepository repo;

    /**
     * Constructor por defecto
     */
    public DishEntryService() {
    }

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo IDishEntryRepository
     */
    public DishEntryService(IDishEntryRepository repo) {
        this.repo = repo;
    }

    /**
     * Busca un plato de entrada
     *
     * @param id identificador del plato de entrada
     * @return true si lo encontro, false de lo contrario
     */
    public DishEntry findDishEntry(String id) {
        return repo.findDishEntry(id);
    }

    /**
     * Crea un nuevo DishEntry. Aplica validaciones de negocio
     *
     * @param dishentry plato de entrada
     * @return true si pudo crear, false de lo contrario
     */
    public boolean createDishEntry(DishEntry dishentry) {
        List<JsonError> errors = new ArrayList<>();

        String id = dishentry.getIdDishEntry();
        String precio = Double.toString(dishentry.getCostDishEntry());
        // Validaciones y reglas de negocio
        if (id.isEmpty() || dishentry.getNameDishEntry().isEmpty()
                || precio.isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "id, nombre y precio son obligatorios. "));
        }
        // Que no esté repetido

        DishEntry dishSearched = this.findDishEntry(id);
        if (dishSearched != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "El identificado ya existe. "));
        }

        if (!errors.isEmpty()) {
            return false;
        }
        return repo.createDish(dishentry);
    }

    /**
     * Lista todos los platos de entrada que existan
     *
     * @return lista de plato de entradas
     */
    public List<DishEntry> listDishEntry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
