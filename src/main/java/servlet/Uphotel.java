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
 * Servlet implementation class Uphotel
 */
public class Uphotel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
				if(regUser.updateData(rdto)) 
				   response.sendRedirect("SuccessAdmin.jsp");
				else
					response.sendRedirect("error.jsp");
			}
			else{
				request.setAttribute("error", "Wrong Hotel ID");
				RequestDispatcher rd=request.getRequestDispatcher("uphotel.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
