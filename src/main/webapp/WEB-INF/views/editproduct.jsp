<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text] {
	width: 60%;
}

label {
	color: navy;
}
</style>
<script type="text/javascript" src="resources/js/angular.min.js"></script>
<script type="text/javascript">
	var app = angular.module('App', []);
	app.controller('ProductController', function($scope, $http) {
		$http.get("cdata").then(function(response) {
			$scope.Data = response.data;
		});
	});
</script>
<body>
	<%@include file="header.jsp"%>
	<div class="container" ng-app="App" ng-controller="ProductController">
		<p align="center" style="font-size: 25px; color: maroon;">${msg}</p>
		<h1 style="color: navy;" align="center">EDIT PRODUCTS</h1>
		<br> <br>


		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<%@ taglib prefix="form"
			uri="http://www.springframework.org/tags/form"%>
			<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


		<form:form action="${pageContext.request.contextPath}/updateproduct"
			method="post" commandName="products">

			<form:hidden path="pid" cssClass="form-control" />
			<form:errors path="pid" cssStyle="color:black"></form:errors>
			<br>

			<form:label path="pname" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Product-Name</form:label>
			<form:input path="pname" cssClass="form-control" />
			<form:errors path="pname" cssStyle="color:black"></form:errors>
			<br>

			<form:label path="category" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Category</form:label>
			<form:select path="category" cssClass="form-control"
				cssStyle="width:60%">
				<form:option value="Select Option"></form:option>
				<form:option ng-repeat="cate in Data" value="{{cate.name}}"></form:option>
			</form:select>
			<br>
			
			<form:label path="ptype" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">CD-Type</form:label>
			<form:select path="ptype" cssClass="form-control"
				cssStyle="width:60%">
				<form:option value="Select Option"></form:option>
				<form:option value="DVD"></form:option>
				<form:option value="VCD"></form:option>
				<form:option value="Audio-CD"></form:option>
			</form:select>
			<br>

			<form:label path="qty" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Quantity</form:label>
			<form:input path="qty" cssClass="form-control" />
			<form:errors path="qty" cssStyle="color:black"></form:errors>
			<br>

			<form:label path="price" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Price</form:label>
			<form:input path="price" cssClass="form-control" />
			<form:errors path="price" cssStyle="color:black"></form:errors>
			<br>

			<form:label path="content" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Description</form:label>
			<form:textarea path="content" cssClass="form-control" rows="5"
				cols="30" />
			<form:errors path="content" cssStyle="color:black"></form:errors>
			<br>
			<div class="container text-center">
				<button class="btn btn-primary" type="submit"
					style="margin-right: 20px; font-size: 25px">Submit</button>

				<button class="btn btn-danger" type="reset" style="font-size: 25px">Cancel</button>
			</div>
		</form:form>
	</div>
	<div class="form-group"></div>
	<%@include file="footer.jsp"%>
</body>
</html>