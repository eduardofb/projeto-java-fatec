<%-- 
    Document   : entrada
    Created on : 13/04/2015, 16:11:15
--%>

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
        <form action="entrada" method="POST">
            <fieldset>
                <legend>Entrada</legend>
                <table>
                    <tr>
                        <td>Produto</td>
                        <td>
                            <select name="produto">
                                <%
                                    Controlador c = Controlador.getInstance();
                                    List<Produto> produtos = c.obtemCatalogoDeProdutos();

                                    for (Produto produto : produtos) {
                                %>
                                <option value="<%=produto.getCodigo()%>"><%=produto%></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label>CNPJ Fornecedor</label></td>
                        <td><input type="text" name="cnpj" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>Data entrada</label></td>
                        <td><input type="datetime-local" name="dataEntrada" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>Preço unitário</label></td>
                        <td><input type="text" name="preco" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>Quantidade</label></td>
                        <td><input type="number" name="quantidade" value="" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><center><input type="submit" value="Realizar entrada" /></center></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>
