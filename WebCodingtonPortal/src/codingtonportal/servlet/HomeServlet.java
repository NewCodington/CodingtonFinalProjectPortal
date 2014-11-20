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
import codingtonportal.model.services.EventSignUpImpl;



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
		EventSignUpImpl eventSignUp=new EventSignUpImpl();
		
		HttpSession session=request.getSession();
		ArrayList<Event> eventsList=null;
		
		
		//Params of jsp for get
		String idEv=null;
		idEv=request.getParameter("idEv");
		
		String idVi=null;
		idVi=request.getParameter("idVi");
		
		String idVisitor=null;
		idVisitor=request.getParameter("idVisitor");
		
		
		
		try {
			eventsList = eventService.viewEvent();
		
		
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		session.setAttribute("EVENTLIST", eventsList);
		
		
		ArrayList<Integer> listIdEvent = null;
		
		ArrayList<Event> eventsRegisterList = null;
		
		try {
			
			listIdEvent = eventSignUp.selectEventForVisitor(Integer.parseInt(idVisitor));
		
		
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(listIdEvent != null){
			
			 eventsRegisterList=new ArrayList <Event>();
			for (Integer element : listIdEvent){
				Event data = new Event();
				data.setEventId(element);
				try {
					
					eventsRegisterList.add(eventService.selectEvent(data));
				
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		session.setAttribute("EVENTREGISTERLIST", eventsRegisterList);
		
		
		
		
		//si vienen los parametros meto el nuevo evento a ese visitor
		if(idVi!=null && idEv!=null)
		{
		
			try {
			
				eventSignUp.registerForNewEvent(Integer.parseInt(idVi), Integer.parseInt(idEv));
				
			
			
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}

		
		try {
			eventsList = eventService.viewEvent();
			session.setAttribute("EVENTLIST", eventsList);
			
			//RequestDispatcher dispatcher=request.getRequestDispatcher("/home.jsp");
			//dispatcher.forward(request, response);
			
			
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
