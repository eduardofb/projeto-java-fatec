<form class="form-horizontal" method="POST" action="cliente">
<fieldset>

<!-- Form Name -->
<legend>Cliente</legend>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Nome</label>
  <div class="controls">
    <input id="nome" name="textinput" placeholder="nome" class="input-xlarge" required="" type="text">
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">CPF</label>
  <div class="controls">
    <input id="cpf" name="textinput" placeholder="cpf" class="input-xlarge" required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Endereço</label>
  <div class="controls">
    <input id="endereco" name="textinput" placeholder="endereco" class="input-xlarge" required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Aniversário</label>
  <div class="controls">
    <input id="aniversario" name="textinput" placeholder="aniversario" class="input-xlarge" required="" type="text">
  </div>
</div>

<input type="hidden" value="<% request.getSession().getAttribute("usuario"); %>" name="id"/>

<!-- Button -->
<div class="control-group">
  <label class="control-label" for="salvar"></label>
  <div class="controls">
    <button id="salvar" name="salvar" class="btn btn-primary">Salvar</button>
  </div>
</div>

</fieldset>
</form>
