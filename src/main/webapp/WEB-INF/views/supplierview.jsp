<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
p{
color: navy;
}

table {
	table-layout: fixed;
}
</style>
<body>
<%@include file="header.jsp"%>
<div class="container">
		<br>
		<h1 align="center" style="color: navy;">SUPPLIER DETAILS</h1>
		<table class="table" style="width: 70%; height: 70%;" align="center">
			<thead style="background-color: orange;">
				<tr>
					<th>FIELD</th>
					<th>VALUE</th>
				</tr>
			</thead>

			<tbody style="background-color: white;" align="center">
				<tr">
					<td>Supplier ID</td>
					<td>${spdet.id}</td>
				</tr>

				<tr>
					<td>Supplier Name</td>
					<td>${spdet.sname}</td>
				</tr>

				<tr>
					<td align="center">Supplier Address</td>
					<td align="justify">${spdet.haddress}</td>
				</tr>

				<tr>
					<td>Contact</td>
					<td>${spdet.contact}</td>
				</tr>


			</tbody>
		</table>
	</div>
<%@include file="footer.jsp"  %>
</body>
</html>