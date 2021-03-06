<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="resources/js/angular.min.js"></script>
<script src="<c:url value='resources/js/AngularJSController.js'/>"></script>
<body>
	<%@include file="header.jsp"%>
	<div class="container-fluid"">
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
		<h1 align="center" style="color: navy;">QUERIES</h1>
		<br>
		<table class="table table-bordered" style="width: 70%; height: 70%;"
			align="center">
			<thead style="background-color: orange;">
				<tr>
					<th>NAME</th>
					<th>EMAIL</th>
					<th>MOBILE NO.</th>
					<th>QUERY</th>
					<th>QUERY OPERATIONS</th>
				</tr>
			</thead>

			<tbody style="background-color: white;" align="center">
				<k:forEach items="${qlist}" var="query">
					<tr>
						<td>${query.name}</td>
						<td>${query.email}</td>
						<td>${query.mno}</td>
						<td>${query.query}</td>
						<td colspan="2"><a class="btn btn-danger" role="button"
							href="deleteproblem?id=${query.q_id}"
							style="margin-right: 10px" data-toggle="tooltip" title="Delete"><span
								class="glyphicon glyphicon-remove"> </span></a></td>
					</tr>
				</k:forEach>
			</tbody>
		</table>
	</div>
	<%@include file="footer.jsp"%>

</body>



</html>