/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
    private SessionFactory sf;
    
    public DAORepositorio(Class<T> clazz, SessionFactory sf) {
        super();
        this.clazz = clazz;
        this.sf = sf;
    }
    
    public DAORepositorio(SessionFactory em) {
        super();
        this.sf = sf;
    }
    
    
    @Override
    public void salvar(T entidade) throws Exception {
        Session session = this.sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        tx.begin(); //inicia a transacao
        session.save(entidade);
        tx.commit(); //commita a transacao
    }

    @Override
    public void atualizar(T entidade) throws Exception {
        
    }

    @Override
    public void excluir(T entidade) throws Exception {
       
    }

    @Override
    public T procurarPorId(ID id) throws Exception {
        return null;
    }

    
    @Override
    public List<T> retornarTodos() throws Exception {
        
        Session session = this.sf.openSession();
        Query query = session.createQuery("from " + this.clazz.getName());
        
        return query.list();
    }
    
    public Object procurarPorUsuarioESenha(String usuario, String senha) {
        Session session = this.sf.openSession();
        Query query = session.createQuery("from Usuario where login = " + usuario + " and senha = " + senha);
        return query.uniqueResult();
    }
    
    public Class<T> getTipo() {
        return clazz;
    }
    
    public void setTipo(Class<T> clazz) {
        this.clazz = clazz;
    }
    
}
