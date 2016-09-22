<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
table {
	table-layout: fixed;
}
</style>
<script src="resources/js/angular.min.js"></script>
<script src="<c:url value='resources/js/AngularJSController.js'/>"></script>
<body>
	<%@include file="header.jsp"%>
	<div class="container" ng-app="App" ng-controller="ProductController">
		<br>
		<h1 align="center" style="color: navy;">PRODUCT DETAILS</h1>
		<table class="table" style="width: 70%; height: 70%;" align="center">
			<thead style="background-color: orange;">
				<tr>
					<th>FIELD</th>
					<th>VALUE</th>
				</tr>
			</thead>

			<tbody style="background-color: white;" align="center">
				<tr>
					<td>Movie ID</td>
					<td>${prdet.pid}</td>
				</tr>

				<tr>
					<td>Movie Name</td>
					<td>${prdet.pname}</td>
				</tr>

				<tr>
					<td align="center">Movie Description</td>
					<td align="justify">${prdet.content}</td>
				</tr>

				<tr>
					<td>Category</td>
					<td>${prdet.category}</td>
				</tr>


				<tr>
					<td>Quantity</td>
					<td>${prdet.qty}</td>
				</tr>

				<tr>
					<td>Price</td>
					<td>${prdet.price}</td>
				</tr>

			</tbody>
		</table>
	</div>
	<%@include file="footer.jsp"  %>
</body>
</html>