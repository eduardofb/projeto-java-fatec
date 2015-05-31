/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.EntradaDAO;
import dao.ProdutoDAO;
import dao.SaidaDAO;
import dao.UsuarioDAO;
import entidades.Entrada;
import entidades.Produto;
import entidades.Saida;
import entidades.Usuario;
import java.util.List;

public class Controlador {

    private static Controlador instance;

    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static final ProdutoDAO produtoDAO = new ProdutoDAO();
    private static final EntradaDAO entradaDAO = new EntradaDAO();
    private static final SaidaDAO saidaDAO = new SaidaDAO();

    private Controlador() {
    }

    public static final Controlador getInstance() {
        if (instance == null) {
            instance = new Controlador();
        }

        return instance;
    }

    /**
     * No momento do login, ao iniciar o LoginServlet.init(), este método é
     * invocado para verificar se existe um usuario padrao no banco de dados
     *
     * @return
     */
    public boolean criaUsuarioPadraoSeNaoExiste() {
        List<Usuario> usuarios = usuarioDAO.select();

        if (usuarios.isEmpty()) { // se a lista está vazia, é porque não existe um usuário cadastrado
            Usuario padrao = new Usuario();
            padrao.setNome("Usuario Padrão");
            padrao.setLogin("admin");
            padrao.setSenha("admin");

            return usuarioDAO.insert(padrao);
        }

        return true;
    }

    public Usuario login(String usuario, String senha) {
        return usuarioDAO.login(usuario, senha);
    }

    public boolean cadastraOuAtualiza(Usuario usuario) {
        return usuarioDAO.insert(usuario);
    }

    public boolean cadastraOuAtualiza(Produto produto) {
        if (produto.getCodigo() == 0) {
            return produtoDAO.insert(produto);
        } else {
            return produtoDAO.update(produto);
        }
    }

    public List<Produto> obtemCatalogoDeProdutos() {
        return produtoDAO.select();
    }

    public boolean remove(Produto produto) {
        return produtoDAO.delete(produto);
    }

    public Produto obtemProdutoPor(int codigo) {
        return produtoDAO.findBy(codigo);
    }

    public boolean cadastraOuAtualiza(Entrada entrada) {
        if (entrada.getCodigo() == 0) {
            return entradaDAO.insert(entrada);
        } else {
            return entradaDAO.update(entrada);
        }
    }

    public boolean cadastraOuAtualiza(Saida saida) {
        if (saida.getCodigo() == 0) {
            return saidaDAO.insert(saida);
        } else {
            return saidaDAO.update(saida);
        }
    }
}
