<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%@include file="../header.jsp"%>
	<div class="panel panel-primary">
		<div class="panel-heading" align="center">PAYMENT</div>
		<div class="panel-body">
		<div class="container-center">
			<div class="form-group">
				<label for="email" style="font-size: 25px"
					class="control-label col-sm-2">Email-id:</label> <input
					type="email" id="email" class="form-control"
					style="color: black; font-size: 25px; width: 50%" required><br> <label
					for="pas" style="font-size: 25px" class="control-label col-sm-2">Password:</label>
				<input type="password" id="pas" class="form-control"
					style="color: black; font-size: 25px; width: 50%" required> <br>
					<input type="submit" name="_eventId_submit" value="Proced">
			</div>
			</div>
		</div>
		</div>
		<%@include file="../footer.jsp"%>
</body>
</html>