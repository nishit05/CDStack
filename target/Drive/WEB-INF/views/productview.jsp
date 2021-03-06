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
		<%@ taglib uri="http://www.springframework.org/security/tags"
		prefix="sec"%>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<%@ taglib prefix="form"
			uri="http://www.springframework.org/tags/form"%>
		<table class="table" style="width: 70%; height: 70%;" align="center">
			<thead style="background-color: orange;">
				<tr>
					<th>FIELD</th>
					<th>VALUE</th>
				</tr>
			</thead>

			<tbody style="background-color: white;" align="center">
			<tr>
			<td colspan="2"><img src="resources/multipart/${prdet.pname}.jpg" alt="Movie" style="width: 250px; height: 250px;" align="middle"></td>
			</tr>
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

				<tr>
					<sec:authorize access="hasRole('ROLE_USER')">
					<td colspan="2">
					<a role="button" class="btn btn-primary" href="addtocart?id=${prdet.pid}&&name=${name}">
					Add To Cart</a></td>
					</sec:authorize>
				</tr>

			</tbody>
		</table>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>