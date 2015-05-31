/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Saida;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SaidaDAO extends DAO<Saida> {

    @Override
    protected Saida extrai(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Saida s) {
        String sql = "INSERT INTO Saida VALUES(codSaida, ?, ?, ?, ?, ?, ?, ?)";

        boolean sucesso = executa(sql, s.getCpfCliente(), s.getData(), s.getPreco(),
                s.getQuantidade(), s.getTotal(), s.getCodUsuario(), s.getCodProduto());

        s.setCodigo(getPrimaryKey());

        return sucesso;
    }

    @Override
    public boolean update(Saida objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Saida objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Saida> select() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Saida> selectBy(Object filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Saida findBy(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
