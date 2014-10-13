$( document ).ready(function() {
	
	// Confirmação de exclusão
	
	$('#confirmaExclusao #confirmar').click(function (e) {
		id = $("#confirmaExclusao #candidatoId").val();
		destino = 'candidato?acao=deletar&id=' + id;
		window.location.href = destino;
	});

	$('#confirmaExclusao #cancelar').click(function (e) {
		$('#confirmaExclusao').modal('hide')
	});
	
	$('#linkDeletar').click(function (e) {
		id = $(this).data("candidato-id");
		$("#confirmaExclusao #candidatoId").val(id);
	});
	
	$('#confirmaExclusao #cancelar').click(function (e) {
		$('#confirmaExclusao').modal('hide')
	});
	
	// Controle de status

	$('#rascunho').click(function (e) {
		$("#status").val('false');
		$("#formulario").submit();
	});
	
	$('#publicar').click(function (e) {
		$("#status").val('true');
		$("#formulario").submit();
	});
	
	// Preenchimento de combobox
	
	partido = $("#input-partido").data("option-selected");
	$("#input-partido").val(partido);
	
	cargo = $("#input-cargo").data("option-selected");
	$("#input-cargo").val(cargo);
	
	// Carregamento de fotos
	
	$("#input-foto").blur(function (e) {
		foto = $(this).val();
		$("#foto").attr("src",foto);
	});
	
	src = $("#foto").attr("src");
	if (src == "") {
		$("#foto").attr("src","http://demo.patternlab.io/images/fpo_avatar.png");
	}

});