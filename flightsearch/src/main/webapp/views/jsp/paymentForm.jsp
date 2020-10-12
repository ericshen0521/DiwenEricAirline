<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

<title>Checkout example for Bootstrap</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.0/examples/checkout/">

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/dist/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/form-validation.css"/>"
	rel="stylesheet">
</head>

<body class="bg-light">

	<div class="container">
		<div class="py-5 text-center">
			<h2>Checkout</h2>
		</div>

		<div class="row">
			<div class="col-md-4 order-md-2 mb-4">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-muted">Your cart</span> <span
						class="badge badge-secondary badge-pill">3</span>
				</h4>
				<ul class="list-group mb-3">
					<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<h6 class="my-0">Product name</h6>
							<small class="text-muted">Brief description</small>
						</div> <span class="text-muted">$12</span>
					</li>
					<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<h6 class="my-0">Second product</h6>
							<small class="text-muted">Brief description</small>
						</div> <span class="text-muted">$8</span>
					</li>
					<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<h6 class="my-0">Third item</h6>
							<small class="text-muted">Brief description</small>
						</div> <span class="text-muted">$5</span>
					</li>
					<li class="list-group-item d-flex justify-content-between"><span>Total
							(USD)</span> <strong>$20</strong></li>
				</ul>


			</div>
			<div class="col-md-8 order-md-1">
				<h4 class="mb-3">Billing address</h4>
				<form:form class="needs-validation" action="pay" method="post" modelAttribute="paymentFormDetails">
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="firstName">First name</label> <input type="text"
								class="form-control" id="firstName" name="firstName" placeholder="" value=""
								required>
							<div class="invalid-feedback">Valid first name is required.
							</div>
						</div>
						<div class="col-md-6 mb-3">
							<label for="lastName">Last name</label> <input type="text"
								class="form-control" id="lastName" name="lastName" placeholder="" value=""
								required>
							<div class="invalid-feedback">Valid last name is required.
							</div>
						</div>
					</div>

					<div class="mb-3">
						<label for="address">Address</label> <input type="text"
							class="form-control" id="address" name="address1" placeholder="1234 Main St"
							required>
						<div class="invalid-feedback">Please enter your shipping
							address.</div>
					</div>

					<div class="mb-3">
						<label for="address2">Address 2 <span class="text-muted">(Optional)</span></label>
						<input type="text" class="form-control" id="address2" name="address2" 
							placeholder="Apartment or suite">
					</div>

					<div class="row">
						<div class="col-md-5 mb-3">
							<label for="country">Country</label> <select
								class="custom-select d-block w-100" id="country" name="country" required>
								<option value="">Choose...</option>
								<option>United States</option>
							</select>
							<div class="invalid-feedback">Please select a valid
								country.</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="state">State</label> <select
								class="custom-select d-block w-100" id="state" name="state" required>
								<option value="">Choose...</option>
								<option value="AL">Alabama</option>
								<option value="Alabama">Alabama</option>
								<option value="Alaska">Alaska</option>
								<option value="Arizona">Arizona</option>
								<option value="Arkansas">Arkansas</option>
								<option value="California">California</option>
								<option value="Colorado">Colorado</option>
								<option value="Connecticut">Connecticut</option>
								<option value="Delaware">Delaware</option>
								<option value="District of Columbia">District of
									Columbia</option>
								<option value="Florida">Florida</option>
								<option value="Georgia">Georgia</option>
								<option value="Guam">Guam</option>
								<option value="Hawaii">Hawaii</option>
								<option value="Idaho">Idaho</option>
								<option value="Illinois">Illinois</option>
								<option value="Indiana">Indiana</option>
								<option value="Iowa">Iowa</option>
								<option value="Kansas">Kansas</option>
								<option value="Kentucky">Kentucky</option>
								<option value="Louisiana">Louisiana</option>
								<option value="Maine">Maine</option>
								<option value="Maryland">Maryland</option>
								<option value="Massachusetts">Massachusetts</option>
								<option value="Michigan">Michigan</option>
								<option value="Minnesota">Minnesota</option>
								<option value="Mississippi">Mississippi</option>
								<option value="Missouri">Missouri</option>
								<option value="Montana">Montana</option>
								<option value="Nebraska">Nebraska</option>
								<option value="Nevada">Nevada</option>
								<option value="New Hampshire">New Hampshire</option>
								<option value="New Jersey">New Jersey</option>
								<option value="New Mexico">New Mexico</option>
								<option value="New York">New York</option>
								<option value="North Carolina">North Carolina</option>
								<option value="North Dakota">North Dakota</option>
								<option value="Northern Marianas Islands">Northern
									Marianas Islands</option>
								<option value="Ohio">Ohio</option>
								<option value="Oklahoma">Oklahoma</option>
								<option value="Oregon">Oregon</option>
								<option value="Pennsylvania">Pennsylvania</option>
								<option value="Puerto Rico">Puerto Rico</option>
								<option value="Rhode Island">Rhode Island</option>
								<option value="South Carolina">South Carolina</option>
								<option value="South Dakota">South Dakota</option>
								<option value="Tennessee">Tennessee</option>
								<option value="Texas">Texas</option>
								<option value="Utah">Utah</option>
								<option value="Vermont">Vermont</option>
								<option value="Virginia">Virginia</option>
								<option value="Virgin Islands">Virgin Islands</option>
								<option value="Washington">Washington</option>
								<option value="West Virginia">West Virginia</option>
								<option value="Wisconsin">Wisconsin</option>
								<option value="Wyoming">Wyoming</option>
							</select> 
							<div class="invalid-feedback">Please provide a valid state.
							</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="zip">Zip</label> <input type="text"
								class="form-control" id="zip" placeholder="" name="zipcode" required>
							<div class="invalid-feedback">Zip code required.</div>
						</div>
					</div>
					<hr class="mb-4">
					<h4 class="mb-3">Payment</h4>


					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="cc-name">Name on card</label> <input type="text"
								class="form-control" id="cc-name" name="nameOnCard" placeholder="" required>
							<small class="text-muted">Full name as displayed on card</small>
							<div class="invalid-feedback">Name on card is required</div>
						</div>
						<div class="col-md-6 mb-3">
							<label for="cc-number">Credit card number</label> <input
								type="text" class="form-control" id="cc-number" name="creditCardNumber"  placeholder=""
								required>
							<div class="invalid-feedback">Credit card number is
								required</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 mb-3">
							<label for="cc-expiration">Expiration</label> <input type="text"
								class="form-control" id="cc-expiration" name="expirationDate"  placeholder="" required>
							<div class="invalid-feedback">Expiration date required</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="cc-expiration">CVV</label> <input type="text"
								class="form-control" id="cc-cvv" name="cvv" placeholder="" required>
							<div class="invalid-feedback">Security code required</div>
						</div>
					</div>
					<hr class="mb-4">
					<button class="btn btn-primary btn-lg btn-block" type="submit">Continue
						to checkout</button>
				</form:form>
				<div class="mb-4"></div>
				<form:form class="login100-form validate-form" action="cancelPayment" method="get">
					<button class="btn btn-primary btn-lg btn-block" type="submit">Cancel </button>
				</form:form>
				
			</div>
		</div>

		<footer class="my-5 pt-5 text-muted text-center text-small">
			<p class="mb-1">&copy; 2017-2018 Company Name</p>
			<ul class="list-inline">
				<li class="list-inline-item"><a href="#">Privacy</a></li>
				<li class="list-inline-item"><a href="#">Terms</a></li>
				<li class="list-inline-item"><a href="#">Support</a></li>
			</ul>
		</footer>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
	<script src="<c:url value="/resources/js/vendor/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/vendor/holder.min.js"/>"></script>
	<script>
    

      // Example starter JavaScript for disabling form submissions if there are invalid fields
      (function() {
        'use strict';

        window.addEventListener('load', function() {
          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          var forms = document.getElementsByClassName('needs-validation');

          // Loop over them and prevent submission
          var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
              if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
              }
              form.classList.add('was-validated');
            }, false);
          });
        }, false);
      })();
    </script>
</body>
</html>
