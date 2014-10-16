$(document).ready(function() {
	// Confirmação de exclusão
	
	$("#linkDeletar").on("click", function() {
		var id = $(this).data("candidato-id");
		alert (id);
//		$("#confirmaExclusao #candidatoId").val(id);
	});
	
	$('#confirmaExclusao #confirmar').click(function (e) {
		id = $("#confirmaExclusao #candidatoId").val();
		destino = 'candidato?acao=deletar&id=' + id;
//		window.location.href = destino;
	});

	$('#confirmaExclusao #cancelar').click(function (e) {
		$('#confirmaExclusao').modal('hide')
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
	
	partido = $("#input-partido").data("partido");
	$("#input-partido").val(partido);
	
	cargo = $("#input-cargo").data("cargo");
	$("#input-cargo").val(cargo);
	
	// Carregamento de fotos
	
	$("#input-foto").blur(function (e) {
		src = $(this).val();
		if (src == "") {
			$("#foto").attr("src","http://demo.patternlab.io/images/fpo_avatar.png");
		}else{
			$("#foto").attr("src",src);
		}
	});
	
	$("#formulario").submit(function (e) {
		src = $("#foto").val();
		if (src == "") {
			$("#input-foto").val("http://demo.patternlab.io/images/fpo_avatar.png");
		}
	});
});