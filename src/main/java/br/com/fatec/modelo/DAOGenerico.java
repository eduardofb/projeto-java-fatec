/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Interface de DAO Generico.
 * Evita a repetiçã de código por todo o sistema,
 *  basta um modelo estender a classe abstrata de 
 *  DAO que todas as implementações estarao feitas.
 * 
 * @author Jayme
 */
public interface DAOGenerico<T, ID extends Serializable> {
    public void salvar(T entidade) throws Exception;
    public void atualizar(T entidade) throws Exception;
    public void excluir(T entidade) throws Exception;
    public T procurarPorId(ID id) throws Exception;
    public List<T> retornarTodos() throws Exception;
}
