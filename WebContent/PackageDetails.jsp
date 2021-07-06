<%@page import="java.sql.ResultSet"%>
<%@page import="dto.*"%>
<%@page import="dao.*"%>
<%@ page import="java.util.*"%>

<%
String packageid=request.getParameter("packageid");
PackageDao sdao6=new PackageDao();
//System.out.println(packageid);

ResultSet rs=sdao6.getTourDetails(packageid);


while(rs.next())
{
   //System.out.println(rs.getString(1));

   out.println(rs.getString(2) +"#");
   //System.out.println("Details::"+s6.getTNAME());
   out.println(rs.getString(3) +"#");
  //System.out.println("Details::"+s6.getTPLACE1());
   out.println(rs.getString(4)+"#");
  // System.out.println("Details::"+s6.getTPLACE2());
   out.println(rs.getString(5)+"#");
   //System.out.println("Details::"+s6.getTPLACE3());
   
   //System.out.println("Details::"+s6.getDAYS());
   out.println(rs.getInt(6)+"#");
   out.println(rs.getString(7)+"#");
   out.println(rs.getString(8)+"#");
  //System.out.println("Details::"+s6.getTPRICE());
   //out.println(s.getCphn());
   
   
 }

%>