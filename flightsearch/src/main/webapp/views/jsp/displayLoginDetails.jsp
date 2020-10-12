<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="com.flightsearch.model.UserModel" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<!DOCTYPE html>
<html>
<head>
	<link href="<c:url value="/resources/css/userprofile.css" />"
	rel="stylesheet">
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
                <c:forEach items = "${user.tickets}" var = "ticket">
                	<div class="form-group">
                  		<label class="form-label"></label>
                  		
                	</div>
                </c:forEach>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
</script>
</body>
</html>