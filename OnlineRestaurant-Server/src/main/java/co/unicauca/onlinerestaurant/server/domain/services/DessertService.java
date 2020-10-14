package co.unicauca.onlinerestaurant.server.domain.services;

import co.unicauca.onlinerestaurant.commons.domain.Dessert;
import co.unicauca.onlinerestaurant.commons.infra.JsonError;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import co.unicauca.onlinerestaurant.server.access.IDessertRepository;

/**
 *
 * @author Camilo Otaya
 */
public class DessertService {

    /**
     * Repositorio de postres
     */
    IDessertRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo IDessertRepository
     */
    public DessertService(IDessertRepository repo) {
        this.repo = repo;
    }

    public Dessert findDessert(String id) {
        return repo.findDessert(id);
    }

}
