<%-- 
    Document   : cadastro_usuario
    Created on : 18/04/2015, 11:33:19
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="cadastraUsuario" method="POST">
            <fieldset>
                <legend>Usuário</legend>
                <table>
                    <tr>
                        <td><label>Nome</label></td>
                        <td><input type="text" name="nome" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>Login</label></td>
                        <td><input type="text" name="login" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>Senha</label></td>
                        <td><input type="password" name="senha" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>Confirma senha</label></td>
                        <td><input type="password" name="confirmaSenha" value="" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><center><input type="submit" value="Cadastrar" /></center></td>
                    </tr>
                </table>

            </fieldset>
        </form>
    </body>
</html>
