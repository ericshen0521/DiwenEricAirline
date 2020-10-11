<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body>
	<h1> Thank you for the order, your ticket ID is ${paymentModel.ticket.id}</h1>
	
	
	<h2>first name : ${paymentModel.firstName}</h2>
	<h2>last name : ${paymentModel.lastName}</h2>
	<h2>address1 : ${paymentModel.address1}</h2>
	<h2>address2 : ${paymentModel.address2}</h2>
	<h2>country : ${paymentModel.country}</h2>
	<h2>state : ${paymentModel.state}</h2>
	<h2>zipcode : ${paymentModel.zipcode}</h2>
	<h2>nameOnCard : ${paymentModel.nameOnCard}</h2>
	<h2>creditCardNumber : ${paymentModel.creditCardNumber}</h2>
	<h2>expirationDate : ${paymentModel.expirationDate}</h2>
	<h2>cvv : ${paymentModel.cvv}</h2>
<%-- 	<h2>date : ${paymentModel.date}</h2> --%>
	<h2>price : ${paymentModel.orderTotal}</h2>
	<h2>status : ${paymentModel.status}</h2>
	
</body>
</html>