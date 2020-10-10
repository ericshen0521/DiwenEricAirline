<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.flightsearch.model.UserModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/main.css"/>">
<link
	href="https://fonts.googleapis.com/css?family=Alegreya+Sans:100,100i,300,300i,400,400i,500,500i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<header>

	<%! UserModel currentUser = null; %>
	<% currentUser = (UserModel) session.getAttribute("user"); %>


	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top"
		id="mainNav">
		<div class="container-fluid">
			<!-- <a class="navbar-brand js-scroll-trigger" href="/flightsearch/">
				<h2></h2> 
				

			</a> -->

			<a class="nav-link" style="font-size: 1.75em" href="/flightsearch/">Our
				Airline Company <span class="sr-only">(current)</span>
			</a>


			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<% if(currentUser == null) {%>

						<li class="nav-item"><a class="nav-link"
							style="font-size: 1.75em" href="<c:url value='/loginForm'/>">Login</a></li>
						<li class="nav-item"><a class="nav-link"
							style="font-size: 1.75em"
							href="<c:url value='/registrationForm'/>">Register</a></li>

					<%} else { %>
						<li class="nav-item"><a class="nav-link"
							style="font-size: 1.75em"
							href="<c:url value='/displayLoginDetails'/>">Profile</a></li>
						</li>
						
						<li class="nav-item"><a class="nav-link"
							style="font-size: 1.75em"
							href="<c:url value='/logout'/>">Sign Out</a></li>
						</li>
					<%} %>


					<li class="nav-item"><a class="nav-link"
						style="font-size: 1.75em" href="#">About Us</a></li>
					<li class="nav-item"><a class="nav-link"
						style="font-size: 1.75em" href="#">Contact Us</a></li>
				</ul>
			</div>
		</div>
	</nav>
</header>