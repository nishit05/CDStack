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
<script src="resources/js/angular.min.js"></script>
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
	<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container" ng-app="App" ng-controller="ProductController">
		<div class="alert-success">
			<center>
				<strong style="font-size: 25px">${msg}</strong>
			</center>
		</div>
		<div class="alert-danger">
			<center>
				<strong style="font-size: 25px">${msge}</strong>
			</center>
		</div>
		<div class="alert-success">
			<center>
				<strong style="font-size: 25px">${msgc}</strong>
			</center>
		</div>
		<h1 style="color: navy;" align="center">ADD PRODUCTS</h1>
		<br> <br>


		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<%@ taglib prefix="form"
			uri="http://www.springframework.org/tags/form"%>


		<form:form action="${pageContext.request.contextPath}/addproducts?${_csrf.parameterName}=${_csrf.token}"
			method="post" commandName="products" enctype="multipart/form-data">


			<form:label path="pname" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Product-Name</form:label>
			<form:input path="pname" cssClass="form-control" />
			<form:errors path="pname"
				cssStyle="font-size:25px; color:maroon;font-weight:bolder"></form:errors>
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
			<form:errors path="qty"
				cssStyle="font-size:25px;color:maroon;font-weight:bolder"></form:errors>
			<br>

			<form:label path="price" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Price</form:label>
			<form:input path="price" cssClass="form-control" />
			<form:errors path="price"
				cssStyle="font-size:25px;color:maroon;font-weight:bolder"></form:errors>
			<br>

			<form:label path="file" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Image</form:label>
			<form:input path="file" type="file" />
			<br>
			
			<form:label path="content" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Description</form:label>
			<form:textarea path="content" cssClass="form-control" rows="5"
				cols="30" />
			<form:errors path="content"
				cssStyle="font-size:25px; color:maroon; font-weight:bolder"></form:errors>
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