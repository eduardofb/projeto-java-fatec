/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.modelo;

import br.com.fatec.entidades.Fornecedor;
import java.io.Serializable;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;

/**
 *
 * @author Carlos
 */
public class FornecedorModelo extends DAORepositorio<Fornecedor, Long> {

    public FornecedorModelo(SessionFactory sf) {
        super(Fornecedor.class, sf);
    }

    
}
