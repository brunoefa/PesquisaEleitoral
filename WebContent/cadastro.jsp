<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="cabecalho.jsp" />
<div class="container">

	<form class="form-signin" role="form" action="usuario" method="post">
		<jsp:include page="mensagem.jsp" />
		<h2 class="form-signin-heading">Cadastrar usuário</h2>
		<input type="hidden" name="acao" value="salvar">
		<input type="text" name="nome" class="form-control" id="first" placeholder="Nome" required autofocus>
		<input type="email" name="email" class="form-control in" placeholder="E-mail" required autofocus>
		<input type="password" name="senha" class="form-control in" placeholder="Senha" required>
		<input type="password" name="confirmacao" id="last" class="form-control" placeholder="Confirmação" required>
		<button class="btn btn-lg btn-primary btn-block"  type="submit">Cadastrar</button>
		<br /><a href="usuario?acao=login">Já possui login?</a>
	</form>
</div>
<jsp:include page="rodape.jsp" />