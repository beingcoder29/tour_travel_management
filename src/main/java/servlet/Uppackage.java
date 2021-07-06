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
 * Servlet implementation class Uppackage
 */
public class Uppackage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String packageid=request.getParameter("packageid");
		int days=Integer.parseInt(request.getParameter("days"));
		String date=request.getParameter("date");
		String packagecost=request.getParameter("packagecost");
		PackageDto rdto=new PackageDto();
		rdto.setPackageid(packageid);
		rdto.setDays(days);
		rdto.setDate(date);
		rdto.setPackagecost(packagecost);
		PackageDao regUser = new PackageDao();
		try {
			if(regUser.checkpackage(rdto)) {
				if(regUser.updateData(rdto)) 
				   response.sendRedirect("SuccessAdmin.jsp");
				else
					response.sendRedirect("error.jsp");
			}
			else{
				request.setAttribute("error", "wrong package id");
				RequestDispatcher rd=request.getRequestDispatcher("uppackage.jsp");
				rd.forward(request, response);
			}

		}catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	}


