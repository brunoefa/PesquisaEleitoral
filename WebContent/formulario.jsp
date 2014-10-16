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
					<img src="${candidato.foto}" alt="Candidato" class="img-circle avatar-cadastro" id="foto">
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
						<select class="form-control" id="input-partido" name="partido" data-partido="${candidato.partido}">
							<option value="PDT" >PDT</option>
							<option value="PT" >PT</option>
							<option value="DEM" >DEM</option>
							<option value="PCdoB" >PCdoB</option>
							<option value="PSB" >PSB</option>
							<option value="PSDB" >PSDB</option>
							<option value="PTC" >PTC</option>
							<option value="PSC" >PSC</option>
							<option value="PMN" >PMN</option>
							<option value="PRP" >PRP</option>
							<option value="PPS" >PPS</option>
							<option value="PV" >PV</option>
							<option value="PTdoB" >PTdoB</option>
							<option value="PP" >PP</option>
							<option value="PSTU" >PSTU</option>
							<option value="PCB" >PCB</option>
							<option value="PRTB" >PRTB</option>
							<option value="PHS" >PHS</option>
							<option value="PSDC" >PSDC</option>
							<option value="PCO" >PCO</option>
							<option value="PTN" >PTN</option>
							<option value="PSL" >PSL</option>
							<option value="PRB" >PRB</option>
							<option value="PSOL" >PSOL</option>
							<option value="PR" >PR</option>
							<option value="PSD" >PSD</option>
							<option value="PPL" >PPL</option>
							<option value="PEN" >PEN</option>
							<option value="PROS" >PROS</option>
						</select>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="input-cargo">Cargo</label>
						<select class="form-control" id="input-cargo" name="cargo" id="input-cargo" data-cargo="${candidato.cargo}">
							<option value="Presidente da República" >Presidente da República</option>
							<option value="Governador" >Governador</option>
							<option value="Deputado Federal" >Deputado Federal</option>
							<option value="Deputado Estadual" >Deputado Estadual</option>
							<option value="Senador" >Senador</option>
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