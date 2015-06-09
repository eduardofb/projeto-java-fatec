<form class="form-horizontal" method="POST" action="usuario">
<fieldset>

<!-- Form Name -->
<legend>Usuario</legend>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Nome</label>
  <div class="controls">
      <input id="nome" name="nome" placeholder="nome" class="input-xlarge" required="" type="text" value="<% request.getParameter("nome"); %>">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Login</label>
  <div class="controls">
      <input id="login" name="login" placeholder="login" class="input-xlarge" required="" type="text" value="<% request.getParameter("login"); %>">
    
  </div>
</div>

<!-- Password input-->
<div class="control-group">
  <label class="control-label" for="passwordinput">Senha</label>
  <div class="controls">
      <input id="senha" name="senha" placeholder="senha" class="input-xlarge" required="" type="password" value="<% request.getParameter("senha"); %>">
    
  </div>
</div>

<!-- Button -->
<div class="control-group">
  <label class="control-label" for="salvar"></label>
  <div class="controls">
    <button id="salvar" name="salvar" class="btn btn-primary">Salvar</button>
  </div>
</div>

</fieldset>
</form>
