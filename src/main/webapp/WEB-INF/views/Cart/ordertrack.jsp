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
		<font size="6" style="font-weight: bold;">
			<center>
				<label>${msg}</label>
				<br>
			</center>
		</font>
		<div class="container text-center">
				<a class="btn btn-primary" role="button" href="/CDStack"
					style="margin-right: 20px; font-size: 25px">Back to Home</a>
					</div>
					<br>
	<%@include file="../footer.jsp"%>
</body>
</html>