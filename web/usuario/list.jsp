<%@page import="java.util.List"%>
<%@page import="entidades.Usuario"%>
<%@page import="java.util.Collection"%>
<%@page import="controlador.HibernateUtil"%>
<%@page import="modelo.UsuarioModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
        
        <title>Usuaris cadastrados</title>
    </head>
    <body>
        <div class="container">        
            <%@include file="../templates/_menu.jsp" %>
        
            <% UsuarioModelo modelo = new UsuarioModelo(HibernateUtil.getSessionFactory()); %>
                <table class="table">
                    <tr>
                        <td>#</td>
                        <td>Nome</td>
                        <td>Login</td>
                        <td></td>
                        <td></td>
                        <!-- Senha não exibida por questões de segurança -->
                    </tr>

                    <% 
                        List<Usuario> usuarios = modelo.retornarTodos(); 
                        for(int i = 0; i < usuarios.size(); i++) {
                            Usuario usuario = usuarios.get(i);
                    %>
                        <tr>
                            <td><%=usuario.getId() %></td>
                            <td><%=usuario.getNome() %></td>
                            <td><%=usuario.getLogin() %></td>
                            <td>
                                <a href="/usuario/atualizar?id=<%=usuario.getId()%>" class="btn btn-warning">Atualizar</a> 
                                <a href="/usuario/delete?id=<%=usuario.getId()%>" class="btn btn-danger">Excluir</a>
                            </td>
                        </tr>
                    <% } %>

                </table>
                <a class="btn btn-primary" href="/usuario?action=novo" >Cadastrar novo</a>    
        </div>
    </body>
</html>
