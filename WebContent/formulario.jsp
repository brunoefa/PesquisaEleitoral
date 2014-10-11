<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="cabecalho.jsp" />
<jsp:include page="titulo-cadastro.jsp" />
<div class="container">
		<!-- Example row of columns -->
			<form role="form" action="candidato" method="get" id="formulario">
			<input type="hidden" name="acao" value="salvar" />
			<input type="hidden" name="id" value="${candidato.id}" />
			<input type="hidden" name="status" id="status" value="true" />
			<div class="row">
				<div class="col-md-2 align-right">
					<img src="${candidato.foto}"
						 alt="Candidato" class="img-circle avatar-cadastro">
				</div>
				<div class="col-md-10">
						<div class="form-group">
							<label for="input-name">Nome</label> 
							<input type="text" value="${candidato.nome}" name="nome" class="form-control" id="input-name" placeholder="Informe o nome do candidato">
						</div>
						<div class="form-group">
							<label for="input-foto">Foto</label>
							<input type="text" value="${candidato.foto}" class="form-control" name="foto" id="input-foto" placeholder="Informe a url da foto">
						</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-2">
					<div class="form-group">
						<label for="input-numero">Número</label>
						<input type="text" value="${candidato.numero}" class="form-control" name="numero" id="input-numero" placeholder="XX">
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label for="input-partido">Partido</label>
						<select class="form-control" id="input-partido" name="partido" data-option-selected="${candidato.partido}">
							<option>PDT</option>
							<option>PT</option>
							<option>DEM</option>
							<option>PCdoB</option>
							<option>PSB</option>
							<option>PSDB</option>
							<option>PTC</option>
							<option>PSC</option>
							<option>PMN</option>
							<option>PRP</option>
							<option>PPS</option>
							<option>PV</option>
							<option>PTdoB</option>
							<option>PP</option>
							<option>PSTU</option>
							<option>PCB</option>
							<option>PRTB</option>
							<option>PHS</option>
							<option>PSDC</option>
							<option>PCO</option>
							<option>PTN</option>
							<option>PSL</option>
							<option>PRB</option>
							<option>PSOL</option>
							<option>PR</option>
							<option>PSD</option>
							<option>PPL</option>
							<option>PEN</option>
							<option>PROS</option>
						</select>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="input-cargo">Cargo</label>
						<select class="form-control" id="input-partido" name="cargo" id="input-cargo" data-option-selected="${candidato.cargo}">
							<option>Presidente da República</option>
							<option>Governador</option>
							<option>Deputado Federal</option>
							<option>Deputado Estadual</option>
							<option>Senador</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-10 align-right">
					<a href="/pesquisa">Cancelar</a>
					<button type="button" id="rascunho" class="btn btn-default btn-lg publicar">Salvar como rascunho</button>
					<button type="button" id="publicar" class="btn btn-primary btn-lg salvar">Publicar</button>
				</div>
			</div>
		</form>
	</div>
<jsp:include page="rodape.jsp" />