<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="com.flightsearch.model.UserModel" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      
<!DOCTYPE html>
<html>
<head>
<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<style>
.displayhead{
	height: 150px;
	clear:both;
}
</style>
</head>
<body>


${user.email}
${user.password}
<%! UserModel currentUser = null; %>


<% currentUser = (UserModel) session.getAttribute("user");
	System.out.println(currentUser);
	System.out.print(currentUser.getTickets().get(0).getTotalPrice());
%>



<body>
	<div class = "displayhead">
		<jsp:include page="header.jsp" />
	</div>
<div class="container light-style flex-grow-1 container-p-y">
	

    <div class="card overflow-hidden">
      <div class="row no-gutters row-bordered row-border-light">
        <div class="col-md-9">
          <div class="tab-content">
            <div class="tab-pane fade active show" id="account-general">
              <hr class="border-light m-0">

              <div class="card-body">
                <div class="form-group">
                  <label class="form-label">${user.email}</label>
                  <input type="text" class="form-control mb-1" value="nmaxwell">
                </div>
                <!--  <div class="form-group">
                  <label class="form-label">Name</label>
                  <input type="text" class="form-control" value="Nelle Maxwell">
                </div>
                <div class="form-group">
                  <label class="form-label">E-mail</label>
                  <input type="text" class="form-control mb-1" value="nmaxwell@mail.com">
                </div>
                <div class="form-group">
                  <label class="form-label">Company</label>
                  <input type="text" class="form-control" value="Company Ltd.">
                </div>-->
              </div>
              
              <c:forEach items = "${user.tickets}" var = "ticket">
  
					
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
					<div><h3>Total Price: ${ticket.totalPrice}</h3></div>
					<div><h3>Ticket Id: ${ticket.id}</h3></div>
					<form:form action = "deleteticket/${ticket.id}" method = "post">
						<div>
							<input type="submit" id = "deletebutton" value="delete">
						</div>
					</form:form>
					</div>
                </c:forEach>

            </div>
          </div>
        </div>
      </div>
    </div>


	

</body>
</html>