package codingtonportal.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import codingtonportal.model.domain.Event;
import codingtonportal.model.domain.Place;
import codingtonportal.model.services.EventServiceImpl;
import codingtonportal.model.services.PlaceServiceImpl;



/**
 * Servlet implementation class SigninServlet
 */
@WebServlet(description = "Servlet for Regist Event", urlPatterns = { "/updateEvent" })
public class UpdateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		ArrayList<Place> listPlace = null;
		PlaceServiceImpl PlaceService=new PlaceServiceImpl();
		session.setAttribute("idEvent", null);
		String idEvent=null;
		EventServiceImpl  eventService = new EventServiceImpl();
		Event event=new Event();
		
		idEvent=request.getParameter("updateEvent");
		session.setAttribute("idEvent", idEvent);

		if(idEvent!=null)
		{
			event.setEventId(Integer.parseInt(idEvent));
			try {
				Event eventUpdate=new Event(eventService.selectEvent(event));
				
				listPlace = PlaceService.viewPlace();
				session.setAttribute("LISTPLACE", listPlace);
				
				session.setAttribute("EVENT", eventUpdate);
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		response.sendRedirect("updateEvent.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		try {
			String idEvent=session.getAttribute("idEvent").toString();
			
			Event event=new Event();
			EventServiceImpl  eventService = new EventServiceImpl();
			
			event.setEventId(Integer.parseInt(idEvent));
			event.setName(request.getParameter("eventName"));
			event.setDescription(request.getParameter("description"));
			event.setPlace(Integer.parseInt(request.getParameter("place")));
		
			SimpleDateFormat originalFormat = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date dateInput = null;
			dateInput = originalFormat.parse(request.getParameter("date").toString());
		    event.setDate_event(dateInput);
			event.setStartTime(request.getParameter("startTime"));
			event.setDuration(request.getParameter("duration"));
			event.setEventType(request.getParameter("typeOfEvent"));
			event.setSeatsAvailable(Integer.parseInt(request.getParameter("seats")));
			
			
			if(eventService.updateEvent(event) > 0){
				session.setAttribute("Success", "Successfully Event updated");
				session.setAttribute("ViewSuccess", "YES");
			}else{
				session.setAttribute("Error", "Incorrect Event values");
				response.sendRedirect("updateEvent");
			}
			
			response.sendRedirect("admin");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
