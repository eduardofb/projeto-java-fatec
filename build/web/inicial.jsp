<%-- 
    Document   : inicial
    Created on : 11/04/2015, 18:32:21
--%>

<%@page import="entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Usuario usuario = (Usuario) session.getAttribute("usuario");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/menu.css" />
        <script> <%-- Javascript --%>
            function abreCadastroUsuario() {
                document.getElementById("conteudo").innerHTML = '<object type="text/html" data="cadastro_usuario.jsp" />';
            }
            
            function abreCadastroProduto() {
                document.getElementById("conteudo").innerHTML = '<object type="text/html" data="cadastro_produto.jsp" />';
            }

            function abreCatalogoProduto() {
                document.getElementById("conteudo").innerHTML = '<object type="text/html" data="lista_produto.jsp" />';
            }

            function abreEntrada() {
                document.getElementById("conteudo").innerHTML = '<object type="text/html" data="entrada.jsp" />';
            }

            function abreSaida() {
                document.getElementById("conteudo").innerHTML = '<object type="text/html" data="saida.jsp" />';
            }
        </script>
    </head>
    <body>
        <h1>Olá <%= usuario.getNome()%></h1>
        <nav>
            <ul class="menu">
                <li><a href="#" onclick="abreCadastroUsuario()">Usuário</a></li>
                <li><a href="#">Produtos</a>
                    <ul>
                        <li><a href="#" onclick="abreCadastroProduto()">Cadastrar novo</a></li>
                        <li><a href="#" onclick="abreCatalogoProduto()">Visualizar catálogo</a></li>
                    </ul>
                </li>
                <li><a href="#" onclick="abreEntrada()">Entrada</a></li>
                <li><a href="#" onclick="abreSaida()">Saida</a></li>
            </ul>
        </nav>
        <div id="conteudo"></div> <%-- Parte cinza do meio da tela --%>
    </body>
</html>
