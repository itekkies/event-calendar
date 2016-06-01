package com.itekkies.training.events;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.itekkies.training.db.UsersDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		String errors = "";
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
			out.println("<font color='red'>Invalid input provided</font>");
			out.println("<br>Please try agian. <a href='login.html'>Login</a>");
			return;
		}
		
		UsersDAO usersdao = new UsersDAO();
		User user = usersdao.getUser(userName);
		
		if(user == null) {
			errors = errors + "<font color='red'>Invalid user name, please try again.</font>" + 
						"<a href='login.html'>Login</a>";
			
			out.println(errors);
			return;
		}
		else {
			if(password.equals(user.getPassword())) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", user);
				response.sendRedirect("events.html");
			}
			else {
				errors = errors + "<font color='red'>Invalid password, please try again.</font>" + 
						"<a href='login.html'>Login</a>";
				out.println(errors);
				return;
			}
		}
				
	}

}
