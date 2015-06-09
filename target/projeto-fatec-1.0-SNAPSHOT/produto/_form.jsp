<form class="form-horizontal" method="POST" action="UsuarioController">
<fieldset>

<!-- Form Name -->
<legend>Produto</legend>


<div class="control-group">
  <label class="control-label" for="textinput">Descricao</label>
  <div class="controls">
    <input id="descricao" name="descricao" placeholder="nome" class="input-xlarge" required="" type="text">
    
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="textinput">Preco de custo</label>
  <div class="controls">
    <input id="p_custo" name="p_custo" placeholder="custo" class="input-xlarge" required="" type="text">
    
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="textinput">Preco</label>
  <div class="controls">
    <input id="preco" name="preco" placeholder="preco" class="input-xlarge" required="" type="text">
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
