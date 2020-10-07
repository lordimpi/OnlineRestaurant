package co.unicauca.onlinerestaurant.server.access;

import co.unicauca.onlinerestaurant.commons.domain.Administrator;

/**
 * Interface del respositorio de Administrador
 *
 * @author Ximena
 */
public interface IAdministratorRepository {
 /**
     * Busca un Administrador por su id
     *
     * @param id cedula del administrador
     * @return objeto de tipo Administrador
     */
    public Administrator findAdmistrator(String id);

    public int createAdministrator(Administrator adm);
    
}
