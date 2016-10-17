<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="resources/js/angular.min.js"></script>
<script src="<c:url value='resources/js/AngularJSController.js'/>"></script>
<body>
	<%@include file="header.jsp"%>
	<div class="container-fluid" ng-app="App"
		ng-controller="ProductController">
		<div class="container">
			<div class="alert-success">
				<center>
					<strong style="font-size: 25px">${msgd}</strong>
				</center>
			</div>
		</div>
		<div class="container">
			<div class="alert-success">
				<center>
					<strong style="font-size: 25px">${msgu}</strong>
				</center>
			</div>
		</div>
		<h1 align="center" style="color: navy;">RESULTS</h1>
		<br>
		<table class="table table-bordered" style="width: 70%; height: 70%;"
			align="center">
			<thead style="background-color: orange;">
				<tr>
					<th>NAME</th>
					<th>CATEGORY</th>
					<th>CD-TYPE</th>
					<th>QTY</th>
					<th>PRICE</th>
				</tr>
			</thead>

			<tbody style="background-color: white;" align="center">
				<tr ng-repeat="prod in Data|filter:'2'">
					
					<td>{{prod.pname}}</td>
					<td>{{prod.category}}</td>
					<td>{{prod.ptype}}</td>
					<td>{{prod.qty}}</td>
					<td>{{prod.price}}</td>
				</tr>
			</tbody>
		</table>

	</div>
	<%@include file="footer.jsp"%>

</body>



</html>