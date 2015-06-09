/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controlador;

import br.com.fatec.entidades.Saida;
import br.com.fatec.entidades.Usuario;
import br.com.fatec.modelo.ClienteModelo;
import br.com.fatec.modelo.ProdutoModelo;
import br.com.fatec.modelo.SaidaModelo;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlos
 */
@WebServlet(name = "SaidaControlador", urlPatterns = {"/saida"})
public class SaidaControlador extends HttpServlet {

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
        if(acao.equals("lista")) {
            request.getRequestDispatcher("/saida/list.jsp").forward(request, response);
        } else if(acao.equals("novo")) {
            request.getRequestDispatcher("/saida/create.jsp").forward(request, response);
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
        
        try {
            SaidaModelo modelo = new SaidaModelo(HibernateUtil.getSessionFactory());
            Saida cliente = modelo.procurarPorId(new Long(request.getParameter("id")));
            modelo.excluir(cliente);
            request.getRequestDispatcher("/saida/list.jsp").forward(request, response);
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
            SaidaModelo saidaModelo = new SaidaModelo(HibernateUtil.getSessionFactory());
            ClienteModelo clienteModelo = new ClienteModelo(HibernateUtil.getSessionFactory());
            ProdutoModelo produtoModelo = new ProdutoModelo(HibernateUtil.getSessionFactory());
            
            if(request.getParameter("id").isEmpty()) { //Novo registro
                Saida saida = new Saida();
                saida.setId(new Random(1000).nextInt());
                saida.setUsuario( (Usuario) request.getSession().getAttribute("usuario"));
                saida.setCliente(clienteModelo.procurarPorId(new Long(request.getParameter("cliente"))));
                saida.setProduto(produtoModelo.procurarPorId(new Long(request.getParameter("produto"))));
                saida.setPreco(new BigDecimal(request.getParameter("preco")));
                saida.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                saida.setTotal(Integer.parseInt(request.getParameter("total")));
                
                saidaModelo.salvar(saida);
            } 
            
            request.getRequestDispatcher("/cliente/list.jsp").forward(request, response);
       
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
