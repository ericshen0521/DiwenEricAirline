<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Management Screen</title>
</head>
<body>
	<div align="center">
		<h2>Order List</h2>
		<h3>
			<a href="addUser">Add Order</a>
		</h3>


		<table class="table table-striped">

			<th scope="col">Order ID</th>
			<th scope="col">First Name</th>
			<th scope="col">Last Name</th>
			<th scope="col">Address 1</th>
			<th scope="col">Address 2</th>
			<th scope="col">Country</th>
			<th scope="col">State</th>
			<th scope="col">Zipcode</th>
			<th scope="col">Card Holder</th>
			<th scope="col">Credit Card Number</th>
			<th scope="col">Expiration Date</th>
			<th scope="col">CVV</th>
			<th scope="col">Order Total</th>
		
			<c:forEach var="order" items="${listOrders}">
				<tr>

					<td>${order.id}</td>
					<td>${order.firstName}</td>
					<td>${order.lastName}</td>
					<td>${order.address1}</td>
					<td>${order.address2}</td>
					<td>${order.country}</td>
					<td>${order.state}</td>
					<td>${order.zipcode}</td>
					<td>${order.nameOnCard}</td>
					<td>${order.creditCardNumber}</td>
					<td>${order.expirationDate}</td>
					<td>${order.cvv}</td>
					<td>${order.orderTotal}</td>
					
					<td><a href="editOrder?id=${order.id}">Edit</a> <a
						href="deleteOrder?id=${order.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		
		<div></div>
		<h3>
			<a href="/flightsearch/admin">Go back</a>
		</h3>
	</div>
</body>
</html>