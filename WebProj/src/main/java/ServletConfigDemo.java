import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ServletConfigDemo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();//implemented by GenericServlet class
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		out.println("username : "+username);
		out.println("password : "+password);
	}
}