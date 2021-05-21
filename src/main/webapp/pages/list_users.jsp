<table border="1">
	<tr>
		<th>ID</th>
		<th>Nom</th>
		<th>Prénom</th>
	</tr>
	
	<c:forEach var="user" items="${ listeUser }">
	
	<tr>
		<td><c:out value="${user.idUser}"/></td>
		<td><c:out value="${user.nom}"/></td>
		<td><c:out value="${user.prenom}"/></td>
	</tr>
	
	</c:forEach>
</table>