/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.usuario;

import controlador.HibernateUtil;
import entidades.Cliente;
import entidades.Usuario;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ClienteModelo;
import modelo.UsuarioModelo;

/**
 *
 * @author carlos
 */
@WebServlet(name = "AlteraUsuario"
        + "Controlador", urlPatterns = {"/alteraUsuario"})
public class AlteraUsuarioControlador extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            //instanciando o modelo
            UsuarioModelo modelo = new UsuarioModelo(HibernateUtil.getSessionFactory());
            
            //Pegando os parâmetros do request
            String codigo = request.getParameter("id");
            
            //Busca o usuario na base
            Usuario usuario = modelo.procurarPorId(new Long(codigo));
            request.setAttribute("nome", usuario.getNome());
            request.setAttribute("login", usuario.getLogin());
            request.setAttribute("senha", usuario.getSenha());
            
            request.getRequestDispatcher("/usuario/update.jsp").forward(request, response);
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
