<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %>
  <%@ page import="java.sql.*" %>
  <%@page import="dto.PackageDto"%>
<%@page import="dao.PackageDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Package</title>
</head>
<body onload="myFunction()">
<%@include file="ClientHeader.jsp"%>
<%
  if(session.getAttribute("username")==null){
	  response.sendRedirect("login.jsp");
  }
%>

<script type="text/javascript">
var req=false;
function initialize()
{
  if(window.XMLHttpRequest)
   {
    req=new XMLHttpRequest();
    }
    else if(window.ActiveXObject)
    {
     req=new ActiveXObject("Microsoft.XMLHTTP");
     }
  
    }
function getDetails()
{
	 initialize();
	 //alert("HELLO");
    // alert("cid:"+cid);
     var packageid=document.f1.packageid.value;
   // alert("packageid:"+packageid);
   
     
     var url="PackageDetails.jsp?packageid="+packageid;
     if(req!=null)
     {
         req.open("post",url,true);
         req.onreadystatechange=process1;
         req.send(null);
     }
    
     else
     {
       //document.getElementById("test").innerHTML="";  
     }
  }
  function process1()
  {
   if(req.readyState==4)
   {
     if(req.status==200)
     {
    	 var result=req.responseText;
    	 //alert(result);
      	  var packagenm=result.substring(0, result.indexOf("#"));
     	  document.getElementById("packagenm").value=packagenm;  
     	 // alert(tname);
     	   var temp3=result.substring(result.indexOf("#")+1);
          var place1=temp3.substring(0, temp3.indexOf("#"));
          //alert(tplace1);
          document.getElementById("place1").value=place1;   
           var temp4=temp3.substring(temp3.indexOf("#")+1);
          var place2=temp4.substring(0, temp4.indexOf("#"));
          //alert(tplace2);
          document.getElementById("place2").value=place2;         
          var temp5=temp4.substring(temp4.indexOf("#")+1);
          var place3=temp5.substring(0, temp5.indexOf("#"));
         // alert(tplace3);
          document.getElementById("place3").value=place3;
          temp6=temp5.substring(temp5.indexOf("#")+1);         
          var days=temp6.substring(0, temp6.indexOf("#"));
         // alert(days);
          document.getElementById("days").value=days;         
          temp7=temp6.substring(temp6.indexOf("#")+1);
          var date=temp7.substring(0, temp7.indexOf("#"));
          // alert(doj);
           document.getElementById("date").value=date;
          temp8=temp7.substring(temp7.indexOf("#")+1);
         
          var packagecost=temp8.substring(0, temp8.indexOf("#"));
          //alert(tprice);
          document.getElementById("packagecost").value=packagecost;    
         
         
         
     }
  }
     
}
//function getTotals(){
	 //var tprice=document.f1.tprice.value;	
	// alert("tprice:"+tprice);
	 //var head_counts=document.f1.head_counts.value;
	// alert("head_counts:"+head_counts);
 //} 
  
function populateHotelName1()
{
	 initialize();
	 //alert("HELLO");
    // alert("cid:"+cid);
     var place1=document.f1.place1.value;
   // alert("place1"+place1);
   
     
     var url="HotelDetails1.jsp?place1="+place1;
     if(req!=null)
     {
         req.open("post",url,true);
         req.onreadystatechange=process2;
         req.send(null);
     }
    
     else
     {
       //document.getElementById("test").innerHTML="";  
     }
  }
  function process2()
  {
   if(req.readyState==4)
   {
     if(req.status==200)
     {
    	 var result=req.responseText;
    	// alert(result);
     	  var hotelnm=result.substring(0, result.indexOf("#"));
     	  document.getElementById("hotelname1").value=hotelnm;  
     	
         
         
         
     }
  }


}
  function populateHotelName2()
  {
  	 initialize();
  	// alert("HELLO");
      // alert("cid:"+cid);
       var place1=document.f1.place2.value;
      //alert("tplace1"+tplace1);
     
       
       var url="HotelDetails1.jsp?place1="+place1;
       if(req!=null)
       {
           req.open("post",url,true);
           req.onreadystatechange=process4;
           req.send(null);
       }
      
       else
       {
         //document.getElementById("test").innerHTML="";  
       }
    }
    function process4()
    {
     if(req.readyState==4)
     {
       if(req.status==200)
       {
      	 var result=req.responseText;
      	 //alert(result);
       	  var hotelnm=result.substring(0, result.indexOf("#"));
       	  document.getElementById("hotelname2").value=hotelnm;  
       	
           
           
           
       }
    }


  }

    function populateHotelName3()
    {
    	 initialize();
    	// alert("HELLO");
        // alert("cid:"+cid);
         var place1=document.f1.place3.value;
       // alert("tplace1"+tplace1);
       
         
         var url="HotelDetails1.jsp?place1="+place1;
         if(req!=null)
         {
             req.open("post",url,true);
             req.onreadystatechange=process5;
             req.send(null);
         }
        
         else
         {
           //document.getElementById("test").innerHTML="";  
         }
      }
      function process5()
      {
       if(req.readyState==4)
       {
         if(req.status==200)
         {
        	 var result=req.responseText;
        	// alert(result);
         	  var hotelnm=result.substring(0, result.indexOf("#"));
         	  document.getElementById("hotelname3").value=hotelnm;  
         	
             
             
             
         }
      }


    }
function callPrice()
{
	//alert("ROOMRENT");
	var p=parseInt(document.getElementById("packagecost").value);
	//alert(p);
	var n=parseInt(document.getElementById("num_of_persons").value);
	//alert(n);
	var c=document.getElementById("room_type").value;
	//alert(c);
	if(c=='NONAC')
  {
		var total=p*n;
		//alert(total);
	document.getElementById("total_price").value=p*n;
  }
	else if(c=='AC')
	{
		document.getElementById("total_price").value=p*n+0.10*p;
	}
	else
	{
		document.getElementById("total_price").value=p*n+0.15*p;
	}
}

function myFunction() {
	   var d = new Date();
	   var day = ('0' + d.getDate()).slice(-2);
	   var month= ('0' + (d.getMonth()+1)).slice(-2);
	   var year = d.getFullYear(); 
	   var n = day + '/' + month + '/' + year ;
	   document.getElementById("bdate").defaultValue = n;
	}



</script>


<section class="section">
		<div class="sectiondev">
			<div class="container">
			  <h2>Book Package</h2>
			  <div class="panel col-sm-8">
			    <div class="panel-body">
			    	<div class="row">
			    		<div class="col-sm-4">
<form name="f1" action="BookingServe" method="post" >



<div class="form-group">
Package Id:
</div>
<div class="form-group">
<select id="packageid" name="packageid" onchange="getDetails()" > 

<option> SELECT PID</option>
<%
PackageDao ldao=new PackageDao();
//PackageDto rdto=ldao.getData();
ResultSet rs=ldao.getData();

while(rs.next())
{
	//PackageDto ldto=
	
	String id1=rs.getString(1);
	

	%>
	

	
<option value=<%=id1%>><%=id1 %>
<%
}
%>
</select>
</div>
<div class="form-group">
Package Name:
</div>
<div class="form-group">
<input type="text" id="packagenm" name="packagenm" readonly required>
</div>
<div class="form-group">
PLACE1:
</div>
<div class="form-group">
<input type="text" id="place1" name="place1" readonly required>
</div>
<div class="form-group">
HOTELNAME1:
</div>
<div class="form-group">
<input type="text" id="hotelname1" name="hotelname1" readonly required>
</div>
<div class="form-group">
<input type="button" value="get hotel1" onclick="populateHotelName1()">
</div>
<div class="form-group">
PLACE2:
</div>
<div class="form-group">
<input type="text" id="place2" name="place2" readonly required>
</div>
<div class="form-group">
HOTELNAME2:
</div>
<div class="form-group">
<input type="text" id="hotelname2" name="hotelname2" readonly required>
</div>
<div class="form-group">
<input type="button" value="get hotel2" onclick="populateHotelName2()">
</div>
<div class="form-group">
PLACE3:
</div>
<div class="form-group">
<input type="text" id="place3" name="place3" readonly required>
</div>
<div class="form-group">
Hotel Name3:
</div>
<div class="form-group">
<input type="text" id="hotelname3" name="hotelname3" readonly required>
</div>
<div class="form-group">
<input type="button" value="get hotel3" onclick="populateHotelName3()">
</div>
<div class="form-group">
Days:
</div>
<div class="form-group">
<input type="text" id="days" name="days" readonly required>
</div>
<div class="form-group">
Package Cost:
</div>
<div class="form-group">
<input type="text" id="packagecost" name="packagecost" readonly required>
</div>
<div class="form-group">
Travel Date:
</div>
<div class="form-group">
<input type="text" id="date" name="date" readonly required>
</div>
<div class="form-group">
Booking Date:
</div>
<div class="form-group">
<input type="text" id="bdate" name="bdate" value= "" readonly required>
</div>
<div class="form-group">
Num_Of_Persons:
</div>
<div class="form-group">
<input type="text" id="num_of_persons" name="num_of_persons" required>
</div>
<div class="form-group">
Room_types:
</div>
<div class="form-group">
<select id="room_type" name="room_type" onchange="callPrice()" required > 
<option> SELECT ROOM</option>
<option value="NONAC">NONAC</option>
<option value="AC">AC</option>
<option value="DELUXE">DELUXE</option>
</select>
</div>
<div class="form-group">
USERNAME:
</div>
<div class="form-group">
<input type="text" id="username" name="username" value="${username}" readonly required>
</div>
<div class="form-group">
BANK NAME:
</div>
<div class="form-group">
<select name="bank" required>
<option value="HDFC">HDFC</option>
<option value="SBI">SBI</option>
<option value="AXIS">AXIS</option>
<option value="PNB">PNB</option>
</select>
</div>
<div class="form-group">
CARD NO:
</div>
<div class="form-group">
<input type="text" id="cardno" name="cardno" maxlength="16" required>
</div>
<div class="form-group">
PASSWORD:
</div>
<div class="form-group">
<input type="password" id="password" name="password" maxlength="6"  required>
</div>
<div class="form-group">
DATE OF EXPEIARY:
</div>
<div class="form-group">
<input type="text" id="doe" name="doe" value="MM/YYYY" required>
</div>
<div class="form-group">
CVV NO:
</div>
<div class="form-group">
<input type="text" id="cvv" name="cvv" maxlength="3"  required>
</div>
<div class="form-group">
TOTAL_PRICE:
</div>
<div class="form-group">
<input type="text" id="total_price" name="total_price" readonly required>
</div>
<div class="form-group">
<div class="text-right"> 
<input type="submit" id="button" value="Book"  class="btn btn-primary"><span style="color: red;">${error}</span>
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
</body>
</html>