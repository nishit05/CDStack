<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text]{
width:60%;
}

input[type=email]{
width:60%;
}

input[type=password]{
width:60%;
}

input.cpass {
	text-align: left;
}

label {
	color: navy;
}


</style>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<h1 style="color: navy;" align="center">REGISTER</h1>
		<br>
		<br>
		
		<form action="#">
			<div class="form-group">
				<label for="name" style=" font-size: 25px" class="control-label col-sm-4">Name:</label>
				<input type="text" id="name" class="form-control"
					style="color: black;" required> <br> <label
					for="email" style=" font-size: 25px" class="control-label col-sm-4">Email-id:</label>
				<input type="email" id="email" class="form-control"
					style="color: black; font-size: 25px" required \><br> <label
					for="mno" style=" font-size: 25px" class="control-label col-sm-4">Mobile
					No.:</label> <input type="text" id="mno" class="form-control"
					style="color: black; font-size: 25px" required> <br> <label
					for="pas" style="font-size: 25px" class="control-label col-sm-4">Password:</label> <input
					type="password" id="pas" class="form-control"
					style="color: black; font-size: 25px" required> <br>
				<label for="cpass" style="font-size: 25px" class="control-label col-sm-4">Confirm
					Password:</label> <input type="password" id="cpass" class="form-control"
					style="color: black; font-size: 25px" required><br>
					<br>
				<div class="container text-center">
					<button class="btn btn-primary" type="submit"
						style="margin-right: 20px; font-size: 25px">Submit</button>

					<button class="btn btn-danger" type="reset" style="font-size: 25px">Cancel</button>
				</div>
			</div>
		</form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>