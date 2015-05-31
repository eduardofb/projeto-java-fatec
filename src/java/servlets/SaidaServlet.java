/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.Controlador;
import entidades.Produto;
import entidades.Saida;
import entidades.Usuario;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Data;

public class SaidaServlet extends HttpServlet {

    private Controlador controlador;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.

        controlador = Controlador.getInstance();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int codProduto = Integer.valueOf(request.getParameter("produto"));
        Produto produto = controlador.obtemProdutoPor(codProduto);
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        String cpfCliente = request.getParameter("cpfCliente");
        Date dataSaida = Data.converte(request.getParameter("dataSaida"));
        Double quantidade = Double.valueOf(request.getParameter("quantidade"));

        Saida saida = new Saida();
        saida.setCpfCliente(cpfCliente);
        saida.setData(dataSaida);
        saida.setPreco(produto.getPreco());
        saida.setProduto(produto);
        saida.setQuantidade(quantidade);
        saida.setTotal(produto.getPreco() * quantidade);
        saida.setUsuario(usuario);

        produto.setQuantidade(produto.getQuantidade() - quantidade);

        boolean atualizouProduto = controlador.cadastraOuAtualiza(produto);
        boolean cadastrouSaida = controlador.cadastraOuAtualiza(saida);

        if (cadastrouSaida && atualizouProduto) {
            response.sendRedirect("lista_produto.jsp");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Não foi possível realizar a saída do produto.");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
