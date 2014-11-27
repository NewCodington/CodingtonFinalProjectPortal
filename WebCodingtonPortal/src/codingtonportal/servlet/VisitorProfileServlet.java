package codingtonportal.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.naming.NamingException;
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
 * Servlet implementation class SigninServlet
 */
@WebServlet(description = "Servlet for select Event", urlPatterns = { "/visitor" })
public class VisitorProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		
		try {		
			ArrayList<Integer> listIdEvent = null;
			ArrayList<Event> eventsRegisterList = null;
			ArrayList<Event> eventsList=null;
			
			EventServiceImpl eventService=new EventServiceImpl();
			EventSignUpImpl eventSignUp=new EventSignUpImpl();
			
			//Params of jsp for get
			String register=null;
			register=request.getParameter("register");
			
			String unregister=null;
			unregister=request.getParameter("unregister");
			
			String idVisitor=null;
			idVisitor=session.getAttribute("idVisitor").toString();
			
			//si vienen los parametros meto el nuevo evento a ese visitor
			if(register!=null){ 
				if(eventSignUp.registerForNewEvent(Integer.parseInt(idVisitor), Integer.parseInt(register)) == null) {
					session.setAttribute("Error", "You're already registered in this event");
					session.setAttribute("ViewError", "YES");
				}
				else {
					session.setAttribute("Success", "Succesfully registered in this event");
					session.setAttribute("ViewSuccess", "YES");
				}
			}
			if(unregister!=null){ 
				if(eventSignUp.unregisterForEvent(Integer.parseInt(idVisitor), Integer.parseInt(unregister)) == null) {
					session.setAttribute("Error", "You're already registered in this event");
					session.setAttribute("ViewError", "YES");
				}
				else {
					session.setAttribute("Success", "Succesfully unregistered in this event");
					session.setAttribute("ViewSuccess", "YES");
				}
			}
			
			listIdEvent = eventSignUp.selectEventForVisitor(Integer.parseInt(idVisitor));
		
			if(listIdEvent != null){
				eventsRegisterList = new ArrayList <Event>();
				
				for (Integer element : listIdEvent){
					Event data = new Event();
					data.setEventId(element);
					eventsRegisterList.add(eventService.selectEvent(data));
				}
				
			}
		
			eventsList = eventService.viewEvent();
			
			session.setAttribute("EVENTREGISTERLIST", eventsRegisterList);
			session.setAttribute("EVENTLIST", eventsList);
			
			
			if (session.getAttribute("ViewErrorPriv")!= null && session.getAttribute("ViewErrorPriv").toString().equals("YES")) {
				session.setAttribute("ViewErrorPriv", null);
				session.setAttribute("Error", null);
				session.setAttribute("Success", null);
			}
			else {	
				if(session.getAttribute("ViewSuccess")!=null && session.getAttribute("ViewSuccess").toString().equals("YES")) {
					session.setAttribute("ViewSuccess", null);
					session.setAttribute("Error", null);
					session.setAttribute("ErrorPriv", null);
				}
				else {
					if(session.getAttribute("ViewError")!=null && session.getAttribute("ViewError").toString().equals("YES")) {
						session.setAttribute("ViewError", null);
						session.setAttribute("Success", null);
						session.setAttribute("ErrorPriv", null);
					}
					else { 
						session.setAttribute("Error", null);
						session.setAttribute("ErrorPriv", null);
						session.setAttribute("Success", null);
					}
				}
			}
			
			response.sendRedirect("profileVisitor.jsp");
			
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session=request.getSession();
		
		String search=null;
		search=request.getParameter("search");
		
		if(session.getAttribute("ViewSuccess")!=null && session.getAttribute("ViewSuccess").toString().equals("YES")) {
			session.setAttribute("ViewSuccess", null);
		}
		else {
			session.setAttribute("Success", null);
			session.setAttribute("Error", null);
		}
		
		ArrayList<Event> eventsList=null;
		EventServiceImpl eventService=new EventServiceImpl();
		
		try {
			
			eventsList = eventService.searchEvent(search);
			
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
		
		session.setAttribute("EVENTLIST", eventsList);
		response.sendRedirect("profileVisitor.jsp");
	}

}
