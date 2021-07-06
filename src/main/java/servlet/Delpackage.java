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
 * Servlet implementation class Delpackage
 */
public class Delpackage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String packageid=request.getParameter("packageid");
		PackageDto rdto=new PackageDto();
		rdto.setPackageid(packageid);
		PackageDao regUser = new PackageDao();
		try {
			if(regUser.checkpackage(rdto)) {
				if(regUser.insertData(rdto)) 
				   response.sendRedirect("SuccessAdmin.jsp");
			}
			else{
				request.setAttribute("error", "wrong package id");
				RequestDispatcher rd=request.getRequestDispatcher("delpackage.jsp");
				rd.forward(request, response);
			}

		}catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
		


