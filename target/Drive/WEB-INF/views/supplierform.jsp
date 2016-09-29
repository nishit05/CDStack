<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text] {
	width: 60%;
}

label {
	color: navy;
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
		<div class="alert-success">
			<center>
				<strong style="font-size: 25px">${msgc}</strong>
			</center>
		</div>
		<h1 style="color: navy;" align="center">ADD SUPPLIER</h1>
		<br> <br>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<%@ taglib prefix="form"
			uri="http://www.springframework.org/tags/form"%>


		<form:form action="${pageContext.request.contextPath}/addsupplier"
			method="post" commandName="supplier">


			<form:label path="sname" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Supplier-Name</form:label>
			<form:input path="sname" cssClass="form-control" />
			<form:errors path="sname" cssStyle="color:black"></form:errors>
			<br>

			<form:label path="haddress" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Address</form:label>
			<form:textarea path="haddress" cssClass="form-control" rows="5"
				cols="30" />
			<form:errors path="haddress" cssStyle="color:black"></form:errors>
			<br>

			<form:label path="contact" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Contact No.</form:label>
			<form:input path="contact" cssClass="form-control" />
			<form:errors path="contact" cssStyle="color:black"></form:errors>
			<br>


			<div class="container text-center">
				<button class="btn btn-primary" type="submit"
					style="margin-right: 20px; font-size: 25px">Submit</button>

				<button class="btn btn-danger" type="reset" style="font-size: 25px">Cancel</button>
			</div>
		</form:form>
	</div>
	<div class="form-group"></div>
	<%@include file="footer.jsp"%>
</body>
</html>