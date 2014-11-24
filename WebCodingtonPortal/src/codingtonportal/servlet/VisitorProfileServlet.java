package codingtonportal.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
		session.setAttribute("ErrorLogin", null);
		
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
		
		try {
			
			//si vienen los parametros meto el nuevo evento a ese visitor
			if(register!=null){ 
				if(eventSignUp.registerForNewEvent(Integer.parseInt(idVisitor), Integer.parseInt(register)) == null)
					session.setAttribute("Error", "You're already registered on this event");
				else
					session.setAttribute("Error", null);
			}
			if(unregister!=null){ 
				eventSignUp.unregisterForEvent(Integer.parseInt(idVisitor), Integer.parseInt(unregister));
				session.setAttribute("Error", null);
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
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		
		

		//RequestDispatcher dispatcher=request.getRequestDispatcher("/home.jsp?msg=Evento creado con �xito");
		//dispatcher.forward(request, response);


	}

}
