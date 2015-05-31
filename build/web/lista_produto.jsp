<%-- 
    Document   : lista_produto
    Created on : 12/04/2015, 00:38:02
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entidades.Produto"%>
<%@page import="java.util.List"%>
<%@page import="controlador.Controlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <table border="1" cellpadding="5" cellspacing="0">
            <tr>
                <th>Produto</th>
                <th>Qtde em estoque</th>
                <th>Custo</th>
                <th>Preço</th>
                <th>Data de cadastro</th>
                <th>Cadastrado por</th>
            </tr>
            <%
                Controlador controlador = Controlador.getInstance();
                List<Produto> produtos = controlador.obtemCatalogoDeProdutos();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                for (Produto produto : produtos) {
            %>

            <tr>
                <td><%=produto%></td>
                <td><%=produto.getQuantidade()%></td>
                <td><%=produto.getPrecoCusto()%></td>
                <td><%=produto.getPreco()%></td>
                <td><%=sdf.format(produto.getDataCadastro())%></td>
                <td><%=produto.getUsuario()%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
