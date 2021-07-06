package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookingDao;

import dto.BookingDto;


/**
 * Servlet implementation class BookingServe
 */
public class BookingServe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Date dNow = new Date();
	        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmssSS");
	        String datetime = ft.format(dNow);
		
		
		response.setContentType("text/html");
		String bookingid="bkid"+datetime;
	    String packageid=request.getParameter("packageid");
		String packagenm=request.getParameter("packagenm");
		String place1=request.getParameter("place1");
		String place2=request.getParameter("place2");
		String place3=request.getParameter("place3");
		String hotelname1=request.getParameter("hotelname1");
		String hotelname2=request.getParameter("hotelname2");
		String hotelname3=request.getParameter("hotelname3");
		int days=Integer.parseInt(request.getParameter("days"));
	    int packagecost=Integer.parseInt(request.getParameter("packagecost"));
		String date=request.getParameter("date");
		String bdate=request.getParameter("bdate");
		int num_of_persons=Integer.parseInt(request.getParameter("num_of_persons"));
		String room_type1=request.getParameter("room_type");
		String username=request.getParameter("username");
		String bank=request.getParameter("bank");
		String cno=request.getParameter("cardno");
		String cardno="************"+cno.substring(12);
		String passwd=request.getParameter("password");
		String password="****"+passwd.substring(4);
		String doe=request.getParameter("doe");
		String cv=request.getParameter("cvv");
		String cvv="**"+cv.substring(2);
		double total_price=Double.parseDouble(request.getParameter("total_price"));
		

		BookingDto rdto = new BookingDto();
		
		rdto.setBookingid(bookingid);
		rdto.setPackageid(packageid);
		rdto.setPackagenm(packagenm);
		rdto.setPlace1(place1);
		rdto.setPlace2(place2);
		rdto.setPlace3(place3);
		rdto.setHotelname1(hotelname1);
		rdto.setHotelname2(hotelname2);
		rdto.setHotelname3(hotelname3);
		rdto.setDays(days);
		rdto.setPackagecost(packagecost);
		rdto.setDate(date);
		rdto.setBdate(bdate);
		rdto.setNum_of_persons(num_of_persons);
		rdto.setRoom_type(room_type1);
		rdto.setUsername(username);
		rdto.setBank(bank);
		rdto.setCardno(cardno);
		rdto.setPassword(password);
		rdto.setDoe(doe);
		rdto.setCvv(cvv);
		rdto.setTotal_price(total_price);
		
		// make user object

		// create a database model
		BookingDao regUser = new BookingDao();
		try {
			
				if(regUser.insertData(rdto)) {
					request.setAttribute("id", bookingid);
				RequestDispatcher rd=request.getRequestDispatcher("successbooking.jsp");
				rd.forward(request, response);
				}
			else{
				request.setAttribute("error", "Please Try Again..");
				RequestDispatcher rd=request.getRequestDispatcher("booking.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	


	
	}

}
