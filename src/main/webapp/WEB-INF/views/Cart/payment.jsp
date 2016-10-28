<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text] {
	width: 60%;
}

input[type=number] {
	width: 60%;
}

label {
	color: navy;
}
</style>
<body>
	<%@include file="../header.jsp"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="po"%>
	<div class="container">
	<div class="container">
			<div class="alert-danger">
				<center>
					<strong style="font-size: 25px">${msgpe}</strong>
				</center>
			</div>
		</div>
		<h1 style="color: navy;" align="center">Payment Details</h1>
		
		<br> <font size="5" style="font-weight: bold;">
			<center>
				<label style="font-size: 25px;">Amount to be paid is
					${total}</label>
			</center>
		</font> <br>

		<form:form modelAttribute="order">

			<form:label path="paytype" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Card Type</form:label>
			<form:select path="paytype" cssClass="form-control"
				cssStyle="width:60%" name="paytype" required="true">
				<form:option value="Select Card"></form:option>
				<form:option value="Credit Card"></form:option>
				<form:option value="Debit Card"></form:option>
			</form:select>
			<br>

			<font size="5" style="font-weight: bold;"> <label
				style="font-size: 25px" class="control-label col-sm-4">Card
					number</label></font>
			<input type="text" class="form-control" pattern="^[1-9]\d{15}"
				title="Enter 16 digit Card Number" required="true">
			<br>

			<font size="5" style="font-weight: bold;"> <label
				style="font-size: 25px" class="control-label col-sm-4">Name
					On Card</label></font>
			<input type="text" class="form-control" pattern="^[A-Za-z\s]*$"
				title="Enter Only Letters" required="true">
			<br>

			<font size="5" style="font-weight: bold;"> <label
				style="font-size: 25px" class="control-label col-sm-4">Expiry
					Date</label></font>
			<select id="Month"
				style="margin-right: 10px; width: 20%; box-sizing: border-box; padding: 10px 10px;">
				<option>Select a Month</option>
				<%
					int i = 1;
						for (i = 1; i < 13; i++) {
							out.print("<option>");
							out.print(i);
							out.print("</option>");
						}
				%>
			</select>

			<select id="Year"
				style="margin-right: 10px; width: 20%; box-sizing: border-box; padding: 10px 10px;">
				<option>Select a Year</option>
				<%
					int y = 2016;
						for (i = 2016; i < 2052; i++) {
							out.print("<option>");
							out.print(i);
							out.print("</option>");
						}
				%>
			</select>
			<br>
			<br>
			<font size="5" style="font-weight: bold;"> <label
				style="font-size: 25px" class="control-label col-sm-4">CVV</label></font>
			<input type="password" class="form-control" pattern="[0-9]{3}"
				title="Enter Only Digits" required="true" style="width: 10%">
			<br>

			<div class="container text-center">
				<button class="btn btn-primary" type="submit" name="_eventId_submit"
					style="margin-right: 20px; font-size: 25px">Pay</button>

				<button class="btn btn-danger" type="submit" name="_eventId_back"
					style="font-size: 25px">Cancel</button>
				<br> <br>
			</div>
		</form:form>
	</div>

	<%@include file="../footer.jsp"%>
</body>
</html>