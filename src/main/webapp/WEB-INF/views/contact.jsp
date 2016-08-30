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

textarea
{
width:60%;
}

label {
	color: navy;
}

</style>
<body>
	<%@include file="header.jsp"%>

	<div class="container">
		<h1 style="color: navy; " align="center">REACH US</h1>
		<br>
		<div class="row">

			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading" align="center">CONTACT US-1</div>
					<div class="panel-body">
						<h3 align="center">
							<b>Mumbai Office</b>
						</h3>
						<p align="center" style="font-size: 25">
							A-906,Crystal Delight<br>Opp. TBZ Jewellers<br>
							Dadar(West),Mumbai 400012
						</p>
					</div>
					<div class="panel-footer">
						<span class="glyphicon glyphicon-phone">(022)-26401026/27/28
							+91-9833846891, +91-8876100332 </span>
					</div>
				</div>

			</div>

			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading" align="center">CONTACT US-2</div>
					<div class="panel-body">
						<h3 align="center">
							<b>Bengaluru Office</b>
						</h3>
						<p align="center" style="font-size: 25">
							A-301,Top-Star Palace<br>Opp. Reliance Fresh<br>
							Banerghatta Main Road,Bengaluru 560403
						</p>
					</div>
					<div class="panel-footer">
						<span class="glyphicon glyphicon-phone">(080)-42449001/02/03
							+91-9820607553, +91-7790203219 </span>
					</div>
				</div>

			</div>
		</div>
	</div>

	<div class="container">
		<br>
		<h1 align="center" style="color: navy;">QUERY?? JUST ASK US...</h1>
		<br>
		<form action="#">
			<div class="form-group">
				<label for="name" style="font-size: 25px" class="control-label col-sm-4">Name:</label> <input
					type="text" id="name" class="form-control" style="font-size: 25px"
					required> <br> <label for="email"
					style="font-size: 25px" class="control-label col-sm-4">Email-id:</label> <input type="email"
					id="email" class="form-control" style="font-size: 25px" required><br>
				<label for="mno" style="font-size: 25px" class="control-label col-sm-4">Mobile Number:</label> <input
					type="text" id="mno" class="form-control" style="font-size: 25px"
					required> <br> <label for="q" style="font-size: 25px" class="control-label col-sm-2">Query:</label>
				<textarea class="form-control" rows="5"></textarea>
				<br>
				<div class="container text-center">
					<button class="btn btn-primary" type="submit"
						style="margin-right: 20px; font-size: 25px">Submit</button>

					<button class="btn btn-danger" type="reset" style="font-size: 25px">Cancel</button>
				</div>
			</div>
		</form>
	</div>
	<br>
	<br>
	<%@include file="footer.jsp"%>
</body>
</html>