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
<link href="<c:url value="/resources/css/flightstyle.css" />"
	rel="stylesheet">
	 <link href="<c:url value="/resources/css/theme-turqoise.css" />"
	rel="stylesheet">
<style>
.pager{
	float:left;
}
</style>

</head>
<body>
	<%
		int pageid = (Integer)request.getAttribute("page");
		int total = 3;
		int pagestart = 0;
		int prevpage = 1;
		if (pageid == 1) {}
		else {
			pagestart = (pageid - 1) * total;
			prevpage = pageid - 1;
		}
		int pageend = pagestart + total - 1;
		int nextpage = pageid + 1;
		pageContext.setAttribute("pagestart", pagestart);
		pageContext.setAttribute("pageend", pageend);
		pageContext.setAttribute("nextpage", nextpage);
		pageContext.setAttribute("prevpage", prevpage);
		
	%>
	
	<jsp:include page="header.jsp" />
	<div class="deals flights row results">
		<c:forEach items = "${tickets}" var = "ticket" begin = "${pagestart}"  end="${pageend}">
					<div class="testclear">
					
					<c:forEach items = "${ticket.goList}" var = "flightpath">
							<article class="one-third">
								<div class="details">
								<h4>${flightpath.departureAirport} - 
									${flightpath.destAirport}</h4>
									<div class="f-wrap">
										<h5>Airline Codes</h5>
										<div class="flight-info">${flightpath.carrierCode} ${flightpath.aircraft}</div>
									</div>
									<div class="f-wrap">
										<h5>Departure Date</h5>
										<div class="flight-info">${flightpath.departureDate}</div>
									</div>
									<div class="f-wrap">
										<h5>Arrival Date</h5>
										<div class="flight-info">${flightpath.arrivalDate}</div>
									</div>
									<div class="f-wrap">
										<h5>Duration</h5>
										<div class="flight-info">${flightpath.duration}</div>
									</div>
									<div class="f-wrap">
										<h5>Departure Terminal</h5>
										<div class="flight-info">terminal: ${flightpath.departureTerminal}</div>
									</div>
									<div class="f-wrap">
										<h5>Arrival Terminal</h5>
										<div class="flight-info">terminal: ${flightpath.arrivalTerminal}</div>
									</div>
								</div>
							</article>
					</c:forEach>
					<c:forEach items = "${ticket.backList}" var = "flightpath">
							<article class="one-third">
								<div class="details">
								<h4>${flightpath.departureAirport} - 
									${flightpath.destAirport}</h4>
									<div class="f-wrap">
										<h5>Airline Codes</h5>
										<div class="flight-info">${flightpath.carrierCode} ${flightpath.aircraft}</div>
									</div>
									<div class="f-wrap">
										<h5>Departure Date</h5>
										<div class="flight-info">${flightpath.departureDate}</div>
									</div>
									<div class="f-wrap">
										<h5>Arrival Date</h5>
										<div class="flight-info">${flightpath.arrivalDate}</div>
									</div>
									<div class="f-wrap">
										<h5>Duration</h5>
										<div class="flight-info">${flightpath.duration}</div>
									</div>
									<div class="f-wrap">
										<h5>Departure Terminal</h5>
										<div class="flight-info">terminal: ${flightpath.departureTerminal}</div>
									</div>
									<div class="f-wrap">
										<h5>Arrival Terminal</h5>
										<div class="flight-info">terminal: ${flightpath.arrivalTerminal}</div>
										
									</div>
								</div>
							</article>
					</c:forEach>
					</div>
					<form:form action="checkout" method="post" modelAttribute="ticketinfo">
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
						<div class = "flight-subbtn">
							<input type = "submit"  value="select"/>
						</div>
				</form:form>
			</c:forEach>
	</div>
		<div class="pager">
			<span><a href="#">First page</a></span>
			<span><a href="/flightsearch/show/${prevpage}">&lt;</a></span>
			<span class="/flightsearch/show/1">1</span>
			<span><a href="/flightsearch/show/2">2</a></span>
			<span><a href="/flightsearch/show/3">3</a></span>
			<span><a href="/flightsearch/show/${nextpage}">&gt;</a></span>
			<span><a href="/flightsearch/show/3">Last page</a></span>
		</div>
	<script>
				$("header").addClass("header");
	</script>
</body>
</html>