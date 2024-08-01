import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.sql.*;
public class RegisterServlet extends HttpServlet {
	Connection con;
	public void init(ServletConfig config)
	{
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			PreparedStatement st = con.prepareStatement("insert into users values ('"+name+"','"+username+"','"+password+"')");
			st.executeUpdate();
			out.println("Registered Successfully<br>");
			out.println("Click <a href=\"/WebProj/login.jsp\">here</a> to login");
		} catch (Exception e) {
			out.println(e);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void destroy()
	{
		try {
			con.close();
		} catch (Exception e) {
			
		}
	}
}