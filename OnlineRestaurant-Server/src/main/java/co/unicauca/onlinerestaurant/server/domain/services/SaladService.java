package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.Salad;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.server.access.ISaladRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de Ensalada. Da acceso a la lógica de negocio
 *
 * @author Ximena
 */
public class SaladService {

    /**
     * Repositorio de Ensalada
     */
    ISaladRepository repo;

    /**
     * Constructor parametrizado
     *
     * @param repo repositorio de tipo ISaladRepository
     */
    public SaladService(ISaladRepository repo) {
        this.repo = repo;
    }

    /**
     * Metodo que busca una ensalada
     *
     * @param id identificador
     * @return
     */
    public Salad findSalad(String id) {
        return repo.findSalad(id);
    }

    /**
     * Metodo para crear Ensalada
     *
     * @param salad tipo ensalada
     * @return cadena
     */
    public String createSalad(Salad salad) {
        List<JsonError> errors = new ArrayList<>();

        String id = salad.getIdSalad();
        String name = salad.getNameSalad();
        double cost = salad.getCostSalad();
        // Validaciones y reglas de negocio
        if (id.isEmpty() || salad.getIdSalad().isEmpty()
                || name.isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "id, nombre y costo son obligatorios. "));
        }
        // Que no esté repetido
        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }
        return repo.createSalad(id, name, cost);
    }

    /**
     * Metodo de actualizar Ensalada
     *
     * @param id identificador
     * @param name nombre
     * @param cost costo
     */
    public boolean updateSalad(String id, String name, Double cost) {
        return repo.updateSalad(id, name, cost);
    }

    /**
     * Metodo de eliminar ensalada
     *
     * @param id identificador
     */
    public boolean deleteSalad(String id) {
        return repo.deleteSalad(id);
    }

}
