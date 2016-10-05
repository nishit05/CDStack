<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@include file="header.jsp"%>
	<div class="container-fluid">
		<div class="container">
			<div class="alert-success">
				<center>
					<strong style="font-size: 25px">${msgd}</strong>
				</center>
			</div>
		</div>
		<br>
		<div class="container">
			<div class="alert-success">
				<center>
					<strong style="font-size: 25px">${msgu}</strong>
				</center>
			</div>
		</div>
		<br>
		<h1 align="center" style="color: navy;">SUPPLIERS' LIST</h1>
		<table class="table table-bordered" style="width: 80%; height: 80%;"
			align="center">
			<thead style="background-color: orange;">
				<tr>
					<!-- 		<th>ID</th> -->
					<th>NAME</th>
					<th>ADDRESS</th>
					<th>CONTACT</th>
					<th>SUPPLER MANIPULATION</th>
				</tr>
			</thead>

			<tbody style="background-color: white;" align="center">
				<c:forEach items="${supplier}" var="sp">
					<tr>
						<%-- 		<td>${sp.id}</td> --%>
						<td>${sp.sname}</td>
						<td>${sp.haddress}</td>
						<td>${sp.contact}</td>
						<td colspan="2"><a
							href='<c:url value="editsupplier?id=${sp.id}"></c:url>'
							class="btn btn-primary" role="button" style="margin-right: 10px;"
							data-toggle="tooltip" title="Edit"><span
								class="glyphicon glyphicon-pencil"></span></a> 
								
								<a
							href='<c:url value="deletesupplier?id=${sp.id}"></c:url>'
							class="btn btn-danger" role="button" style="margin-right: 10px;"data-toggle="tooltip" title="Delete"><span
							class="glyphicon glyphicon-remove"></span></a>
							
							<a href='<c:url value="viewsupplier?id=${sp.id}"></c:url>'
							class="btn btn-primary" role="button" style="margin-right: 10px;"><span
							class="glyphicon glyphicon-eye-open" data-toggle="tooltip" title="View"></span></a>

						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

	</div>
	<%@include file="footer.jsp"%>

</body>



</html>