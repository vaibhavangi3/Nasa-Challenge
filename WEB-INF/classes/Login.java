

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String n,p;
		n=request.getParameter("uname");
		p=request.getParameter("psw");
		int status=LoginDao.validate(n,p);
		if(status>0) {
			HttpSession hs=request.getSession();
			hs.setAttribute("login",true);
			hs.setAttribute("uname",n);
			response.sendRedirect("Form");
		}else {
		
			request.getRequestDispatcher("login.html").include(request,response);
			out.println("<h2>Invalid Combination</h2>");
		}
		
	}

}
