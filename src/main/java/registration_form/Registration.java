package registration_form;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nam,email,num;
		nam=request.getParameter("Student_name");
		email=request.getParameter("Semail");
		num=request.getParameter("Snumber");
		request.setAttribute("name", nam);
		request.setAttribute("email", email);
		request.setAttribute("number", num);
		RequestDispatcher rd=request.getRequestDispatcher("Link_mysql");
		rd.forward(request, response);
	}

}
