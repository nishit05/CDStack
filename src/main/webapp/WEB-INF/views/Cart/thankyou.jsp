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
	<form:form modelAttribute="order">
		<font size="6" style="font-weight: bold;">
			<center>
				<form:label path="paytype" csStyle="font-size: 25px;">Payment successful by ${order.paytype}. Your Order id is ${order.id}...Thank you for shopping with us!!!!</form:label>
				<br>
			</center>
		</font>
		<div class="container text-center">
				<button class="btn btn-primary" type="submit" name="_eventId_back"
					style="margin-right: 20px; font-size: 25px">Back to Home</button>
					</div>
					<br>
	</form:form>
	<%@include file="../footer.jsp"%>
</body>
</html>