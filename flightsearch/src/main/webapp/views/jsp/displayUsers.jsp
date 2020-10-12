<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management Screen</title>
</head>
<body>
    <div align="center">
        <h1>User List</h1>
        <h3>
            <a href="addUser">Add User</a>
        </h3>
        <table border="1">
 
            <th>USER_ID</th>
            <th>FIRST_NAME</th>
            <th>LAST_NAME</th>
            <th>EMAIL</th>
            <th>PASSWORD</th>
            
 
            <c:forEach var="user" items="${listUsers}">
                <tr>
 
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td><a href="editUser?id=${user.id}">Edit</a>
                             <a
                        href="deleteUser?id=${user.id}">Delete</a></td>
 
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>