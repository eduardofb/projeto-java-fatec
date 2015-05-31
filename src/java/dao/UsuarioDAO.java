/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDAO extends DAO<Usuario> {

    @Override
    protected Usuario extrai(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setCodigo(rs.getInt("codUsuario"));
        usuario.setLogin(rs.getString("login"));
        usuario.setNome(rs.getString("nome"));
        usuario.setSenha(rs.getString("senha"));

        return usuario;
    }

    public Usuario login(String usuario, String senha) {
        String sql = "SELECT * FROM Usuario WHERE login = ? AND senha = ?";

        return getObjeto(sql, usuario, senha);
    }

    @Override
    public boolean insert(Usuario u) {
        String sql = "INSERT INTO Usuario(nome, login, senha) VALUES(?, ?, ?)";

        boolean sucesso = executa(sql, u.getNome(), u.getLogin(), u.getSenha());
        u.setCodigo(getPrimaryKey());

        return sucesso;
    }

    @Override
    public boolean update(Usuario u) {
        String sql = "UPDATE Usuario SET nome = ?, login = ? senha = ? WHERE codUsuario = ?";

        return executa(sql, u.getNome(), u.getLogin(), u.getSenha(), u.getCodigo());
    }

    @Override
    public boolean delete(Usuario u) {
        String sql = "DELETE FROM Usuario WHERE codUsuario = ?";

        return executa(sql, u.getCodigo());
    }

    @Override
    public List<Usuario> select() {
        String sql = "SELECT * FROM Usuario";

        return getLista(sql);
    }

    @Override
    public List<Usuario> selectBy(Object filter) {
        String sql = "SELECT * FROM Usuario WHERE nome LIKE ?";

        return getLista(sql, "%" + filter + "%");
    }

    @Override
    public Usuario findBy(int codigo) {
        String sql = "SELECT * FROM Usuario WHERE codUsuario = ?";

        return getObjeto(sql, codigo);
    }

}
