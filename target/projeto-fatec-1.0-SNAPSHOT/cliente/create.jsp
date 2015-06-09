<%-- 
    Document   : create
    Created on : Jun 4, 2015, 3:16:23 PM
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
            <div class="row">
                <div class="span12">
                    <%@include file="_form.jsp" %>
                </div>
            </div>
        </div>
    </body>
</html>
