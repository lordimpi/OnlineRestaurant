package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Drink;

/**
 *
 * @author Mariat Trujillo
 */
public interface IDrinkRepository {
    
    public Drink findDrink(String id);

    public String createDrink(Drink drink);
    
    public boolean deleteDrink(String id);

    
}
