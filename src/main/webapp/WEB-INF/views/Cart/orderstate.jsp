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
		<h1 style="color: navy;" align="center">ORDER Status</h1>
		<br> <br>


		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<%@ taglib prefix="form"
			uri="http://www.springframework.org/tags/form"%>
		<p align="center" style="font-size: 25px; color: maroon;">${msge}</p>

		<form:form action="${pageContext.request.contextPath}/ordertrack"
			method="post" commandName="order">


			<form:label path="id" cssClass="control-label col-sm-4"
				cssStyle="font-size: 25px">Order-Id</form:label>
			<form:input path="id" cssClass="form-control" required="true"/>
			<form:errors path="id" cssStyle="color:black"></form:errors>
			<br>

			<div class="container text-center">
				<button class="btn btn-primary" type="submit"
					style="margin-right: 20px; font-size: 25px">Submit</button>

				<button class="btn btn-danger" type="reset" style="font-size: 25px">Cancel</button>
			</div>
		</form:form>
	</div>
	<div class="form-group"></div>
	<%@include file="../footer.jsp"%>
</body>
</html>