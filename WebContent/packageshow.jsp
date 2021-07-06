
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.PackageDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%@include file="ClientHeader.jsp"%>
<link rel="stylesheet" type="text/css" href="css/showdata.css">

<title>Packages Available</title>
</head>
<body>

<%
  if(session.getAttribute("username")==null){
	  response.sendRedirect("login.jsp");
  }
%>

<div class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">

<tr>
<td>PACKAGE ID</td>
<td>PACKAGE NAME</td>
<td>PLACE1</td>
<td>PLACE2</td>
<td>PLACE3</td>
<td>NO. OF DAYS</td>
<td>JOURNEY DATE</td>
<td>PRICE</td>

</tr>
<%
PackageDao adao=new PackageDao();
ResultSet rs= adao.getData();
while(rs.next())
{
String packageid=rs.getString(1);
String packagenm=rs.getString(2);
String place1=rs.getString(3);
String place2=rs.getString(4);
String place3=rs.getString(5);
String days=rs.getString(6);
String date=rs.getString(7);
String packagecost=rs.getString(8);


%>
<tr>
<td><%=packageid %></td>
<td><%=packagenm %></td>
<td><%=place1 %></td>
<td><%=place2 %></td>
<td><%=place3 %></td>
<td><%=days %></td>
<td><%=date %></td>
<td><%=packagecost %></td>


</tr>
<%
}
%>

</table>
 </div>
</body>
</html>