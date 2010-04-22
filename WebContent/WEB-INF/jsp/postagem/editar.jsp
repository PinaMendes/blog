<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="../cabecalho.jsp" />

<h2>Criação de postagem</h2>

<form action="<c:url value="/postagem/${postagem.id}"/>" method="post">
<input type="hidden" name="_method" value="PUT" />
Autor: <br />
<input type="text" name="postagem.autor" value="${usuarioLogado}"
	readonly="readonly" size="35"/><br />

Data: <br />
<input type="text" name="postagem.dataDePostagem" value="<fmt:formatDate value="${postagem.dataDePostagem.time}" pattern="dd/MM/yyyy"/>" /><br />

Titulo: <br />
<input type="text" name="postagem.titulo" value="${postagem.titulo}" size="40"/><br />

Texto: <br />
<textarea rows="10" cols="50" name="postagem.texto" >${postagem.texto}</textarea> <br />
<input type="hidden" name="postagem.id" value="${postagem.id}" />
<input type="submit" /></form>

<c:import url="../rodape.jsp" />