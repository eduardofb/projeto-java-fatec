/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.HibernateUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
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

    private Class<T> clazz;
    private Session session;
    
    public DAORepositorio(Class<T> clazz, SessionFactory sf) {
        super();
        this.clazz = clazz;
        this.session = sf.openSession();
    }
    
    public DAORepositorio(SessionFactory sf) {
        super();
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
           session.close();
       }
    }

    @Override
    public T procurarPorId(ID id) throws Exception {
        Transaction tx = session.beginTransaction();
        T result = null;
        try {
            result = (T) session.load(getTipo(), id);
            tx.commit();
        } catch(Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
        
        return result;
    }

    
    @Override
    public List<T> retornarTodos() throws Exception {
        return session.createCriteria(getTipo()).list();
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
            HibernateUtil.getSessionFactory().close();
        }
        
        return result;
    }
    
    public Class<T> getTipo() {
        return clazz;
    }
    
    public void setTipo(Class<T> clazz) {
        this.clazz = clazz;
    }
    
}
