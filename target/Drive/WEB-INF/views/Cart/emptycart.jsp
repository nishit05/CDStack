<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style>
label {
	color: navy;
}
</style>
<body>
	<%@include file="../header.jsp"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<form:form>
		<div class="container">
			<div class="alert-success">
				<center>
					<strong style="font-size: 25px">${msgd}</strong>
				</center>
			</div>
		</div>
		<font size="6" style="font-weight: bold;">
			<center>
				<label csStyle="font-size: 25px;">${msgc}</label>
				<br>
			</center>
		</font>
		<div class="container text-center">
				<a class="btn btn-primary" role="button" href="products"
					style="margin-right: 20px; font-size: 25px">Back</a>
					</div>
					<br>
	</form:form>
	<%@include file="../footer.jsp"%>
</body>
</html>