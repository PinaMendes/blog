<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../cabecalho.jsp" />

<form action="<c:url value="/login"/>" method="post">Login: <input
	type="text" name="usuario.login" value="${usuario.login}"/><br />
Senha: <input type="password" name="usuario.senha" /> <input
	type="submit" value="Autenticar" /></form>

<br />
<c:forEach var="error" items="${errors}">
	
	<table>
		<tbody>
			<tr>
				<td><font color="red">${error.message}</font></td>
			</tr>
		</tbody>
	</table>
	
</c:forEach>
<c:import url="../rodape.jsp" />