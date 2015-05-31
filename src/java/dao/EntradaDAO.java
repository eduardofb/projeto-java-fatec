/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Entrada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EntradaDAO extends DAO<Entrada> {

    private static final ProdutoDAO produtoDAO = new ProdutoDAO();
    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected Entrada extrai(ResultSet rs) throws SQLException {
        Entrada entrada = new Entrada();

        entrada.setCnpjFornecedor(rs.getString("cnpjFornecedor"));
        entrada.setCodigo(rs.getInt("codEntrada"));
        entrada.setData(rs.getDate("dataEntrada"));
        entrada.setPreco(rs.getDouble("preco"));
        entrada.setProduto(produtoDAO.findBy(rs.getInt("produto")));
        entrada.setQuantidade(rs.getDouble("quantidade"));
        entrada.setTotal(rs.getDouble("total"));
        entrada.setUsuario(usuarioDAO.findBy(rs.getInt("usuario")));

        return entrada;
    }

    @Override
    public boolean insert(Entrada e) {
        String sql = "INSERT INTO Entrada VALUES(codEntrada, ?, ?, ?, ?, ?, ?, ?)";

        boolean sucesso = executa(sql, e.getCnpjFornecedor(), e.getData(), e.getPreco(), e.getQuantidade(), e.getTotal(), e.getCodUsuario(),
                e.getCodProduto());

        e.setCodigo(getPrimaryKey());

        return sucesso;
    }

    @Override
    public boolean update(Entrada objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Entrada objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Entrada> select() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Entrada> selectBy(Object filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entrada findBy(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
