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
<script src="resources/js/location.js"></script>
<body>
	<%@include file="../header.jsp"%>
	<div class="container">
		<h1 style="color: navy;" align="center">Billing Details</h1>
		<br> <br>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<%@ taglib prefix="form"
			uri="http://www.springframework.org/tags/form"%>
		<%@  taglib prefix="w" uri="http://java.sun.com/jsp/jstl/core"%>

		<form:form commandName="shippingaddress">


			<form:label path="name" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Name</form:label>
			<form:input path="name" cssClass="form-control"
				pattern="^[A-Za-z\\s]*$" title="Enter Only Letters" required="true" />
			<br>

			<form:label path="address" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Address</form:label>
			<form:textarea path="address" cssClass="form-control" rows="5"
				cols="30" required="true" />
			<br>

			<form:label path="state" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">State</form:label>
			<form:select path="state" cssClass="form-control"
				cssStyle="width:60%" onchange="statesel()" id="state">
				<form:option value="Select Option"></form:option>
				<form:option value="Gujarat"></form:option>
				<form:option value="Kerala"></form:option>
				<form:option value="Maharashtra"></form:option>
				<form:option value="Karnataka"></form:option>
				<form:option value="Rajasthan"></form:option>
			</form:select>
			<br>

			<form:label path="city" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">City</form:label>
			<form:select path="city" cssClass="form-control" cssStyle="width:60%"
				pattern="^[A-Za-z\\s]*$" title="Enter Only Letters" required="true"
				id="city">
			</form:select>
			<br>

			<form:label path="pincode" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Pin Code</form:label>
			<form:input path="pincode" cssClass="form-control" pattern="[0-9]{6}"
				title="Enter 6 digit numeric pincode" required="true" />
			<br>

			<form:label path="mno" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Contact</form:label>
			<form:input path="mno" cssClass="form-control" pattern="^[789]\d{9}"
				title="Enter 10 digit numeric mobile number starting with 7,8 or 9"
				required="true" />
			<br>

			<div class="container text-center">
				<button class="btn btn-primary" type="submit" name="_eventId_submit"
					style="margin-right: 20px; font-size: 25px">Submit</button>

				<button class="btn btn-danger" type="submit" name="_eventId_back"
					style="font-size: 25px">Cancel</button>
			</div>
		</form:form>
	</div>
	<div class="form-group"></div>
	<%@include file="../footer.jsp"%>
</body>
</html>