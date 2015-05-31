/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DAO<T> {

    private int primaryKey;

    protected boolean executa(String sql, Object... params) {
        boolean sucesso = false;

        try {

            PreparedStatement ps = prepara(sql, params);

            sucesso = ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                primaryKey = rs.getInt(1);
            }

            sucesso = true;

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sucesso;
    }

    public List<T> getLista(String sql, Object... params) {
        List<T> lista = new ArrayList<>();

        try {

            PreparedStatement ps = prepara(sql, params);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(extrai(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public T getObjeto(String sql, Object... params) {

        try {

            PreparedStatement ps = prepara(sql, params);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extrai(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private PreparedStatement prepara(String sql, Object[] params) throws SQLException {
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }

        return ps;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    protected abstract T extrai(ResultSet rs) throws SQLException;

    public abstract boolean insert(T objeto);

    public abstract boolean update(T objeto);

    public abstract boolean delete(T objeto);

    public abstract List<T> select();

    public abstract List<T> selectBy(Object filter);

    public abstract T findBy(int codigo);

}
