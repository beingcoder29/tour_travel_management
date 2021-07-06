<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="css/Home.css">


<title>Admin Home</title>
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
					<p id="title">Welcome Admin</p>
				</font>
			</div>
		</div>
	</div>
</header>
<div id="navbar">
	<nav class="navbar navbar-default" role="navigation" >
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="package.jsp" >Add Package</a></li>
				<li><a href="delpackage.jsp" >Delete/Update Package</a></li>
				<li><a href="hotel.jsp" >Add Hotel</a></li>
				<li><a href="delhotel.jsp" >Delete/Update Hotel</a></li>
				<li><a href="allot.jsp" >Allotment</a></li>
				<li><a href="hotel_allotment.jsp" >AllotmentData</a></li>
				<li><a href="bookreport.jsp" >Bookings</a></li>
				
			</ul>
		</div>
	</nav>
</div>
</body>
</html>