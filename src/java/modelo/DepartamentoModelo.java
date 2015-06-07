/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Departamento;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;

/**
 * Classe modelo de departamento.
 * 
 * @author Jayme
 */
public class DepartamentoModelo extends DAORepositorio<Departamento, Long> {

    public DepartamentoModelo(SessionFactory sf) {
        super(Departamento.class, sf);
    }

    
}
