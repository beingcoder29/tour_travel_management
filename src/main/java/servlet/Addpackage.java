package servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.PackageDao;

import dto.PackageDto;

/**
 * Servlet implementation class Addpackage
 */
public class Addpackage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		

	
			String packageid=request.getParameter("packageid");
			String packagenm=request.getParameter("packagenm");
			String place1=request.getParameter("place1");
			String place2=request.getParameter("place2");
			String place3=request.getParameter("place3");
			int days=Integer.parseInt(request.getParameter("days"));
			String date=request.getParameter("date");
			String packagecost=request.getParameter("packagecost");
			PackageDto rdto = new PackageDto();
			rdto.setPackageid(packageid);
			rdto.setPackagenm(packagenm);
			rdto.setPlace1(place1);
			rdto.setPlace2(place2);
			rdto.setPlace3(place3);
			rdto.setDays(days);
			rdto.setDate(date);
			rdto.setPackagecost(packagecost);
			// make user object

			// create a database model
			PackageDao regUser = new PackageDao();
			try {
				if(regUser.checkpackage(rdto)) {
					if(regUser.insertData(rdto)) 
					   response.sendRedirect("SuccessAdmin.jsp");
				}
				else{
					request.setAttribute("error", "Package already exists");
					RequestDispatcher rd=request.getRequestDispatcher("package.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

	
		
}
	}


