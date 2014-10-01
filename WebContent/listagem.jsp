<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="cabecalho.jsp" />
<jsp:include page="titulo-listagem.jsp" />

<div class="container">
      <!-- Example row of columns -->
      <div class="row candidato">
        <div class="col-md-12">
          <div class="col-md-3">
          	<img src="${candidato.foto}" alt="${candidato.nome}" class="img-circle avatar">
          </div>
          <div class="col-md-7">
          	<h1 class="nome">${candidato.nome}</h1>
          	<h4 class="cargo">${candidato.cargo}</h4>
          	<span class="label label-danger">${candidato.partido}</span>&nbsp;<span class="label label-default">${candidato.numero}</span>
          	<div class="progress votos">
			  <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
			    1423 Votos
			  </div>
			</div>
          </div>
          <div class="col-md-2 align-right padding-top-100">
          	<p><button type="button" class="btn btn-primary btn-lg">Votar</button></p>
          </div>
        </div>
      </div>
      <div class="row candidato">
        <div class="col-md-12">
          <div class="col-md-3">
          	<img src="https://lh4.googleusercontent.com/-O6wULF3GnJc/U9mKGp_ik6I/AAAAAAAADzo/KxZY6PWn32A/s499-no/avatarAecio_01-2.jpg" alt="Aécio Neves" class="img-circle avatar">
          </div>
          <div class="col-md-7">
          	<h1 class="nome">Aécio Neves</h1>
          	<h4 class="cargo">Presidente da República</h4>
          	<span class="label label-danger">PSDB</span>&nbsp;<span class="label label-default">45</span>
          	<div class="progress votos">
			  <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
			    567 Votos
			  </div>
			</div>
          </div>
          <div class="col-md-2 align-right">
          	<p><button type="button" class="btn btn-primary btn-lg">Votar</button></p>
          </div>
        </div>
      </div>
      <div class="row candidato">
        <div class="col-md-12">
          <div class="col-md-3">
          	<img src="http://photos-b.ak.instagram.com/hphotos-ak-xfa1/10684325_848115298553377_739887096_n.jpg" alt="Marina Silva" class="img-circle avatar">
          </div>
          <div class="col-md-7">
          	<h1 class="nome">Marina Silva</h1>
          	<h4 class="cargo">Presidente da República</h4>
          	<span class="label label-danger">PSB</span>&nbsp;<span class="label label-default">45</span>
          	<div class="progress votos">
			  <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
			    2423 Votos
			  </div>
			</div>
          </div>
          <div class="col-md-2 align-right">
          	<p><button type="button" class="btn btn-primary btn-lg">Votar</button></p>
          </div>
        </div>
      </div>
  </div>
  
  <jsp:include page="rodape.jsp" />