<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=email] {
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
	<div class="container">
		<h1 style="color: navy;" align="center">LOGIN</h1>
		<br>
		<form action="#">
			<div class="form-group">
				<label for="email" style="font-size: 25px"
					class="control-label col-sm-4">Email-id:</label> <input
					type="email" id="email" class="form-control"
					style="color: black; font-size: 25px" required><br> <label
					for="pas" style="font-size: 25px" class="control-label col-sm-4">Password:</label>
				<input type="password" id="pas" class="form-control"
					style="color: black; font-size: 25px" required> <br>

				<div class="container text-center">


					<button class="btn btn-primary" type="submit"
						style="margin-right: 20px; font-size: 25px">Submit</button>

					<button class="btn btn-danger" type="reset"
						style="margin-right: 20px; font-size: 25px">Cancel</button>
					<br>
					<br>


				</div>
			</div>
		</form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>