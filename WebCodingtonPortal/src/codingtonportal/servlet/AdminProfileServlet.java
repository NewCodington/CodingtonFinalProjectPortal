package codingtonportal.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import codingtonportal.model.domain.Event;
import codingtonportal.model.domain.Place;
import codingtonportal.model.services.EventServiceImpl;
import codingtonportal.model.services.EventSignUpImpl;
import codingtonportal.model.services.PlaceServiceImpl;

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
		ArrayList<Place> placesList=null;
		
		EventServiceImpl eventService=new EventServiceImpl();
		PlaceServiceImpl placeService=new PlaceServiceImpl();
		
		
		
		//Params of jsp for get
		String updateEvent = null;
		updateEvent = request.getParameter("updateEvent");
		
		String deleteEvent = null;
		deleteEvent = request.getParameter("deleteEvent");
		
		String updatePlace = null;
		updatePlace = request.getParameter("updatePlace");
		
		String deletePlace = null;
		deletePlace = request.getParameter("deletePlace");
		
		try {

			if(session.getAttribute("ViewSuccess")!=null && !session.getAttribute("ViewSuccess").toString().equals("YES")) {
				session.setAttribute("ViewSuccess", null);
			}
			else
				session.setAttribute("Success", null);
			
			
			if(updateEvent!=null){ 
				//LLamo a la pagina para poder modificar los parametros
				response.sendRedirect("updateEvent?idEvent="+updateEvent);
			}
			
			if(updatePlace!=null){ 
				response.sendRedirect("updatePlace");
			}
			
			if(deleteEvent!=null){ 
				eventService.deleteEvent(Integer.parseInt((deleteEvent)));
				session.setAttribute("Success", "Successfully Event deleted");
				session.setAttribute("ViewSuccess", null);
			}
			
			if(deletePlace!=null){ 
				placeService.deletePlace(Integer.parseInt((deletePlace)));
				session.setAttribute("Success", "Successfully Place deleted");
				session.setAttribute("ViewSuccess", null);
			}
			
			
			eventsList = eventService.viewEvent();
			session.setAttribute("EVENTLIST", eventsList);
			
			placesList = placeService.viewPlace();
			session.setAttribute("PLACELIST", placesList);

			response.sendRedirect("profileAdmin.jsp");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
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
