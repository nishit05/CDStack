<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text]{
width:60%;
}

input[type=email]{
width:60%;
}

input[type=password]{
width:60%;
}

input.cpass {
	text-align: left;
}

label {
	color: navy;
}


</style>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<p align="center" style="font-size: 25px; color: maroon;">${msg}</p>
		<h1 style="color: navy;" align="center">REGISTER</h1>
		<br> <br>


		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<%@ taglib prefix="form"
			uri="http://www.springframework.org/tags/form"%>


		<form:form action="${pageContext.request.contextPath}/registerprocess"
			method="post" commandName="users">


			<form:label path="name" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Name</form:label>
			<form:input path="name" cssClass="form-control" />
			<form:errors path="name" cssStyle="color:black"></form:errors>
			<br>

			<form:label path="email" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">E-mail</form:label>
			<form:input path="email" cssClass="form-control" />
			<br>

			<form:label path="mno" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Mobile No.</form:label>
			<form:input path="mno" cssClass="form-control" />
			<form:errors path="mno" cssStyle="color:black"></form:errors>
			<br>

			<form:label path="pass" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Password</form:label>
			<form:password path="pass" cssClass="form-control" />
			<form:errors path="pass" cssStyle="color:black"></form:errors>
			<br>
			
			<form:label path="cpass" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Confirm Password</form:label>
			<form:password path="cpass" cssClass="form-control" />
			<form:errors path="cpass" cssStyle="color:black"></form:errors>
			<br>

			<div class="container text-center">
				<button class="btn btn-primary" type="submit"
					style="margin-right: 20px; font-size: 25px">Submit</button>

				<button class="btn btn-danger" type="reset" style="font-size: 25px">Cancel</button>
				<br><br>
			</div>
		</form:form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>