<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>CD-STACK</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style>
/* Remove the navbar's default rounded borders and increase the bottom margin */
.navbar {
	margin-bottom: 10px;
	border-radius: 0;
}

/* Remove the jumbotron's default bottom margin */
.jumbotron {
	background-color: aqua;
	margin-bottom: 0;
	margin-top: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}

.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}

h5 {
	padding-top: 0px;
}
</style>
</head>
<body style="background-color: olive;">


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4">
				<img alt="Cart icon" src="resources/images/new logo-1.png"
					width="200px" height="200px">

			</div>

			<div class="col-sm-4" align="center">
				<h1 style="font-family: sans-serif; font-size: 70px; color: navy;">
					<b> CD-STACK</b>
				</h1>
				<p style="font-family: sans-serif; font-size: 20px; color: navy;">The
					Online DVD-VCD store</p>
			</div>
		</div>
	</div>


	<div class="container-fluid">
		<nav class="navbar navbar-inverse">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="/CDStack"><span
						class="glyphicon glyphicon-home"></span>HOME</a></li>
				<li><a href="aboutus">ABOUT US</a></li>
				<li><a href="contact">CONTACT US</a></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">PRODUCTS <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="productform">ADD PRODUCTS</a></li>
						<li><a href="products">VIEW PRODUCTS</a></li>
					</ul></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">CATEGORIES<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="categoryform">ADD CATEGORY</a></li>
						<li><a href="category">VIEW CATEGORIES</a></li>
					</ul></li>
					
					<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">SUPPLIER<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="supplierform">ADD SUPPLIER</a></li>
						<li><a href="supplier">VIEW SUPPLIERS'</a></li>
					</ul></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span
						class="glyphicon glyphicon-shopping-cart"></span> CART</a></li>
				<li><a href="login">LOGIN</a></li>
				<!--  <li><a href="register">REGISTER</a></li>-->
			</ul>
		</div>
		</nav>
	</div>

</body>
</html>