package codingtonportal.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import codingtonportal.model.domain.Event;
import codingtonportal.model.services.EventServiceImpl;
import codingtonportal.model.services.EventSignUpImpl;

/**
 * Servlet implementation class AdminProfileServlet
 */
@WebServlet(description = "Servlet to show the Admin page", urlPatterns = { "/admin" })
public class AdminProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		session.setAttribute("ErrorLogin", null);
		
		ArrayList<Event> eventsList=null;
		
		EventServiceImpl eventService=new EventServiceImpl();
		
		//Params of jsp for get
		String update = null;
		update = request.getParameter("update");
		
		String delete = null;
		delete = request.getParameter("delete");
		
		try {
			if(delete!=null){ 
				if(eventService.deleteEvent(Integer.parseInt((delete)) ) {
					
				}
			}
			eventsList = eventService.viewEvent();
			session.setAttribute("EVENTLIST", eventsList);
			
			response.sendRedirect("profileAdmin.jsp");
			
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
		// TODO Auto-generated method stub
	}

}
