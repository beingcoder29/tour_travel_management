package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HotelDao;
import dto.HotelDto;
/**
 * Servlet implementation class Addhotel
 */
public class Addhotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String hotelid=request.getParameter("hotelid");
		String hotelnm=request.getParameter("hotelnm");
		String place=request.getParameter("place");
		
		HotelDto rdto = new HotelDto();
		rdto.setHotelid(hotelid);
		rdto.setHotelnm(hotelnm);
		rdto.setPlace(place);
		// make user object

		// create a database model
		HotelDao regUser = new HotelDao();
		try {
			if(regUser.checkhotel(rdto)) {
				if(regUser.insertData(rdto)) 
				   response.sendRedirect("SuccessAdmin.jsp");
			}
			else{
				request.setAttribute("error", "Hotel already exists");
				RequestDispatcher rd=request.getRequestDispatcher("hotel.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
