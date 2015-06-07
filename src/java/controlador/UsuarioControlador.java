/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.UsuarioModelo;

/**
 *
 * @author Jayme
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/usuario"})
public class UsuarioControlador extends HttpServlet {

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
            request.getRequestDispatcher("/usuario/list.jsp").forward(request, response);
        } else if(acao.equals("novo")) {
            request.getRequestDispatcher("/usuario/create.jsp").forward(request, response);
        } else if(acao.equals("atualizar")) {
            request.getRequestDispatcher("/usuario/update.jsp").forward(request, response);
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
        
        //requisicao para deletar.
        System.out.println("excluindo!");
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
            UsuarioModelo modelo = new UsuarioModelo(HibernateUtil.getSessionFactory());
            if(request.getParameter("id").isEmpty()) { //Novo registro
                Usuario usuario = new Usuario();
                usuario.setId(new Random(1000).nextInt());
                usuario.setNome(request.getParameter("nome"));
                usuario.setLogin(request.getParameter("login"));
                usuario.setSenha(request.getParameter("senha"));

                
                modelo.salvar(usuario);
            } else {
                Usuario usuario = modelo.procurarPorId(new Long(request.getParameter("id")));
                usuario.setNome(request.getParameter("nome"));
                usuario.setLogin(request.getParameter("login"));
                usuario.setSenha(request.getParameter("senha"));
                
                modelo.atualizar(usuario);
            }
            request.getRequestDispatcher("/usuario/list.jsp").forward(request, response);
       
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
