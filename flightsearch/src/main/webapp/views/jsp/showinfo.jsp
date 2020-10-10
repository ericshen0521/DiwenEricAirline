<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Info</title>
<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<style>
	table, tr, td {
		border: solid 2px black;
	}
</style>

</head>
<body>
		<c:forEach items = "${tickets}" var = "ticket">
			<table>
			<tr>
				<td>Number Of Available Seats</td>
				<td>Total Price</td>
				<td><form:form action="checkout" method="post" modelAttribute="ticketinfo">
						<input  type = "hidden" name = "availableSeats" value="${ticket.availableSeats}">
						<input  type = "hidden" name = "totalPrice" value="${ticket.totalPrice}">
						<c:forEach varStatus = "vs" items = "${ticket.goList}" var = "flightpath">
							<input  type = "hidden" name = "goList[${vs.index}].departureAirport" value="${flightpath.departureAirport}">
							<input  type = "hidden" name = "goList[${vs.index}].destAirport" value="${flightpath.destAirport}">
							<input  type = "hidden" name = "goList[${vs.index}].departureDate" value="${flightpath.departureDate}">
							<input  type = "hidden" name = "goList[${vs.index}].arrivalDate" value="${flightpath.arrivalDate}">
							<input  type = "hidden" name = "goList[${vs.index}].duration" value="${flightpath.duration}">
							<input  type = "hidden" name = "goList[${vs.index}].carrierCode" value="${flightpath.carrierCode}">
							<input  type = "hidden" name = "goList[${vs.index}].aircraft" value="${flightpath.aircraft}">
							<input  type = "hidden" name = "goList[${vs.index}].departureTerminal" value="${flightpath.departureTerminal}">
							<input  type = "hidden" name = "goList[${vs.index}].arrivalTerminal" value="${flightpath.arrivalTerminal}">
						</c:forEach>
						<c:forEach varStatus = "vs" items = "${ticket.backList}" var = "flightpath">
							<input  type = "hidden" name = "backList[${vs.index}].departureAirport" value="${flightpath.departureAirport}">
							<input  type = "hidden" name = "backList[${vs.index}].destAirport" value="${flightpath.destAirport}">
							<input  type = "hidden" name = "backList[${vs.index}].departureDate" value="${flightpath.departureDate}">
							<input  type = "hidden" name = "backList[${vs.index}].arrivalDate" value="${flightpath.arrivalDate}">
							<input  type = "hidden" name = "backList[${vs.index}].duration" value="${flightpath.duration}">
							<input  type = "hidden" name = "backList[${vs.index}].carrierCode" value="${flightpath.carrierCode}">
							<input  type = "hidden" name = "backList[${vs.index}].aircraft" value="${flightpath.aircraft}">
							<input  type = "hidden" name = "backList[${vs.index}].departureTerminal" value="${flightpath.departureTerminal}">
							<input  type = "hidden" name = "backList[${vs.index}].arrivalTerminal" value="${flightpath.arrivalTerminal}">
						</c:forEach>
						<input type = "submit"  value="select"/>
					</form:form></td>
			</tr>
				<tr>
					<td><c:out value="${ticket.availableSeats}"/></td>
					<td><c:out value="${ticket.totalPrice}"/></td>
					<c:forEach items = "${ticket.goList}" var = "flightpath">
						<tr>
							<td><c:out value="${flightpath.departureAirport}"/></td>
							<td><c:out value="${flightpath.destAirport}"/></td>
							<td><c:out value="${flightpath.departureDate}"/></td>
							<td><c:out value="${flightpath.arrivalDate}"/></td>
							<td><c:out value="${flightpath.duration}"/></td>
							<td><c:out value="${flightpath.carrierCode}"/></td>
							<td><c:out value="${flightpath.aircraft}"/></td>
							<td><c:out value="${flightpath.departureTerminal}"/></td>
							<td><c:out value="${flightpath.arrivalTerminal}"/></td>
						</tr>
					</c:forEach>
					<c:forEach items = "${ticket.backList}" var = "flightpath">
						<tr>
							<td><c:out value="${flightpath.departureAirport}"/></td>
							<td><c:out value="${flightpath.destAirport}"/></td>
							<td><c:out value="${flightpath.departureDate}"/></td>
							<td><c:out value="${flightpath.arrivalDate}"/></td>
							<td><c:out value="${flightpath.duration}"/></td>
							<td><c:out value="${flightpath.carrierCode}"/></td>
							<td><c:out value="${flightpath.aircraft}"/></td>
							<td><c:out value="${flightpath.departureTerminal}"/></td>
							<td><c:out value="${flightpath.arrivalTerminal}"/></td>
						</tr>
					</c:forEach>
				</tr>
				</table>
			</c:forEach>
			<script>
				$("#select-btn").click(function(event){
					var testdata = $("#ticket-click").val();
					console.log(testdata);
					selectTicket(testdata);
				})
				
				function selectTicket(testdata) {
					console.log("json data: " + JSON.stringify(testdata));
					$.ajax({
						type : "POST",
						url : "checkout",
				        contentType : "application/json; charset=utf-8",
				        data :JSON.stringify({
				        	"goList" : testdata.goList,
				        	"backList" : testdata.backList,
				        	"availableSeats" : testdata.availableSeats,
				        	"totalPrice" : testdata.totalPrice
				        }), 
				        dataType: "json",
				        timeout : 100000,
				        success : function(data) {
				            console.log("SUCCESS: ", data);
				        },
				        error : function(e) {
				            console.log("ERROR: ", e);
				        },
				        done : function(e) {
				            console.log("DONE");
				        }
					});
				}
			</script>
</body>
</html>