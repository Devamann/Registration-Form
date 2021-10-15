package registration_form;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete_row
 */
@WebServlet("/Delete_row")
public class Delete_row extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nam=request.getParameter("C1");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","1234");
			PreparedStatement ps=con.prepareStatement("delete from student where name=?");
			ps.setString(1, nam);
			ps.executeUpdate();
    		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("show_data.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
