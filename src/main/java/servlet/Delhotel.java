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
 * Servlet implementation class Delhotel
 */
public class Delhotel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String hotelid=request.getParameter("hotelid");
		HotelDto rdto=new HotelDto();
		rdto.setHotelid(hotelid);
		HotelDao regUser = new HotelDao();
		try {
			if(regUser.checkhotel(rdto)) {
				if(regUser.deleteData(rdto)) 
				   response.sendRedirect("SuccessAdmin.jsp");
				else
					response.sendRedirect("error.jsp");
			}
			else{
				request.setAttribute("error", "wrong hotel id");
				RequestDispatcher rd=request.getRequestDispatcher("delhotel.jsp");
				rd.forward(request, response);
			}

		}catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
