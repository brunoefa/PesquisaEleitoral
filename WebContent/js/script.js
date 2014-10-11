$( document ).ready(function() {
	$('#confirmaExclusao #confirmar').click(function (e) {
		id = $("#linkDeletar").data("candidato-id");
		destino = 'candidato?acao=deletar&id=' + id;
		window.location.href = destino;
	});

	$('#confirmaExclusao #cancelar').click(function (e) {
		$('#confirmaExclusao').modal('hide')
	});
	
	$('#rascunho').click(function (e) {
		$("#status").val('false');
		$("#formulario").submit();
	});
	
	$('#publicar').click(function (e) {
		$("#status").val('true');
		$("#formulario").submit();
	});
});