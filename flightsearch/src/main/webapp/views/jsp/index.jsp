<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>Booking Form HTML Template</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=PT+Sans:400" rel="stylesheet">
	
	<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>
	<!-- Bootstrap -->
	 
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
	<!-- Custom stlylesheet -->
	 <link href="<c:url value="/resources/css/style.css" />"
	rel="stylesheet">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>
	<jsp:include page="header.jsp" />

	<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="booking-form">
						<form:form action="show" method="post">
							<div class="form-group">
								<div class="form-checkbox">
									<label for="roundtrip">
										<input type="radio" id="roundtrip" name="flight-type"/>
										<span></span>Roundtrip
									</label>
									<label for="one-way">
										<input type="radio" id="one-way" name="flight-type">
										<span></span>One way
									</label>
									<label for="multi-city">
										<input type="radio" id="multi-city" name="flight-type"/>
										<span></span>Multi-City
									</label>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">Flying from</span>
										<input id = "from-input-search" class="form-control" type="text" placeholder="City or airport">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">Flying to</span>
										<input id = "from-input-search-dest" class="form-control" type="text" placeholder="City or airport">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<span class="form-label">Departing</span>
										<input class="form-control" type="date" required>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<span class="form-label">Returning</span>
										<input class="form-control" type="date" required>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<span class="form-label">Adults (18+)</span>
										<select class="form-control">
											<option>1</option>
											<option>2</option>
											<option>3</option>
										</select>
										<span class="select-arrow"></span>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<span class="form-label">Children (0-17)</span>
										<select class="form-control">
											<option>0</option>
											<option>1</option>
											<option>2</option>
										</select>
										<span class="select-arrow"></span>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<span class="form-label">Travel class</span>
										<select class="form-control">
											<option>Economy class</option>
											<option>Business class</option>
											<option>First class</option>
										</select>
										<span class="select-arrow"></span>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-btn">
										<button class="submit-btn">Show flights</button>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	$(document).ready(function() {

		$('#from-input-search').autocomplete({
			serviceUrl: 'getTags',
			paramName: "cityName",
			delimiter: ",",
		   transformResult: function(response) {
			console.log("ffff");
			console.log(response);
			return {
			  
			  suggestions: $.map($.parseJSON(response), function(item) {
				  console.log(item);
			      return { value: item.cityName};
			   })

			 };

	            },
	            select: function (event, ui) {
	    	       $('#from-input-search').val(ui.item.cityName);
	    	    }

		 });
		
		$('#from-input-search-dest').autocomplete({
			serviceUrl: 'getTags',
			paramName: "cityName",
			delimiter: ",",
		   transformResult: function(response) {
			console.log("ffff");
			console.log(response);
			return {
			  
			  suggestions: $.map($.parseJSON(response), function(item) {
				  console.log(item);
			      return { value: item.cityName};
			   })

			 };

	            },
	            select: function (event, ui) {
	    	       $('#from-input-search').val(ui.item.cityName);
	    	    }

		 });

	  });
	
	
	
	</script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
