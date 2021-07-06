package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AllotDao;
import dto.AllotDto;

/**
 * Servlet implementation class Allotment
 */
public class Allotment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String packageid=request.getParameter("packageid");
		String hotelid=request.getParameter("hotelid");
		
		AllotDto rdto = new AllotDto();
		rdto.setPackageid(packageid);
		rdto.setHotelid(hotelid);
	
		// create a database model
		AllotDao regUser = new AllotDao();
		try {
			if(regUser.check(rdto)) {
				if(regUser.allotData(rdto)) 
				   response.sendRedirect("SuccessAdmin.jsp");
				
			}
			else{
				request.setAttribute("error", "Wrong Package ID or Hotel ID");
				RequestDispatcher rd=request.getRequestDispatcher("allot.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
