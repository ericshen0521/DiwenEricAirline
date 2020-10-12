<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
<link href="<c:url value="/resources/css/receipt.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
</head>
<body>
<body>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container bootdey">
<div class="row">
		<div class="col-sm-10 col-sm-offset-1">
			<div class="widget-box">
				<div class="widget-header widget-header-large">
					<h3 class="widget-title grey lighter">
						<i class="ace-icon fa fa-leaf green"></i>
						Airline Company Receipt
					</h3>

					<div class="widget-toolbar no-border invoice-info">
						<span class="invoice-info-label">Invoice:</span>
						<span class="red">#121212</span>

						<br>
						<span class="invoice-info-label">Date:</span>
						<span class="blue">04/04/2014</span>
					</div>

					<div class="widget-toolbar hidden-480">
						<a href="#">
							<i class="ace-icon fa fa-print"></i>
						</a>
					</div>
				</div>

				<div class="widget-body">
					<div class="widget-main padding-24">
						<div class="row">
							<div class="col-sm-6">
								<div class="row">
									<div class="col-xs-11 label label-lg label-info arrowed-in arrowed-right">
										<b>Customer Info</b>
									</div>
								</div>

								<div>
									<ul class="list-unstyled spaced">
										<li>
											<i class="ace-icon fa fa-caret-right blue"></i>First Name
											 ${paymentModel.firstName}
										</li>

										<li>
											<i class="ace-icon fa fa-caret-right blue"></i>Last Name ${paymentModel.lastName}
										</li>

										<li>
											<i class="ace-icon fa fa-caret-right blue"></i>Address 1 ${paymentModel.address1}
										</li>

										<li>
											<i class="ace-icon fa fa-caret-right blue"></i>Address 2 ${paymentModel.address2}
Phone:
					
										</li>

										<li class="divider"></li>

										<li>
											<i class="ace-icon fa fa-caret-right blue"></i>
											Paymant Info
										</li>
									</ul>
								</div>
							</div><!-- /.col -->

							<div class="col-sm-6">
								<div class="row">
									<div class="col-xs-11 label label-lg label-success arrowed-in arrowed-right">
										<b>Customer Info</b>
									</div>
								</div>

								<div>
									<ul class="list-unstyled  spaced">
										<li>
											<i class="ace-icon fa fa-caret-right green"></i>Country ${paymentModel.country}
										</li>

										<li>
											<i class="ace-icon fa fa-caret-right green"></i>State ${paymentModel.state}
										</li>

										<li>
											<i class="ace-icon fa fa-caret-right green"></i>Zip Code ${paymentModel.zipcode}
										</li>
										
										<li>
											<i class="ace-icon fa fa-caret-right green"></i>Name On Card ${paymentModel.nameOnCard}
										</li>
										
										<li>
											<i class="ace-icon fa fa-caret-right green"></i>Credit Card Number ${paymentModel.creditCardNumber}
										</li>
										
										<li>
											<i class="ace-icon fa fa-caret-right green"></i>CVV ${paymentModel.cvv}
										</li>
										<li>
											<i class="ace-icon fa fa-caret-right green"></i>Expiration Date ${paymentModel.expirationDate}
										</li>
										<li>
											<i class="ace-icon fa fa-caret-right green"></i>Status ${paymentModel.status}
										</li>

										<li class="divider"></li>

										<li>
											<i class="ace-icon fa fa-caret-right green"></i>
											Contact Info
										</li>
									</ul>
								</div>
							</div><!-- /.col -->
						</div><!-- /.row -->

						<div class="space"></div>

						

						<div class="hr hr8 hr-double hr-dotted"></div>

						<div class="row">
							<div class="col-sm-5 pull-right">
								<h4 class="pull-right">
									Total amount :
									<span class="red">$ ${paymentModel.orderTotal}</span>
								</h4>
							</div>
							<div class="col-sm-7 pull-left"> Extra Information </div>
						</div>

						<div class="space-6"></div>
						<div class="well">
							Thank you for choosing Our products.
We believe you will be satisfied by our services.
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
</script>
	
</body>
</html>