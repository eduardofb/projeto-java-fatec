/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDAO extends DAO<Produto> {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected Produto extrai(ResultSet rs) throws SQLException {
        Produto produto = new Produto();

        produto.setCodigo(rs.getInt("codProduto"));
        produto.setDataCadastro(rs.getDate("dataCadastro"));
        produto.setDescricao(rs.getString("descricao"));
        produto.setPreco(rs.getDouble("preco"));
        produto.setPrecoCusto(rs.getDouble("precoCusto"));
        produto.setQuantidade(rs.getDouble("quantidade"));
        produto.setUsuario(usuarioDAO.findBy(rs.getInt("usuario")));

        return produto;
    }

    @Override
    public boolean insert(Produto p) {
        String sql = "INSERT INTO Produto(descricao, precoCusto, preco, dataCadastro, usuario) "
                + "VALUES(?, ?, ?, ?, ?)";

        boolean sucesso = executa(sql, p.getDescricao(), p.getPrecoCusto(), p.getPreco(), p.getDataCadastro(), p.getCodUsuario());
        p.setCodigo(getPrimaryKey());

        return sucesso;
    }

    @Override
    public boolean update(Produto p) {
        String sql = "UPDATE Produto SET descricao = ?, precoCusto = ?, preco = ?, "
                + "quantidade = ?, dataCadastro = ?, usuario = ? WHERE codProduto = ?";

        return executa(sql, p.getDescricao(), p.getPrecoCusto(), p.getPreco(), p.getQuantidade(), p.getDataCadastro(), p.getCodUsuario(), p.getCodigo());
    }

    @Override
    public boolean delete(Produto p) {
        String sql = "DELETE FROM Produto WHERE codProduto = ?";

        return executa(sql, p.getCodigo());
    }

    @Override
    public List<Produto> select() {
        String sql = "SELECT * FROM Produto";

        return getLista(sql);
    }

    @Override
    public List<Produto> selectBy(Object filter) {
        String sql = "SELECT * FROM Produto WHERE descricao LIKE ?";

        return getLista(sql, "%" + filter + "%");
    }

    @Override
    public Produto findBy(int codigo) {
        String sql = "SELECT * FROM Produto WHERE codProduto = ?";

        return getObjeto(sql, codigo);
    }

}
