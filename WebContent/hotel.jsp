<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Hotel</title>
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
			  <h2>Add Hotel</h2>
			  <div class="panel col-sm-8">
			    <div class="panel-body">
			    	<div class="row">
			    		<div class="col-sm-4">
			    			<form action="Addhotel" method="post">
			    			<div class="form-group">
			    				Enter Hotel ID:
			    				<span style="color:red;">${error}</span>
			    				</div>
			    				<div class="form-group">
			    					<input class="form-control" type="text" id="hotelid" name="hotelid" required>
			    				</div>
			    				
			    				<div class="form-group">
			    				Enter Hotel Name:
			    				</div>
			    				<div class="form-group">
			    					<input class="form-control" type="text" id="hotelnm" name="hotelnm" required>
			    				</div>
			    				<div class="form-group">
			    				Enter Hotel Place:
			    				</div>
			    				<div class="form-group">
			    					<input class="form-control" type="text" id="place" name="place" required>
			    				</div>
			    				
			    				<div class="form-group">
			    					<div class="text-right"> 
			    						<input type="submit" id="button" value="Add Hotel" class="btn btn-primary">
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