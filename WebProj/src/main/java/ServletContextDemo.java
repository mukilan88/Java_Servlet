import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ServletContextDemo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();// implemented by GenericServlet class
		String goldrate = context.getInitParameter("goldrate");
		out.println("Gold Rate : " + goldrate);
	}
}