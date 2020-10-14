package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.Drink;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import co.unicauca.onlinerestaurant.server.access.IDrinkRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mariat Trujillo
 */
public class DrinkService {

    /**
     * Repositorio de bebidas
     */
    IDrinkRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo IDrinkRepository
     */
    public DrinkService(IDrinkRepository repo) {
        this.repo = repo;
    }

    /**
     * Busca una bebida
     *
     * @param id identificador de la bebida
     * @return true si pudo encontrar, false de lo contrario
     */
    public Drink findDrink(String id) {
        return repo.findDrink(id);
    }

    /**
     * Borra una bebida
     *
     * @param id identificador de la bebida a borrar
     * @return true si pudo borrar, false de lo contrario
     */
    public boolean deleteDrink(String id) {
        return repo.deleteDrink(id);
    }

    /**
     * Crea un nuevo Drink. Aplica validaciones de negocio
     *
     * @param drink bebida
     * @return true si pudo crear, false de lo contrario
     */
    public boolean createDrink(Drink drink) {
        List<JsonError> errors = new ArrayList<>();

        String id = drink.getId_Drink();
        String precio = Double.toString(drink.getDrinkPrice());
        // Validaciones y reglas de negocio
        if (id.isEmpty() || drink.getNameDrink().isEmpty()
                || precio.isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "id, nombre y precio son obligatorios. "));
        }
        // Que no esté repetido

        Drink drinkSearched = this.findDrink(id);
        if (drinkSearched != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "El identificado ya existe. "));
        }

        if (!errors.isEmpty()) {

            return false;
        }
        return repo.createDrink(drink);
    }

}
