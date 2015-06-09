<%@page import="entidades.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="modelo.ClienteModelo"%>
<%@page import="controlador.HibernateUtil"%>
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
        
            <% ClienteModelo modelo = new ClienteModelo(HibernateUtil.getSessionFactory()); %>
            
             <table class="table">
            <tr>
                <td>#</td>
                <td>Nome</td>
            </tr>
            
            <%
                List<Cliente> clientes = modelo.retornarTodos();
                for(int i = 0; i < clientes.size(); i++) {
                    Cliente cliente = clientes.get(i);
            %>
            <tr>
                <td><%=cliente.getId() %></td>
                <td><%=cliente.getNome() %></td>
                          
                <td>
                    <a href="/cliente/atualizar?id=<%=cliente.getId()%>" class="btn btn-warning">Atualizar</a> 
                    <a href="/cliente/delete?id=<%=cliente.getId()%>" class="btn btn-danger">Excluir</a>
                </td>
            </tr>
            <% } %>
        </table>
        <a class="btn btn-primary" href="/cliente?action=novo" >Cadastrar novo</a>
        </div>
        
       
    </body>
</html>
