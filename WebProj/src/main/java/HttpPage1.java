import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HttpPage1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String username = request.getParameter("username");
		HttpSession session = request.getSession();
		session.setAttribute("username",username);
		out.println("<a href=\"/WebProj/HttpPage2\">Next Page</a>");
	}
}