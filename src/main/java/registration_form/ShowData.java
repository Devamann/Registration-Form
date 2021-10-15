package registration_form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowData
 */
@WebServlet("/ShowData")
public class ShowData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "1234");
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			while (rs.next()) {
				out.println(rs.getString("name") + "&nbsp;&nbsp;" + rs.getString(2) + "&nbsp;" + rs.getString(3)+"<br>");
			}
			out.println("<h1>Hello World</h1>");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
