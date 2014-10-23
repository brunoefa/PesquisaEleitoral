<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="cabecalho.jsp" />
<jsp:include page="titulo-listagem.jsp" />

<div class="container">
	<jsp:include page="mensagem.jsp" />
	<c:forEach items="${listaCandidatos}" var="candidato">
		<c:if test="${candidato.status || admin}">
			<c:set scope="request" var="candidato" value="${candidato}" />
			<jsp:include page="item-listagem.jsp" />
		</c:if>
	</c:forEach>
</div>
 
<jsp:include page="rodape.jsp" />