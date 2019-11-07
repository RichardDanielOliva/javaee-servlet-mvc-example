<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        
 <%@ include file="./layout/header.jsp" %>
   <%@ include file="feedbackMessage.jsp" %>
        
        <h2>Edit movie details</h2>
        <table class="table table-hover">
    <thead>
      <tr>
      <th>Id</th>
        <th>Title</th>
        <th>Score</th>
         <th>Duration (min)</th>
        
      </tr>
    </thead>
    <tbody>
    <!-- TODO: fill values in table -->
      <tr>
        <td><c:out value = "${movie.id}"/></td>
		<td><c:out value = "${movie.name}"/></td>
		<td><c:out value = "${movie.puntuacion}"/></td>
		<td><c:out value = "${movie.duracion}"/></td>
      </tr>
     
    </tbody>
  </table>
 
 
<%@ include file="feedbackMessage.jsp" %>

 <form class="form-horizontal" action="EditMovie" method="post">

  <div class="form-group">
    <label class="control-label col-sm-2" for="puntuacion">Puntuación:</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" max="10" min="0" step="0.1"
      name="puntuacion"
      id="puntuacion" placeholder="Introduzca nueva puntuación">
      
<!-- TODO: FILL VALUE -->  
     <input type="hidden" class="form-control" 
      name="movieId"
      value="${movie.id}" >
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</form>
 
 
  
        
 <%@ include file="layout/footer.jsp" %>