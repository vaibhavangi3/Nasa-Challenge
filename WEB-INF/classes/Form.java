import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Form")
public class Form extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		request.getRequestDispatcher("header.html").include(request, response);
		HttpSession hs=request.getSession(false);
		if(hs==null) {
			response.sendRedirect("index.html");
		}else {
			String e=(String)hs.getAttribute("uname");
			
			out.print("<br><br><h1>welcome please select category and provide input..</h1>");
			try {
				Connection con=ConProvider.getConnection();
			}catch(Exception ex) {
				System.out.println(ex);
			}
			}
		request.getRequestDispatcher("footer.html").include(request, response);
	}

}