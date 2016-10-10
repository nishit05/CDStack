<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text] {
	width: 60%;
}

input[type=password] {
	width: 60%;
}

.left {
	text-align: left;
}

label {
	color: navy;
}
</style>
<body>
	<%@include file="header.jsp"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="y"%>
	<div class="container">
		<y:if test="${error=='true'}">
			<div class="alert-danger">
				<center>
					<strong style="font-size: 25px">Invalid Login....Try Again</strong>
				</center>
			</div>
		</y:if>

		<y:if test="${not empty logoutmsg}">
			<div class="alert-success">
				<center>
					<strong style="font-size: 25px"><y:out
							value="${logoutmsg }"></y:out></strong>
				</center>
			</div>
		</y:if>

	<y:if test="${not empty accessdenied}">
			<div class="alert-success">
				<center>
					<strong style="font-size: 25px"><y:out
							value="${Access Denied}"></y:out></strong>
				</center>
			</div>
		</y:if>

		<h1 style="color: navy;" align="center">LOGIN</h1>
		<br>
		<form action='<y:url value='j_spring_security_check'></y:url>'
			method="post">
			<div class="form-group">
				<label for="email" style="font-size: 25px"
					class="control-label col-sm-4">Username:</label> <input type="text"
					id="email" class="form-control" name="j_username"
					style="color: black; font-size: 25px" required><br> <label
					for="pas" style="font-size: 25px" class="control-label col-sm-4">Password:</label>
				<input type="password" id="pas" class="form-control"
					name="j_password" style="color: black; font-size: 25px" required>
				<br> 
				
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="container text-center">


					<button class="btn btn-primary" type="submit"
						style="margin-right: 20px; font-size: 25px">Submit</button>

					<button class="btn btn-danger" type="reset"
						style="margin-right: 20px; font-size: 25px">Cancel</button>
					<br> <br>


				</div>
			</div>
		</form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>