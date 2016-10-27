<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text] {
	width: 60%;
}

input[type=email] {
	width: 60%;
}

textarea {
	width: 50%;
}

label {
	color: navy;
}
</style>
<body>
	<%@include file="header.jsp"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<div class="container">
		<h1 style="color: navy;" align="center">REACH US</h1>
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
		<div class="alert-danger">
			<center>
				<strong style="font-size: 25px">${msge}</strong>
			</center>
		</div>
	</div>
	<div class="container">
		<div class="alert-success">
			<center>
				<strong style="font-size: 25px">${msgs}</strong>
			</center>
		</div>
	</div>
	<sec:authorize access="hasRole('ROLE_USER')">
		<div class="container">
			<br>
			<h1 align="center" style="color: navy;">QUERY?? JUST ASK US...</h1>
			<br>
			<form:form action="addproblem" commandName="query" method="post">

				<form:label path="name" style="font-size: 25px"
					class="control-label col-sm-4">Name:</form:label>
				<form:input path="name" class="form-control" style="font-size: 25px" />
				<font size="5" style="font-weight: bold;"><form:errors
						path="name" cssStyle="color:maroon"></form:errors></font>
				<br>

				<form:label path="email" style="font-size: 25px"
					class="control-label col-sm-4">Email-id:</form:label>
				<form:input path="email" class="form-control"
					style="font-size: 25px" />
				<font size="5" style="font-weight: bold;"><form:errors
						path="email" cssStyle="color:maroon"></form:errors></font>
				<br>

				<form:label path="mno" style="font-size: 25px"
					class="control-label col-sm-4">Mobile Number:</form:label>
				<form:input path="mno" cssClass="form-control" />
				<font size="5" style="font-weight: bold;"><form:errors
						path="mno" cssStyle="color:maroon"></form:errors></font>
				<br>

				<form:label path="query" style="font-size: 25px"
					class="control-label col-sm-2">Query:</form:label>
				<form:textarea path="query" class="form-control" rows="5" />
				<font size="5" style="font-weight: bold;"><form:errors
						path="query" cssStyle="color:maroon"></form:errors></font>
				<br>
				<div class="container text-center">
					<button class="btn btn-primary" type="submit"
						style="margin-right: 20px; font-size: 25px">Submit</button>

					<button class="btn btn-danger" type="reset" style="font-size: 25px">Cancel</button>
				</div>
			</form:form>
		</div>
	</sec:authorize>
	<br>
	<br>
	<%@include file="footer.jsp"%>
</body>
</html>