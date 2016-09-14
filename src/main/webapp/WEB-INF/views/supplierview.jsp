<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
p{
color: navy;
}
</style>
<body>
<%@include file="header.jsp"  %>
<div class="container">
<h1 align="center" >Supplier details</h1>
<br>
<h1 align="center" style="color: maroon;">${spdet.sname}</h1>
<br>
<h3 align="left" style="color:blue;">Supplier-ID: ${spdet.id}</h3>
<br>
<p style="font-size: 25px;" align="justify">Supplier Address: <br>${spdet.haddress}</p>
<br>
<p style="font-size: 25px; color: blue;" align="justify">Supplier Contact: ${spdet.contact}</p>
<br>
</div>
<%@include file="footer.jsp"  %>
</body>
</html>