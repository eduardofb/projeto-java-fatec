/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Saida;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jayme
 */
public class SaidaModelo extends DAORepositorio<Saida, Long> {

    public SaidaModelo(SessionFactory em) {
        super(Saida.class, em);
    }

    
}
