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
     * @param id
     * @return 
     */
    public MainDish findMainDish(String id) {
        return repo.findDish(id);
    }
    public void deleteMainDish(String id){
        repo.deleteDish(id);
    }
    
   
    public void updateMainDish(String id,String name,String price) {
        repo.updateDish(id,name,price);
    }
    
    /**
     * Crea un nuevo mainDish. Aplica validaciones de negocio
     *
     * @param mainDish plato
     * @return devuelve el id del plato creado
     */
    public String createMainDish(MainDish mainDish) {
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
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }
        return repo.createMainDish(id, name, precio);
    }

}
