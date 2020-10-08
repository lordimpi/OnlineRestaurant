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
    
    /**
     * Metodo que permite crear un administrador 
     * @param adm un objeto de tipo administrador 
     * @return 
     */

    public int createAdministrator(Administrator adm);
    /**
     * Metodo encargado de eliminar un administrador 
     * @param idAdm identificador del administrador 
     * @return true o false 
     */
    public boolean removeAdministrador(int idAdm);
    
}
