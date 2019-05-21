

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Fauna
 */
@WebServlet("/Fauna")
public class Fauna extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("header.html");
		rd.include(request,response);
		HttpSession hs=request.getSession(false);
		if(hs==null) {
			response.sendRedirect("index.html");
		}else {
			String e=(String)hs.getAttribute("uname");
			String a,b,c,d;
			a=request.getParameter("cat");
			b=request.getParameter("dis");
			c=request.getParameter("eff");
			d=request.getParameter("sym");
			 
			int status=FaunaDao.save(e,a,b,c,d);
			if(status>0) {
				
				request.getRequestDispatcher("header.html").include(request, response);
				out.print("<br><br><br><br><br><h3>Data Reported</h3>");
				
				
			}else {
				
			}
			request.getRequestDispatcher("footer.html").include(request, response);
		}
	}

	

}
