<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style>
p {
	color: navy;
}
</style>
<body>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<%@include file="header.jsp"  %>
<div class="container-fluid">
		<br>
		<h1 align="center" style="color: navy;">AVAILABLE PRODUCTS</h1>
		<table class="table table-bordered">
		<thead>
		<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>CATEGORY</th>
		<th>QTY</th>
		<th>PRICE</th>
		</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${pr}" var="prod">
		<tr>
		<td>${pr.pid}</td>
		<td>${pr.pname}</td>
		<td>${pr.ptype}</td>
		<td>${pr.qty}</td>
		<td>${pr.price}</td>
		</tr>
		
		</c:forEach>
		
		
		</tbody>
		
		
		
		</table>

</div>
<%@include file="footer.jsp"  %>

</body>



</html>