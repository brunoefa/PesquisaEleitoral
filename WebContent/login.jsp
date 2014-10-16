<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="cabecalho.jsp" />
<div class="container">
	<form class="form-signin" role="form">
		<jsp:include page="mensagem.jsp" />
		<h2 class="form-signin-heading">Efetuar login</h2>
		<input type="email" name="email" class="form-control" placeholder="Email address" required autofocus>
		<input type="password" name="senha" class="form-control" placeholder="Senha" required>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
	</form>
</div>
<jsp:include page="rodape.jsp" />