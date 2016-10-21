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
<%@include file="../header.jsp"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<%@ taglib prefix="form"
			uri="http://www.springframework.org/tags/form"%>
<div class="container">

<form:form modelAttribute="shippingaddress">
<form:label path="name" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Name:</form:label>
<form:label path="name" cssStyle="font-size: 25px">${shippingaddress.name}</form:label>
<br>
<br>

<form:label path="address" cssClass="control-label col-sm-2"
				cssStyle="font-size: 25px">Address:</form:label>
<form:label path="address" cssStyle="font-size: 25px">${shippingaddress.address}</form:label>
<br>
<br>

<form:label path="city" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">City:</form:label>
<form:label path="city" cssStyle="font-size: 25px">${shippingaddress.city}</form:label>
<br>
<br>

<form:label path="state" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">State:</form:label>
<form:label path="state" cssStyle="font-size: 25px">${shippingaddress.state}</form:label>
<br>
<br>

<form:label path="pincode" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Pin Code:</form:label>
<form:label path="pincode" cssStyle="font-size: 25px">${shippingaddress.pincode}</form:label>
<br>
<br>

<form:label path="mno" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Contact:</form:label>
<form:label path="mno" cssStyle="font-size: 25px">${shippingaddress.mno}</form:label>
<br>
<br>

<div class="container text-center">
				<button class="btn btn-primary" type="submit" name="_eventId_submit"
					style="margin-right: 20px; font-size: 25px">Confirm Details</button>

				<button class="btn btn-danger" type="submit" name="_eventId_back" style="font-size: 25px">Edit</button>
			</div>
</form:form>

</div>
<%@include file="../footer.jsp"  %>
</body>
</html>