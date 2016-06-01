package com.itekkies.training.events;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.itekkies.training.db.UsersDAO;

//import com.itekkies.training.util.StringUtils;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Validate the form
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		PrintWriter out = response.getWriter();
		
		String errors = "";
		
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(email) 
				|| StringUtils.isBlank(password)) {
			out.println("<font color='red'>Invalid input provided</font>");
			out.println("<br>Please try agian. <a href='signup.html'>Singup</a>");
			return;
		}
		
		UsersDAO usersdao = new UsersDAO();
		
		if(usersdao.getUser(userName) != null) {
			errors = errors + "<font color='red'>User name already taken up, please use another name</font>" + 
						"<br>Please try agian. <a href='signup.html'>Singup</a>";
			
			out.println(errors);
			return;
		}
		else {
			System.out.println("user name available");
		}
		User user = new User(userName, password, email);
		usersdao.saveUser(user);
		out.println("Thaks for signing up, please login using your details");
		
	}

}
