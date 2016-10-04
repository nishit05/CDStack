<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text] {
	width: 60%;
}

input[type=email] {
	width: 60%;
}

input[type=password] {
	width: 60%;
}

input.cpass {
	text-align: left;
}

label {
	color: navy;
	font-size: 25px;
}
</style>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<div class="alert-danger">
			<center>
				<strong style="font-size: 25px">${msge}</strong>
			</center>
		</div>
		<h1 style="color: navy;" align="center">EDIT PROFILE</h1>
		<br> <br>


		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<%@ taglib prefix="form"
			uri="http://www.springframework.org/tags/form"%>


		<form:form action="${pageContext.request.contextPath}/update"
			method="post" commandName="users">


			<form:hidden path="u_id" cssClass="form-control" />
			<form:errors path="u_id" cssStyle="color:black"></form:errors>
			<br>

			<form:label path="name" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Name</form:label>
			<form:input path="name" cssClass="form-control" />
			<font size="5" style="font-weight: bold;"><form:errors
					path="name" cssStyle="color:maroon"></form:errors></font>
			<br>

			<form:label path="email" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">E-mail</form:label>
			<form:input path="email" cssClass="form-control" />
			<font size="5" style="font-weight: bold;"><form:errors
					path="email" cssStyle="color:maroon"></form:errors></font>
			<br>

			<form:label path="newsletter" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Newsletter Subscription</form:label>
			<form:checkbox path="newsletter" cssClass="form-control" />
			<br>

			<form:label path="username" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Username</form:label>
			<form:input path="username" cssClass="form-control" />
			<font size="5" style="font-weight: bold;"><form:errors
					path="username" cssStyle="color:maroon"></form:errors></font>
			<br>

			<form:label path="password" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Password</form:label>
			<form:password path="password" cssClass="form-control" />
			<font size="5" style="font-weight: bold;"><form:errors
					path="password" cssStyle="color:maroon"></form:errors></font>
			<br>

			<form:label path="cpass" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Confirm Password</form:label>
			<form:password path="cpass" cssClass="form-control" />
			<font size="5" style="font-weight: bold;"><form:errors
					path="cpass" cssStyle="color:maroon"></form:errors></font>
			<br>

			<div class="container text-center">
				<button class="btn btn-primary" type="submit"
					style="margin-right: 20px; font-size: 25px">Submit</button>

				<button class="btn btn-danger" type="reset" style="font-size: 25px">Cancel</button>
				<br> <br>
			</div>
		</form:form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>