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
 * Servlet implementation class Link_mysql
 */
@WebServlet("/Link_mysql")
public class Link_mysql extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String nam,email,num;
    		nam=(String) request.getAttribute("name");
    		email=(String) request.getAttribute("email");
    		num=(String) request.getAttribute("number");
    		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","1234");
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
			ps.setString(1, nam);
			ps.setString(2, email);
			ps.setString(3, num);
			ps.executeUpdate();
    		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    	}

}
