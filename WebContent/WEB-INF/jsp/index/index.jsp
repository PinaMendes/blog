<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../cabecalho.jsp" />

<c:forEach var="postagem" items="${postagemList}">
	<table width="600" style="background-color: silver;">
		<tr>
			<td>
			<h3><a href="<c:url value="/postagem/${postagem.id}" />">${postagem.titulo}
			- ${postagem.autor} - <fmt:formatDate
				value="${postagem.dataDePostagem.time}" pattern="dd/MM/yyyy" /></a></h3>
			</td>
		</tr>
		<tr>
			<td>${postagem.texto}</td>
		</tr>
	</table>
	<br />
	<br />
</c:forEach>

<c:import url="../rodape.jsp" />