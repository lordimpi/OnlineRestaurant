package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.Dish_Dessert;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.server.access.IDish_DessertRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Camilo Otaya
 */
public class Dish_DessertService {

    /**
     * Repositorio de postres
     */
    IDish_DessertRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo IDish_DessertRepository
     */
    public Dish_DessertService(IDish_DessertRepository repo) {
        this.repo = repo;
    }

    public Dish_Dessert findDessert(String id) {
        return repo.findDessert(id);
    }

    public String createDessert(Dish_Dessert dish) {
        List<JsonError> errors = new ArrayList<>();
        
        String id = dish.getId_Dish_Dessert();
        String precio = Double.toString(dish.getCost_Dish_Dessert());
        // Validaciones y reglas de negocio
        if (id.isEmpty() || dish.getName_Dish_Dessert().isEmpty()
                || precio.isEmpty() ) {
            errors.add(new JsonError("400", "BAD_REQUEST", "id, nombre y precio son obligatorios. "));
        }
        // Que no esté repetido

        Dish_Dessert dishSearched = this.findDessert(id);
        if (dishSearched != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "El identificado ya existe. "));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }
        return repo.createDessert(dish);
    }
}
