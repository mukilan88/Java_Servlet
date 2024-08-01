import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HttpPage2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null)
			out.println("Welcome "+username);
		else
			//out.println("Invalid Session");
			response.sendRedirect("/WebProj/session.html");
			
	}
}
