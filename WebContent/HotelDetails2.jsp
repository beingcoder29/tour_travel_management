<%@page import="dao.HotelDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
String place1=request.getParameter("place1");
HotelDao sdao6=new HotelDao();
//System.out.print(place1);
String hotelnm=sdao6.getHotelName(place1);
System.out.print(hotelnm);
   out.println(hotelnm +"#");
   
 


%>
