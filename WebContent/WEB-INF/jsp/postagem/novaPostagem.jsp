
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="java.util.Calendar"%><c:import url="../cabecalho.jsp" />

<h2>Criação de postagem</h2>

<form action="<c:url value="/postagem/postagem"/>" method="post">

Autor: <br />
<input type="text" name="postagem.autor" value="${usuarioLogado}"
	readonly="readonly" size="35" /><br />

Data: <br />
<input type="text" name="postagem.dataDePostagem"
	value="<fmt:formatDate value="${data.time}" pattern="dd/MM/yyyy"/>"
	readonly="readonly" /><br />

Titulo: <br />
<input type="text" name="postagem.titulo" size="40" /><br />

Texto: <br />
<textarea rows="15" cols="50" name="postagem.texto"></textarea> <br />
<input type="submit" /></form>

<c:import url="../rodape.jsp" />