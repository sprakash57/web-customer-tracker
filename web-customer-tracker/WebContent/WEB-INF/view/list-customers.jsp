<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	
	<input type="button" value="Add Customer"
			onClick="window.location.href='showFormForAdd'; return false;"
			class="add-button"/>
			
	<form:form action="search" method="POST">
	
		Search Customer:<input type="text" name="searchBar"/> <input type="submit" value="Search" class="add-button" />
	
	</form:form>
	
	<div id="container">	
		<div id="content">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>			
<!-- -----------------	Loop over and print all customers 	------------------	-->
				<c:forEach var="tempCustomer" items = "${customers}">
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onClick="if((!confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
						
						<td></td>
					</tr>
				</c:forEach>	
<!-- -----------------	Thats why we use JSTL tags 	-------------------------- -->					
			</table>
		</div>
	</div>

</body>

</html>