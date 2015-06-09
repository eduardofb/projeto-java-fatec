/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controlador;

import br.com.fatec.entidades.Departamento;
import br.com.fatec.entidades.Usuario;
import br.com.fatec.modelo.DepartamentoModelo;
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
@WebServlet(name = "DepartamentoControlador", urlPatterns = {"/departamento"})
public class DepartamentoControlador extends HttpServlet {

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
            request.getRequestDispatcher("/departamento/list.jsp").forward(request, response);
        } else if(acao.equals("novo")) {
            request.getRequestDispatcher("/departamento/create.jsp").forward(request, response);
        } else if(acao.equals("atualizar")) {
            request.getRequestDispatcher("/departamento/update.jsp").forward(request, response);
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
            DepartamentoModelo modelo = new DepartamentoModelo(HibernateUtil.getSessionFactory());
            Departamento departamento = modelo.procurarPorId(new Long(request.getParameter("id")));
            modelo.excluir(departamento);
            request.getRequestDispatcher("/departamento/list.jsp").forward(request, response);
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
            DepartamentoModelo modelo = new DepartamentoModelo(HibernateUtil.getSessionFactory());
            if(request.getParameter("id").isEmpty()) { //Novo registro
                Departamento departamento = new Departamento();
                departamento.setId(new Random(1000).nextInt());
                departamento.setDescricao(request.getParameter("descricao"));
                
                Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
                departamento.setUsuario(usuario);
                
                modelo.salvar(departamento);
            } else {
                
                Departamento departamento = modelo.procurarPorId(new Long(request.getParameter("id")));
                departamento.setDescricao(request.getParameter("descricao"));
                modelo.atualizar(departamento);
            }
            request.getRequestDispatcher("/departamento/list.jsp").forward(request, response);
       
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
