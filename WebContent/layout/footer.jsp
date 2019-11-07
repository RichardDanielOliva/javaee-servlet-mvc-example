

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<footer>

	<p>
		<jsp:useBean id="now" class="java.util.Date" />
		 <label>dd-MM-yyyy: </label>
		<fmt:formatDate value="${now}" pattern="dd-MM-yyyy" />
	</p>
	<c:out value="${header['User-Agent']}"></c:out>
</footer>

</div>

</body>
</html>