/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Produto;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jayme
 */
public class ProdutoModelo extends DAORepositorio<Produto, Long> {

    public ProdutoModelo(SessionFactory sf) {
        super(Produto.class, sf);
    }

    
}
