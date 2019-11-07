<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ include file="./layout/header.jsp" %>

<h2>Movie details</h2>
 <%@ include file="feedbackMessage.jsp" %>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Title</th>

				<th>Duration (min)</th>
				<th>Score</th>
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>

		<tr>
				<td><c:out value = "${movie.id}"/></td>
				<td><c:out value = "${movie.name}"/></td>
				<td><c:out value = "${movie.duracion}"/></td>
				<td><c:out value = "${movie.puntuacion}"/></td>
				<td>
					<c:url value="EditMovie" var="editUrl">
						<c:param name="movieId" value="${movie.id}"></c:param>
					</c:url>
					
					 <a href="${editUrl}">Edit</a></td>
			</tr>

		</tbody>
	</table>

	<a href='<c:out value="Movies"/>'>Back to movies</a>

 <%@ include file="layout/footer.jsp" %>