package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;

/**
 * Servlet implementation class Loginserve
 */
public class Loginserve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		if(uname.equals("admin")&& pass.equals("admin"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("AdminMenu.jsp");
		}
		else
		{
			
				LoginDao ldao=new LoginDao();
				  boolean flag=ldao.checkLogin(uname, pass);
				  if(flag==true)
				  {
					  HttpSession session=request.getSession();
					  session.setAttribute("username", uname);
					  response.sendRedirect("ClientMenu.jsp");
				  }
				  else
				  {
					  request.setAttribute("error", "Wrong Username or Password");
						RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
						rd.forward(request, response);
					  
					  
				  }
			
			
		}
	}

}
