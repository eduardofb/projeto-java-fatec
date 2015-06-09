/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controlador.usuario;

import br.com.fatec.controlador.HibernateUtil;
import br.com.fatec.entidades.Usuario;
import br.com.fatec.modelo.UsuarioModelo;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controlador de salvar cliente
 * 
 * @author Jayme
 */
@WebServlet(name = "AdicionaUsuarioControlador", urlPatterns = {"/adicionaUsuario"})
public class AdicionaUsuarioControlador extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //instanciando o modelo
            UsuarioModelo modelo = new UsuarioModelo(HibernateUtil.getSessionFactory());

            //Pegando os parâmetros do request
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            
            Usuario usuario = new Usuario();
            usuario.setId(new Random(1000).nextLong());
            usuario.setNome(nome);
            usuario.setLogin(login);
            usuario.setSenha(request.getParameter(""));
            
            
            modelo.salvar(usuario);
            
            request.getRequestDispatcher("/usuario/list.jsp").forward(request, response);
        } catch(Exception ex) {
            ex.printStackTrace();
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
        service(request, response);
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
        service(request, response);
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
