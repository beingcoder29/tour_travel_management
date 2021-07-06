package servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DocDao;
import dto.DocDto;

/**
 * Servlet implementation class Registerserve
 */
public class Registerserve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
	
		

		
	
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			String nm = request.getParameter("nm");
			String phno = request.getParameter("phno");
			String email = request.getParameter("email");
			DocDto rdto = new DocDto();
			rdto.setUname(uname);
			rdto.setPass(pass);
			rdto.setNm(nm);
			rdto.setPhno(phno);
			rdto.setEmail(email);
			// make user object

			// create a database model
			DocDao regUser = new DocDao();
			try {
				if(regUser.checkuser(rdto)) {
					if(regUser.insertData(rdto)) 
					   response.sendRedirect("success.jsp");
				}
				else{
					String errorMessage = "User Available";
					HttpSession regSession = request.getSession();
					regSession.setAttribute("RegError", errorMessage);
					response.sendRedirect("registration.jsp");
				}
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	
		
}
}