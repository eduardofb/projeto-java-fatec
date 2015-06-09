/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controlador;

import br.com.fatec.entidades.Fornecedor;
import br.com.fatec.entidades.Usuario;
import br.com.fatec.modelo.FornecedorModelo;
import java.io.IOException;
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
@WebServlet(name = "FornecedorControlador", urlPatterns = {"/fornecedor"})
public class FornecedorControlador extends HttpServlet {

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
            request.getRequestDispatcher("/fornecedor/list.jsp").forward(request, response);
        } else if(acao.equals("novo")) {
            request.getRequestDispatcher("/fornecedor/create.jsp").forward(request, response);
        } else if(acao.equals("atualizar")) {
            request.getRequestDispatcher("/fornecedor/update.jsp").forward(request, response);
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
            FornecedorModelo modelo = new FornecedorModelo(HibernateUtil.getSessionFactory());
            Fornecedor fornecedor = modelo.procurarPorId(new Long(request.getParameter("id")));
            modelo.excluir(fornecedor);
            request.getRequestDispatcher("/fornecedor/list.jsp").forward(request, response);
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
            FornecedorModelo modelo = new FornecedorModelo(HibernateUtil.getSessionFactory());
            if(request.getParameter("id").isEmpty()) { //Novo registro
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(new Random(1000).nextInt());
                fornecedor.setNome(request.getParameter("nome"));
                fornecedor.setCnpj(request.getParameter("cnpj"));
                fornecedor.setEndereco(request.getParameter("endereco"));
                
                Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
                fornecedor.setUsuario(usuario);
                
                modelo.salvar(fornecedor);
            } else {
                
                Fornecedor fornecedor =  modelo.procurarPorId(new Long(request.getParameter("id")));
                fornecedor.setNome(request.getParameter("nome"));
                fornecedor.setCnpj(request.getParameter("cnpj"));
                fornecedor.setEndereco(request.getParameter("endereco"));
                
                modelo.atualizar(fornecedor);
            }
            request.getRequestDispatcher("/fornecedor/list.jsp").forward(request, response);
       
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
