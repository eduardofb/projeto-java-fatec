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
            <div class="row">
		<div class="span12">
			<form class="form-horizontal" action='login' method="POST">
                            
                            <% 
                                String erro = request.getParameter("erro");
                                if(erro != null) {
                                    out.append("<div class='alert alert-danger' role='alert'>");
                                    out.append(request.getParameter("erro"));
                                    out.append("</div>");
                                }
                            %>
                            
			  <fieldset>
			    <div id="legend">
			      <legend class="">Login</legend>
			    </div>
			    <div class="control-group">
			      <!-- Username -->
			      <label class="control-label"  for="username">Usuário</label>
			      <div class="controls">
			        <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- Password-->
			      <label class="control-label" for="password">Senha</label>
			      <div class="controls">
			        <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- Button -->
			      <div class="controls">
			        <button class="btn btn-success">Acessar</button>
			      </div>
			    </div>
			  </fieldset>
			</form>
		</div>
	</div>
    </body>
</html>
