<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Montserrat);

html, body{
  height: 100%;
  font-weight: 800;
}

body{
  background: #030321;
  font-family: Arial;
}

svg {
    display: block;
    font: 10.5em 'Montserrat';
    width: 960px;
    height: 300px;
    margin: 0 auto;
}

.text-copy {
    fill: none;
    stroke: white;
    stroke-dasharray: 6% 29%;
    stroke-width: 5px;
    stroke-dashoffset: 0%;
    animation: stroke-offset 5.5s infinite linear;
}

.text-copy:nth-child(1){
	stroke: #4D163D;
	animation-delay: -1;
}

.text-copy:nth-child(2){
	stroke: #840037;
	animation-delay: -2s;
}

.text-copy:nth-child(3){
	stroke: #BD0034;
	animation-delay: -3s;
}

.text-copy:nth-child(4){
	stroke: #BD0034;
	animation-delay: -4s;
}

.text-copy:nth-child(5){
	stroke: #FDB731;
	animation-delay: -5s;
}

@keyframes stroke-offset{
	100% {stroke-dashoffset: -35%;}
}
</style>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%@include file="ClientHeader.jsp"%>
<%
  if(session.getAttribute("username")==null){
	  response.sendRedirect("login.jsp");
  }
%>

<svg viewBox="0 0 2080 300">
	<symbol id="s-text">
		<text text-anchor="middle" x="50%" y="40%">Welcome ${username}</text>
	</symbol>

	<g class = "g-ants">
		<use xlink:href="#s-text" class="text-copy"></use>
		<use xlink:href="#s-text" class="text-copy"></use>
		<use xlink:href="#s-text" class="text-copy"></use>
		<use xlink:href="#s-text" class="text-copy"></use>
		<use xlink:href="#s-text" class="text-copy"></use>
	</g>
</svg>
</body>
</html>