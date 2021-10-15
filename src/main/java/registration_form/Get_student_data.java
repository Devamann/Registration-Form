package registration_form;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Get_student_data {
	public static ResultSet Table() {
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "1234");
			PreparedStatement ps = con.prepareStatement("select * from student");
			rs = ps.executeQuery();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
