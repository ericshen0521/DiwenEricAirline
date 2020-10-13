<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User</title>
</head>
<body>
    <div align="center">
        <h1>Edit User</h1>
        <form:form action="saveEditUser" method="post" modelAttribute="updatedUser">
        <table>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName" value="${userToUpdate.firstName}"/></td>
            </tr>
             <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName" value="${userToUpdate.lastName}"/></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" value="${userToUpdate.email}"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="password" value="${userToUpdate.password}"/></td>
            </tr>
        
          
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>