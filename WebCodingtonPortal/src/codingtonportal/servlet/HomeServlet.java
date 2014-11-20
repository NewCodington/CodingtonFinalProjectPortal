package codingtonportal.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import codingtonportal.model.domain.Event;
import codingtonportal.model.services.EventServiceImpl;



/**
 * Servlet implementation class SigninServlet
 */
@WebServlet(description = "Servlet for select Event", urlPatterns = { "/HomeServlet" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		EventServiceImpl eventService=new EventServiceImpl();
		HttpSession session=request.getSession();
		ArrayList<Event> eventsList;
		try {
			eventsList = eventService.viewEvent();
			session.setAttribute("EVENTLIST", eventsList);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		
		

		//RequestDispatcher dispatcher=request.getRequestDispatcher("/home.jsp?msg=Evento creado con éxito");
		//dispatcher.forward(request, response);


	}

}
