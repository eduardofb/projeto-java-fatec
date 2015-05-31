<%-- 
    Document   : saida
    Created on : 13/04/2015, 23:17:03
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
        <form action="saida" method="POST">
            <fieldset>
                <legend>Saída</legend>
                <table>
                    <tr>
                        <td><label>Produto</label></td>
                        <td>
                            <select name="produto">
                                <%
                                    Controlador controlador = Controlador.getInstance();
                                    List<Produto> produtos = controlador.obtemCatalogoDeProdutos();
                                    for (Produto produto : produtos) {
                                %>
                                <option value="<%=produto.getCodigo()%>"><%=produto%></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label>CPF cliente</label></td>
                        <td><input type="text" name="cpfCliente" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>Data saída</label></td>
                        <td><input type="datetime-local" name="dataSaida" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>Quantidade</label></td>
                        <td><input type="number" name="quantidade" value="" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><center><input type="submit" value="Realizar saída" /></center></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>
