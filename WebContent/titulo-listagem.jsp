<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Olá, eleitor!</h1>
        <p>Este projeto tem o intuito de monitorar em tempo real a intenção de voto do eleitorado brasileiro com relação as eleições 2014. Participe e contribua para uma pesquisa sem manipulação de dados!</p>
        <p>
        	<c:if test="${not logado}">
        	<a class="btn btn-primary btn-lg" role="button" href="usuario?acao=cadastrar">
        		<span class="glyphicon glyphicon-user"></span>&nbsp;Não possui login? Cadastre-se!
        	</a>
        	</c:if>
        	<c:if test="${admin}">
        	<a class="btn btn-success btn-lg" role="button" href="candidato?acao=cadastrar">
        		<span class="glyphicon glyphicon-flag"></span>&nbsp;Cadastre um novo candidato
        	</a>
        	</c:if>
        </p>
      </div>
    </div>