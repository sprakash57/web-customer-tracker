<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>

<html>

<head>

	<title>Customers list</title>
	<link type="text/css"
	      rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />		
	
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Management</h2>
		</div>
	</div>
	<div id="container">	
		<div id="content">
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
<!-- -----------------	Loop over and print all customers 	------------------	-->

				<c:forEach var="tempCustomer" items = "${customers}">
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
					</tr>
				</c:forEach>
				
<!-- -----------------	Thats why we use JSTL tags 	-------------------------- -->				
				
			</table>
		
		</div>
	</div>

</body>

</html>