<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management Screen</title>
</head>
<body>
	<div align="center">
		<h2>User List</h2>
		<h3>
			<a href="addUser">Add User</a>
		</h3>


		<table class="table table-striped">

			<th scope="col">User ID</th>
			<th scope="col">First Name</th>
			<th scope="col">Last Name</th>
			<th scope="col">Email</th>
			<th scope="col">Password</th>
			<th scope="col">Action</th>



			<c:forEach var="user" items="${listUsers}">
				<tr>

					<td>${user.id}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
					<td><a href="editUser?id=${user.id}">Edit</a> <a
						href="deleteUser?id=${user.id}">Delete</a></td>

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