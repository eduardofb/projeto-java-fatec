/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Cliente;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;

/**
 * Classe modelo de cliente
 * 
 * @author Jayme
 */
public class ClienteModelo extends DAORepositorio<Cliente, Long>{

    public ClienteModelo(SessionFactory sf) {
        super(Cliente.class, sf);
    }

    
}
