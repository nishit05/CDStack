<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="resources/js/angular.min.js"></script>
<script type="text/javascript">
var app=angular.model("App",[]);
app.controller('Cartctrl',function($scope){
	$scope.qty="1";
});
</script>
<body>
	<%@include file="../header.jsp"%>
	<div class="container-fluid" ng-app="App"
		ng-controller="Cartctrl">
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k"%>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<%@ taglib prefix="form"
			uri="http://www.springframework.org/tags/form"%>
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
		<h1 align="center" style="color: navy;">CART DETAILS</h1>
		<br>
		<table class="table table-bordered" style="width: 70%; height: 70%;"
			align="center">
			<thead style="background-color: orange;">
				<tr>
					<th>PRODUCT ID</th>
					<th>PRODUCT NAME</th>
					<th>PRICE</th>
					<th>QTY</th>
					<th>CART MANIPULATION</th>
				</tr>
			</thead>

			<tbody style="background-color: white;" align="center">
			<k:forEach items="${clist}" var="cart">
				<tr>
					<td>${cart.pid}</td>
					<td>${cart.pname}</td>
					<td>${cart.price}</td>
						<td>
							<form action="updatecart" method="get">
							
								<input type="hidden" name="id" value="${cart.pid}" /> 
								<input type="hidden" name="name" value="${name}" /> 
								<input type="text" value="${cart.qty}" name="qty" style="width: 20%"/> 
								<input type="submit" value="Update" class="btn btn-primary" style="margin-left: 10px">
							</form>
						</td>
						<td colspan="2"><a class="btn btn-danger" role="button"
 						href="delete?id=${cart.ct_id}&&name=${name}&&pid=${cart.pid}" style="margin-right: 10px" 
 						data-toggle="tooltip" title="Delete"><span class="glyphicon glyphicon-remove">
 						</span></a></td>
								</tr>
								</k:forEach>
								<tr>
								<td colspan="3" style="font-weight: bold;">TOTAL</td>
								<td style="font-weight: bold;">${total}</td>
								</tr>
			</tbody>
		</table>
<!-- < 					<td colspan="2"><a role="button"  -->
<!-- 						href="editproduct?id={{prod.pid}}" class="btn btn-primary" -->
<!-- 						style="margin-right: 10px" data-toggle="tooltip" title="Edit"><span -->
<!-- 							class="glyphicon glyphicon-pencil"></span></a> <a -->
<!-- 						class="btn btn-danger" role="button" -->
<!-- 						href="deleteproduct?id={{prod.pid}}" style="margin-right: 10px" -->
<!-- 						data-toggle="tooltip" title="Delete"><span -->
<!-- 							class="glyphicon glyphicon-remove"></span></a> <a -->
<!-- 						class="btn btn-primary" role="button" -->
<!-- 						href="productview?id={{prod.pid}}" style="margin-right: 10px"><span -->
<!-- 							class="glyphicon glyphicon-eye-open" data-toggle="tooltip" -->
<!-- 							title="View"></span></a></td> -->
							
	</div>						
			

	<%@include file="../footer.jsp"%>

</body>



</html>