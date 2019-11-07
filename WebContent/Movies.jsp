<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


 <%@ include file="./layout/header.jsp" %>
<h2>Movie list</h2>
<div class="table-responsive">

	<p>La nota media de las peliculas es: <fmt:formatNumber type = "number" 
         maxFractionDigits = "1" value = "${moviesAverage}" /> </p>

	<table class="table table-hover">
		<thead>
			<tr>
				
				<th>Title</th>
				<th>Score</th>
				<th>More...</th>

			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty movies}">
				<c:forEach items="${movies}" var="movie">
					<c:set var = "puntuacionClass" scope = "page" value ="success"/>
					<c:if test="${movie.puntuacion < 5}">
						<c:set var = "puntuacionClass" scope = "page" value ="danger"/>
					</c:if>
	   					<tr class="${puntuacionClass}">
							<td><c:out value = "${movie.name}"/></td>
							<td><c:out value = "${movie.puntuacion}"/></td>
							<td>
								<c:url value="Movies" var="editUrl">
									<c:param name="movieId" value="${movie.id}"></c:param>
								</c:url>
					
					 			<a href="${editUrl}">details</a></td>
							</td>
						</tr>
				</c:forEach>
			</c:if>

		</tbody>
	</table>
</div>



 <%@ include file="layout/footer.jsp" %>