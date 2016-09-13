<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<%@include file="header.jsp"  %>
<div class="container-fluid">
		<br>
		<h1 align="center" style="color: navy;">AVAILABLE PRODUCTS</h1>
		<table class="table table-bordered" style="width: 60%; height: 60%;" align="center">
		<thead style="background-color: orange;">
		<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>CATEGORY</th>
		<th>QTY</th>
		<th>PRICE</th>
		<th>PRODUCT MANIPULATION</th>
		</tr>
		</thead>
		
		<tbody style="background-color: white;">
		<c:forEach items="${product}" var="prod">
		<tr>
		<td>${prod.pid}</td>
		<td>${prod.pname}</td>
		<td>${prod.ptype}</td>
		<td>${prod.qty}</td>
		<td>${prod.price}</td>
		<td colspan="2">
		<ul class="nav nav-pills">
		<li><a href='<c:url value="editproduct_id=${prod.pid}"></c:url>'>Edit</a></li>
		<li><a href='<c:url value="deleteproduct_id=${prod.pid}"></c:url>'>Delete</a></li>
		<li><a href='<c:url value="viewproduct_id=${prod.pid}"></c:url>'>View</a></li>
		</ul>
		</td>
		</tr>
		
		</c:forEach>
		</tbody>
		</table>

</div>
<%@include file="footer.jsp"  %>

</body>



</html>