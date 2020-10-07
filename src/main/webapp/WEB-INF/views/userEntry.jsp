<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="save" method="post" modelAttribute="customerAttribute">
	<div>
		<input type="hidden" name="id" value="1"/>
	<p>
		<label for="name">Enter Name</label>
		<input type="text" name="name"/>
	</p>
	<p>
		<label for="age">Enter Age</label>
		<input type="text" name="age"/>
	</p>
		<input type="submit" value="add customer"/>
	</div>
</f:form>
</body>
</html>