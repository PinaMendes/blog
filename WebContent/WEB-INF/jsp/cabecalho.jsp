<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	</head>
	<body>
	<h1><a href="<c:url value=""/>">Blog do Gabriel</a></h1>
		<c:if test="${empty usuarioLogado.usuarioLogado}">
		<a href="<c:url value="/login"/>">Efetuar Login</a>
	</c:if>
	<c:if test="${not empty usuarioLogado.usuarioLogado}">
		<a href="<c:url value="/login/sair"/>">Sair</a>
		<br />
		<a href="<c:url value="/postagem"/>">Nova postagem</a>
	</c:if>
	<br />
	Sessão: <%=session.getId() %>
	<hr />
	