/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Produto;
import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DepartamentoModelo;
import modelo.ProdutoModelo;

/**
 * Controlador de produtos
 * 
 * @author Jayme
 */
@WebServlet(name = "ProdutoControlador", urlPatterns = {"/produto"})
public class ProdutoControlador extends HttpServlet {

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
        
        String acao = request.getParameter("action");
        System.out.println(acao);
        if(acao.equals("lista")) {
            request.getRequestDispatcher("/produto/list.jsp").forward(request, response);
        } else if(acao.equals("novo")) {
            request.getRequestDispatcher("/produto/create.jsp").forward(request, response);
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
        try {
            ProdutoModelo modelo = new ProdutoModelo(HibernateUtil.getSessionFactory());
            Produto produto = modelo.procurarPorId(new Long(request.getParameter("id")));
            modelo.excluir(produto);
            request.getRequestDispatcher("/produto/list.jsp").forward(request, response);
        } catch(Exception ex) {
            response.sendError(500);
            ex.printStackTrace();
        }
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
        
        try {
            ProdutoModelo produtoModelo = new ProdutoModelo(HibernateUtil.getSessionFactory());
            DepartamentoModelo departamentoModelo = new DepartamentoModelo(HibernateUtil.getSessionFactory());
            if(request.getParameter("id").isEmpty()) { //Novo registro
                Produto produto = new Produto();
                produto.setId(new Random(1000).nextInt());
                produto.setDepartamento(departamentoModelo.procurarPorId(new Long(request.getParameter("id"))));
                produto.setUsuario( (Usuario) request.getSession().getAttribute("usuario"));
                produto.setDescricao(request.getParameter("descricao"));
                produto.setPrecoCusto(new BigDecimal(request.getParameter("pcusto")));
                produto.setPreco(new BigDecimal(request.getParameter("preco")));
                produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                produto.setDataCadastro(new Date());
                produto.setMargemEstoque(Integer.parseInt(request.getParameter("estoque")));
                
                
                produtoModelo.salvar(produto);
            } 
            request.getRequestDispatcher("/produto/list.jsp").forward(request, response);
       
        } catch(Exception ex) {
            System.out.println("Erro");
        }
        
        
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
