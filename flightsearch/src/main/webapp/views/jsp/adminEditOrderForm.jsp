<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Order</title>
</head>
<body>
    <div align="center">
        <h1>Edit Order</h1>
        <form:form action="saveEditOrder" method="post" modelAttribute="updatedOrder">
        <table>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName" value="${orderToUpdate.firstName}"/></td>
            </tr>
             <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName" value="${orderToUpdate.lastName}"/></td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td><form:input path="address1" value="${orderToUpdate.address1}"/></td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td><form:input path="address2" value="${orderToUpdate.address2}"/></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><form:input path="country" value="${orderToUpdate.country}"/></td>
            </tr>
             <tr>
                <td>State:</td>
                <td><form:input path="state" value="${orderToUpdate.state}"/></td>
            </tr>
            <tr>
                <td>Zipcode:</td>
                <td><form:input path="zipcode" value="${orderToUpdate.zipcode}"/></td>
            </tr>
            <tr>
                <td>Card Holder:</td>
                <td><form:input path="nameOnCard" value="${orderToUpdate.nameOnCard}"/></td>
            </tr>
            <tr>
                <td>Credit Card Number:</td>
                <td><form:input path="creditCardNumber" value="${orderToUpdate.creditCardNumber}"/></td>
            </tr>
             <tr>
                <td>Expiration Date:</td>
                <td><form:input path="expirationDate" value="${orderToUpdate.expirationDate}"/></td>
            </tr>
            <tr>
                <td>CVV:</td>
                <td><form:input path="cvv" value="${orderToUpdate.cvv}"/></td>
            </tr>
            <tr>
                <td>Order Total:</td>
                <td><form:input path="orderTotal" value="${orderToUpdate.orderTotal}"/></td>
            </tr>
        	
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>