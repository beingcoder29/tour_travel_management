<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="css/Home.css">


<title>User Home</title>
</head>
<body>
<header>
    <!-- HEADER -->
    <nav class = "top-nav">
			<ul>
				<li><form action="Logout" method="post"><input type="submit" value="LogOut"></form></li>
				<li><label>Hi, ${username}</label></li>
				
			</ul>
		</nav>
	<div id="header">
		<div class="container">
        	<div align="left">
				<font size="7">
					<p id="title">Welcome </p>
				</font>
			</div>
		</div>
	</div>
</header>
<div id="navbar">
	<nav class="navbar navbar-default" role="navigation" >
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="ClientMenu.jsp" >Home</a></li>
				<li><a href="packageshow.jsp" >Packages</a></li>
				<li><a href="booking.jsp" >Book Package</a></li>
				<li><a href="bookdetails.jsp">Booking Details</a></li>
				
				
			</ul>
		</div>
	</nav>
</div>
</body>
</html>