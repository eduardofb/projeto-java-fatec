<%-- 
    Document   : cadastro_produto
    Created on : 12/04/2015, 00:03:04
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="produto" method="POST">
            <fieldset>
                <legend>Cadastro de produtos</legend>
                <table>
                    <tbody>
                        <tr>
                            <td><label for="descricao">Descrição</label></td>
                            <td><input type="text" name="descricao" value="" /></td>
                        </tr>
                        <tr>
                            <td><label for="precoCusto">Preço de custo</label></td>
                            <td><input type="text" name="precoCusto" value="" /></td>
                        </tr>
                        <tr>
                            <td><label for="preco">Preço final</label></td>
                            <td><input type="text" name="preco" value="" /></td>
                        </tr>
                        <tr>
                            <td colspan="2"><center><input type="submit" value="Cadastrar" name="cadastrar" /></center></td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </form>
    </body>
</html>
