<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/Home.css">
<meta charset="ISO-8859-1">
<title>Add Package</title>
</head>
<body>
<%@include file="AdminHeader.jsp"%>
<%
  if(session.getAttribute("username")==null){
	  response.sendRedirect("login.jsp");
  }
%>
<section class="section">
		<div class="sectiondev">
			<div class="container">
			  <h2>Add Package</h2>
			  <div class="panel col-sm-8">
			    <div class="panel-body">
			    	<div class="row">
			    		<div class="col-sm-4">
			    			<form action="Addpackage" method="post">
			    			<div class="form-group">
			    				Enter Package ID:
			    				<span style="color:red;">${error}</span>
			    				</div>
			    				<div class="form-group">
			    					<input class="form-control" type="text" id="packageid" name="packageid" required>
			    				</div>
			    				
			    				<div class="form-group">
			    				Enter Package Name:
			    				</div>
			    				<div class="form-group">
			    					<input class="form-control" type="text" id="packagenm" name="packagenm" required>
			    				</div>
			    				<div class="form-group">
			    				Enter Package Place1:
			    				</div>
			    				<div class="form-group">
			    					<input class="form-control" type="text" id="place1" name="place1" required>
			    				</div>
			    				<div class="form-group">
			    				Enter Package Place2:
			    				</div>
			    				<div class="form-group">
			    					<input class="form-control" type="text" id="place2" name="place2" required>
			    				</div>
			    				<div class="form-group">
			    				Enter Package Place3:
			    				</div>
			    				<div class="form-group">
			    					<input class="form-control" type="text" id="place3" name="place3" required>
			    				</div>
			    				<div class="form-group">
			    				Enter Number Of Days:
			    				</div>
			    				<div class="form-group">
			    					<input class="form-control" type="text" id="days" name="days" required>
			    				</div>
			    				<div class="form-group">
			    				Enter Date of Tour:
			    				</div>
			    				<div class="form-group">
			    					<input class="form-control" type="text" id="date" name="date" required value="dd/mm/yy">
			    				</div>
			    				<div class="form-group">
			    				Enter Cost:
			    				</div>
			    				<div class="form-group">
			    					<input class="form-control" type="text" id="packagecost" name="packagecost" required>
			    				</div>
			    				<div class="form-group">
			    					<div class="text-right"> 
			    						<input type="submit" id="button" value="Add Package" class="btn btn-primary">
			    					</div>
			    				</div>
			    				
			    			</form>
			    		</div>
			    	</div>
			  </div>
			</div>
		</div>
	</div>
	</section>
	<span style="colro:red;">${error}</span>
</body>
</html>