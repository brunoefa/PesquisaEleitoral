<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="cabecalho.jsp" />
<jsp:include page="titulo-cadastro.jsp" />
<div class="container">
		<!-- Example row of columns -->
			<form role="form" action="candidato" method="get">
			<input type="hidden" name="acao" value="salvar" />
			<div class="row">
				<div class="col-md-2 align-right">
					<img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxNDAiIGhlaWdodD0iMTQwIj48cmVjdCB3aWR0aD0iMTQwIiBoZWlnaHQ9IjE0MCIgZmlsbD0iI2VlZSIvPjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjcwIiB5PSI3MCIgc3R5bGU9ImZpbGw6I2FhYTtmb250LXdlaWdodDpib2xkO2ZvbnQtc2l6ZToxMnB4O2ZvbnQtZmFtaWx5OkFyaWFsLEhlbHZldGljYSxzYW5zLXNlcmlmO2RvbWluYW50LWJhc2VsaW5lOmNlbnRyYWwiPjE0MHgxNDA8L3RleHQ+PC9zdmc+"
						 alt="Candidato" class="img-circle avatar-cadastro">
				</div>
				<div class="col-md-10">
						<div class="form-group">
							<label for="input-name">Nome</label> 
							<input type="text" name="nome" class="form-control" id="input-name" placeholder="Informe o nome do candidato">
						</div>
						<div class="form-group">
							<label for="input-foto">Foto</label>
							<input type="text" class="form-control" name="foto" id="input-foto" placeholder="Informe a url da foto">
						</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-2">
					<div class="form-group">
						<label for="input-numero">Número</label>
						<input type="text" class="form-control" name="numero" id="input-numero" placeholder="XX">
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label for="input-partido">Partido</label>
						<select class="form-control" id="input-partido" name="partido">
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
						<select class="form-control" id="input-partido" name="cargo" id="input-cargo">
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
					<a href="#">Cancelar</a><button type="submit" class="btn btn-primary btn-lg salvar">Salvar</button>
				</div>
			</div>
		</form>
	</div>
<jsp:include page="rodape.jsp" />