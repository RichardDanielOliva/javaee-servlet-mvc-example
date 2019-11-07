<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="./layout/header.jsp" %>
        
 
  <h2>New movie </h2> 
 
<%@ include file="feedbackMessage.jsp" %>

 <form class="form-horizontal" action="CreateMovie" method="post">

  <div class="form-group">
    <label class="control-label col-sm-2" for="name">Titulo:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"
      name="name"
      id="name" placeholder="Introduzca un titulo">
  	</div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="puntuacion">Puntuación:</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" max="10" min="0" step="0.1"
      name="puntuacion"
      id="puntuacion" placeholder="Introduzca nueva puntuación"> 
  	</div>
  	</div>
  	<div class="form-group">
  	 <label class="control-label col-sm-2" for="duracion">Duracion:</label>
    <div class="col-sm-10">
      <input type="number" class="form-control"
      name="duracion"
      id="duracion" placeholder="Introduzca la duración">
 	 </div>
 	 </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">Submit</button>
	    </div>
	  </div>
	</form>
 
        
 <%@ include file="layout/footer.jsp" %>