<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       
<!DOCTYPE html>
<html>
<body>

<c:forEach var="cust" items="${customerList}">
	${cust.id}
	${cust.name}
	${cust.age}<br><br>
</c:forEach>

</body>
</html>