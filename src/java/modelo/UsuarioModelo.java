/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Usuario;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;

/**
 * Classe modelo de usuario
 * 
 * @author Jayme
 */
public class UsuarioModelo extends DAORepositorio<Usuario, Long> {

    public UsuarioModelo(SessionFactory sf) {
        super(Usuario.class, sf);
    }

}
