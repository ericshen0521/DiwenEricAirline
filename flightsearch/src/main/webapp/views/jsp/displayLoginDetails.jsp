<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="com.flightsearch.model.UserModel" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       
<!DOCTYPE html>
<html>
<body>


${user.email}
${user.password}
<%! UserModel currentUser = null; %>


<% currentUser = (UserModel) session.getAttribute("user");
	System.out.println(currentUser);
	System.out.print(currentUser.getTickets().get(0).getTotalPrice());
%>



</body>
</html>