
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.BookingDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<%@include file="AdminHeader.jsp"%>
<link rel="stylesheet" type="text/css" href="css/showdata.css">
<title>Booking Details</title>
</head>
<body>

<%
  if(session.getAttribute("username")==null){
	  response.sendRedirect("login.jsp");
  }
%>
<div class="tbl-header">
<div class="scrollit">
<table>

<tr>
<td>Booking ID</td>
<td></td>
<td>Username</td>
<td></td>
<td>Package ID</td>
<td>Package Name</td>
<td>Place1</td>
<td>Place2</td>
<td>Place3</td>
<td>Hotel1</td>
<td>Hotel2</td>
<td>Hotel3</td>
<td>Days</td>
<td>Package Cost</td>
<td>Date</td>
<td>Booking Date</td>
<td>Persons</td>
<td>Room Type</td>

<td>Total Cost</td>
<td>Payment Status</td>
</tr>
<%
BookingDao adao=new BookingDao();
ResultSet rs= adao.getDataadmin();
while(rs.next())
{
String bookingid=rs.getString(1);
String packageid=rs.getString(2);
String packagenm=rs.getString(3);
String place1=rs.getString(4);
String place2=rs.getString(5);
String place3=rs.getString(6);
String hotelnm1=rs.getString(7);
String hotelnm2=rs.getString(8);
String hotelnm3=rs.getString(9);
String days=rs.getString(10);
int packagecost=rs.getInt(11);
String date=rs.getString(12);
String bdate=rs.getString(13);
int person=rs.getInt(14);
String room=rs.getString(15);
String username=rs.getString(16);
double total=rs.getDouble(22);

%>
<tr>
<td><%=bookingid%></td>
<td></td>
<td><%=username %></td>
<td></td>
<td><%=packageid %></td>
<td><%=packagenm %></td>
<td><%=place1%></td>
<td><%=place2%></td>
<td><%=place3%></td>
<td><%=hotelnm1 %></td>
<td><%=hotelnm2 %></td>
<td><%=hotelnm3 %></td>
<td><%=days %></td>
<td><%=packagecost %></td>
<td><%=date %></td>
<td><%=bdate %></td>
<td><%=person %></td>
<td><%=room %></td>
<td><%=total %></td>
<td>Done</td>

</tr>
<%
}
%>

</table>
</div>
 </div>
</body>
</html>

