
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../cabecalho.jsp" />

<form action="<c:url value="/postagem/postagem"/>" method="get">
<table width="700" style="background-color: silver;">
	<tr>
		<td>
		<h3>${postagem.titulo} - ${postagem.autor} - <fmt:formatDate
			value="${postagem.dataDePostagem.time}" pattern="dd/MM/yyyy" /></h3>
		</td>
	</tr>
	<tr>
		<td>
			${postagem.texto}
		</td>
	</tr>
</table>
</form>

<c:if test="${not empty usuarioLogado.usuarioLogado}">
	<form action="<c:url value="/postagem/editar/${postagem.id}"/>" method="GET">					
		<input type="submit" value="Editar" />
	</form>
	<form action="<c:url value="/postagem/${postagem.id}"/>" method="POST">					
		<input type="hidden" name="_method" value="DELETE" />
		<input type="submit" value="Exluir" />
	</form>
</c:if>

<c:import url="../rodape.jsp" />