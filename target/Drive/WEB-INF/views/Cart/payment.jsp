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
<%@include file="../header.jsp"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<%@ taglib prefix="form"
			uri="http://www.springframework.org/tags/form"%>
			
<a href="${flowExecutionUrl}&_eventId_ty" role="button" class="btn btn-primary">Next</a>
<p align="center" style="font-size: 25px;">
<form:form modelAttribute="order">
<form:label path="name">${order.name} please confirm your order</form:label>

</form:form>
<%@include file="../footer.jsp"  %>
</body>
</html>