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

/**
 * Servlet implementation class EventsServlet
 */
@WebServlet("/events")
public class EventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		if(session == null || session.getAttribute("user")== null) {
			out.println("<html>");
			out.println("<body>");
			out.println("Please login, your session either expired or you have not logged in yet");
			out.println("<br><a href='login.html'>Login</a>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String eventName = request.getParameter("event_name");
		String eventDate = request.getParameter("event_date");
		String eventMonth = request.getParameter("event_month");
		
		
		String errors = "";
		if(StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)
				|| StringUtils.isBlank(eventName) || StringUtils.isBlank(eventDate) || StringUtils.isBlank(eventMonth)) {
			errors = "Invalid input provided";
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("jsp/newEvent.jsp").forward(request, response);
			//response.sendRedirect("jsp/newEvent.jsp");
		}
		
		//TODO after finishing the DAO methods, save person and event to the database.
		//if person exists based on firstname and last name, add the event with the same person id.
		//First check for person
		//Add person if required and get id.
		//Save event with person id.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
