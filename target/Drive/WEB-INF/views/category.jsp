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
		<div class="container">
		<div class="alert-success">
			<center>
				<strong style="font-size: 25px">${msgu}</strong>
			</center>
			</div>
			</div>
		<br>
		<h1 align="center" style="color: navy;">AVAILABLE CATEGORIES</h1>
		<table class="table table-bordered" style="width: 30%; height: 50%;" align="center">
		<thead style="background-color: orange;">
		<tr>
<!-- 		<th>ID</th> -->
		<th>NAME</th>
		<th>CATEGORY MANIPULATION</th>
		</tr>
		</thead>
		
		<tbody style="background-color: white;" align="center"> 
		<c:forEach items="${category}" var="cate">
		<tr>
<%-- 		<td>${cate.id}</td> --%>
		<td>${cate.name}</td>
		<td colspan="2">
		<a href='<c:url value="editcategory?id=${cate.c_id}"></c:url>' role="button" class="btn btn-primary" style="margin-right: 10px;">Edit</a>
		<a href='<c:url value="deletecategory?id=${cate.c_id}"></c:url>' role="button" class="btn btn-danger" style="margin-right: 10px;">Delete</a>
		</td>
		</tr>
		
		</c:forEach>
		</tbody>
		</table>

</div>
<%@include file="footer.jsp"  %>

</body>



</html>