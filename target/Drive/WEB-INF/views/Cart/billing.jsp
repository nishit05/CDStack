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
	<%@include file="../header.jsp"%>
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


		<form:form commandName="order">


			<form:label path="name" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Name</form:label>
			<form:input path="name" cssClass="form-control" />
			<br>

			<form:label path="address" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Address</form:label>
			<form:textarea path="address" cssClass="form-control" rows="5"
				cols="30" />
			<br>

			<form:label path="city" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">City</form:label>
			<form:input path="city" cssClass="form-control" />
			<br>


			<form:label path="state" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">State</form:label>
			<form:input path="state" cssClass="form-control" />
			<br>

			<form:label path="pincode" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Pin Code</form:label>
			<form:input path="pincode" cssClass="form-control" />
			<br>

			<form:label path="price" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Price</form:label>
			<form:input path="price" cssClass="form-control" />
			<br>
			
			<div class="container text-center">
				<button class="btn btn-primary" type="submit" name="_eventId_submit"
					style="margin-right: 20px; font-size: 25px">Submit</button>

				<button class="btn btn-danger" type="reset" style="font-size: 25px">Cancel</button>
			</div>
		</form:form>
	</div>
	<div class="form-group"></div>
	<%@include file="../footer.jsp"%>
</body>
</html>