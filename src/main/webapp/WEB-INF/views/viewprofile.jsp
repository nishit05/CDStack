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
			<div class="alert-success">
			<center>
				<strong style="font-size: 25px">${msgu}</strong>
			</center>
		</div>
		<h1 align="center" style="color: navy;">PROFILE</h1>
		<table class="table" style="width: 70%; height: 70%;" align="center">
			<thead style="background-color: orange;">
				<tr>
					<th>FIELD</th>
					<th>VALUE</th>
				</tr>
			</thead>

			<tbody style="background-color: white;" align="center">
				<tr>
					<td>User ID</td>
					<td>${users.u_id}</td>
				</tr>
				
				<tr>
					<td>Name</td>
					<td>${users.name}</td>
				</tr>

				<tr>
					<td>Username</td>
					<td>${users.username}</td>
				</tr>

				<tr>
					<td>Email</td>
					<td>${users.email}</td>
				</tr>


				<tr>
					<td colspan="2"><a role="button" href="edit?id=${users.u_id}" class="btn btn-primary">Edit Profile</a></td>
				</tr>

			</tbody>
		</table>
	</div>
	<%@include file="footer.jsp"  %>
</body>
</html>