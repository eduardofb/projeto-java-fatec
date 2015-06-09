/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.modelo;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/** 
 * Implementação do DAOGenerico
 *  Toda classe do sistema de modelo extende esta
 *  classe que possui a implementação genérica de 
 *  todas as buscas solicitadas pelo professor.
 *  
 * O conceito aqui implementado é o de DRY (Não Repita a Si Mesmo)
 *  evitando que código repetitivo fique espalhado pelo código.
 * 
 * Este modelo pode ser encontrado neste endereço: 
 *  @link{https://github.com/renanbarbosadasilva/CRUD-1PN-HIBERNATE-JPA-JSP-SERVLET/blob/master/src/br/com/hibernateservletjsp1pn/repository/RepositoryJPA.java}
 * @author Jayme
 */
public class DAORepositorio<T, ID extends Serializable> implements DAOGenerico<T, ID>{

    private final Class<T> clazz;
    private final Session session;
    
    public DAORepositorio(Class<T> clazz, SessionFactory sf) {
        super();
        this.clazz = clazz;
        this.session = sf.openSession();
    }
    
    
    @Override
    public void salvar(T entidade) throws Exception {
        Transaction tx = null;
        
        try {
            session.beginTransaction();
            tx.begin(); //inicia a transacao
            session.save(entidade);
            tx.commit(); //commita a transacao
        } catch(Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            session.disconnect();
            session.close();
        }
    }

    @Override
    public void atualizar(T entidade) throws Exception {
        Transaction tx = null;
        
        try {
            session.beginTransaction();
            tx.begin(); //inicia a transacao
            session.update(entidade);
            tx.commit(); //commita a transacao
        } catch(Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            session.disconnect();
            session.close();
        }
    }

    @Override
    public void excluir(T entidade) throws Exception {
       Transaction tx = null;
       try {
           tx = session.beginTransaction();
           tx.begin();
           session.delete(entidade);
           tx.commit();
       } catch(Exception ex) {
           tx.rollback();
           ex.printStackTrace();
       } finally {
            session.disconnect();
            session.close();
       }
    }

    @Override
    public T procurarPorId(ID id) throws Exception {
        Transaction tx = session.beginTransaction();
        T result = null;
        try {
            result = (T) session.get(getTipo(), id);
            tx.commit();
        } catch(Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            session.disconnect();
            session.close();
        }
        
        return result;
    }

    
    @Override
    public List<T> retornarTodos() throws Exception {
        Transaction tx = session.beginTransaction();
        List<T> results = null;
        try {
            tx.begin();
            results = session.createCriteria(getTipo()).list();
            tx.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally {
            session.disconnect();
            session.close();
        }
        return results;
    }
    
    public T procurarPorUsuarioESenha(String login, String senha) {
        Query query = null;
        T result = null;
        try {
            query = session.createQuery("from Usuario where login = :login and senha = :senha");
            query.setParameter("login", login);
            query.setParameter("senha", senha);
            result = (T) query.uniqueResult();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            session.disconnect();
            session.close();
        }
        
        return result;
    }
    
    public Class<T> getTipo() {
        return clazz;
    }
    
}
