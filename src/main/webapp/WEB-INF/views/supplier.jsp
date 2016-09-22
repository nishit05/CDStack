<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<%@include file="header.jsp"  %>
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
		<table class="table table-bordered" style="width: 80%; height: 80%;" align="center">
		<thead style="background-color: orange;">
		<tr>
<!-- 		<th>ID</th> -->
		<th>NAME</th>
		<th>ADDRESS</th>
		<th>CONTACT</th>
		<th>SUPPLER MANIPULATION</th>
		</tr>
		</thead>
		
		<tbody style="background-color: white;">
		<c:forEach items="${supplier}" var="sp">
		<tr>
<%-- 		<td>${sp.id}</td> --%>
		<td>${sp.sname}</td>
		<td>${sp.haddress}</td>
		<td>${sp.contact}</td>
		<td colspan="2">
		<ul class="nav nav-pills">
		<li><a href='<c:url value="editsupplier_id=${sp.id}"></c:url>'>Edit</a></li>
		<li><a href='<c:url value="deletesupplier_id=${sp.id}"></c:url>'>Delete</a></li>
		<li><a href='<c:url value="viewsupplier_id=${sp.id}"></c:url>'>View</a></li>
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