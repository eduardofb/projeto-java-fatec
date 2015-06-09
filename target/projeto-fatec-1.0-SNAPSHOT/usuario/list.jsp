<%@page import="br.com.fatec.entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto FATEC</title>
        
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/css/bootstrap.responsive.min.css" rel="stylesheet"/>
        
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">        
            <%@include file="../templates/_menu.jsp" %>
        
            <% List<Usuario> usuarios = (List) session.getAttribute("usuarios"); %>
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
                        for(int i = 0; i < usuarios.size(); i++) {
                            Usuario usuario = usuarios.get(i);
                    %>
                        <tr>
                            <td><%=usuario.getId() %></td>
                            <td><%=usuario.getNome() %></td>
                            <td><%=usuario.getLogin() %></td>
                            <td>
                                <a href="alteraUsuario?id=<%=usuario.getId()%>" class="btn btn-warning">Atualizar</a> 
                                <a href="excluiUsuario?id=<%=usuario.getId()%>" class="btn btn-danger">Excluir</a>
                            </td>
                        </tr>
                    <% } %>

                </table>
                <a class="btn btn-primary" href="/usuario?action=novo" >Cadastrar novo</a>    
        </div>
    </body>
</html>
