package co.unicauca.onlinerestaurant.client.domain.services;

import co.unicauca.onlinerestaurant.client.domain.User;

/**
 * Servicio de usuarios del sistema
 *
 * @author Santiago Acuña
 */
public class UserService {

    /**
     * Autentica el usuario en el sistema Por ahora no hace ninguna validación
     *
     * @param login login de usuario
     * @param password contraseña
     * @return objeto User cuando la autenticación es exitosa
     * @throws java.lang.Exception
     */
    public User autenticacion(String login, String password)  throws Exception{
        return null;
    }
}
