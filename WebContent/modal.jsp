<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal fade" id="confirmaExclusao">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">Excluir candidato</h4>
      </div>
      <div class="modal-body">
        <p>Tem certeza que deseja excluir este registro?</p>
      </div>
      <div class="modal-footer">
      	<input type="hidden" id="candidatoId" value="0" /> 
        <button type="button" id="confirmar" class="btn btn-default" data-dismiss="modal" data-candidato-id="0">Sim</button>
        <button type="button" id="cancelar" class="btn btn-primary">Cancelar</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->