<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      <div class="row candidato">
        <div class="col-md-12">
          <div class="col-md-3">
          	<img src="${candidato.foto}" alt="${candidato.nome}" class="img-circle avatar">
          </div>
          <div class="col-md-7">
          	<h1 class="nome">${candidato.nome}</h1>
          	<h4 class="cargo">${candidato.cargo}</h4>
          	<span class="label label-danger">${candidato.partido}</span>&nbsp;
          	<span class="label label-default">${candidato.numero}</span>&nbsp;
          	<a href="#" id="linkDeletar" data-candidato-id="${candidato.id}" data-toggle="modal" data-target="#confirmaExclusao">Deletar</a>&nbsp;
          	
          	<div class="progress votos">
			  <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
			    ${candidato.votos} Votos
			  </div>
			</div>
          </div>
          <div class="col-md-2 align-right padding-top-100">
          	<p><button type="button" class="btn btn-primary btn-lg">Votar</button></p>
          </div>
        </div>
      </div>
