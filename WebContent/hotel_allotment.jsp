
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.AllotDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%@include file="AdminHeader.jsp"%>
<link rel="stylesheet" type="text/css" href="css/showdata.css">

<title>Allotment Details</title>
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
<td>NO. OF DAYS</td>
<td>JOURNEY DATE</td>
<td>PRICE</td>
<td>HOTEL ID</td>
<td>HOTEL NAME</td>
<td>PLACE</td>
</tr>
<%
AllotDao adao=new AllotDao();
ResultSet rs= adao.getData();
while(rs.next())
{
String packageid=rs.getString(1);
String packagenm=rs.getString(2);
String days=rs.getString(3);
String date=rs.getString(4);
String packagecost=rs.getString(5);
String hotelid=rs.getString(6);
String hotelnm=rs.getString(7);
String place=rs.getString(8);
%>
<tr>
<td><%=packageid %></td>
<td><%=packagenm %></td>
<td><%=days %></td>
<td><%=date %></td>
<td><%=packagecost %></td>
<td><%=hotelid %></td>
<td><%=hotelnm %></td>
<td><%=place %></td>
</tr>
<%
}
%>

</table>
 </div>
</body>
</html>