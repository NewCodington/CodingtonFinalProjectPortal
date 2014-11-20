package codingtonportal.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codingtonportal.model.domain.Event;
import codingtonportal.model.services.EventServiceImpl;



/**
 * Servlet implementation class SigninServlet
 */
@WebServlet(description = "Servlet for Regist Event", urlPatterns = { "/RegistEventServlet" })
public class RegistEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/registEvent.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Event event=new Event();
		
		EventServiceImpl  eventService = new EventServiceImpl();
		
		event.setName(request.getParameter("eventName"));
		event.setDescription(request.getParameter("description"));
		event.setPlace(Integer.parseInt(request.getParameter("place")));
		
		event.setDuration(request.getParameter("duration"));
		event.setEventType(request.getParameter("typeOfEvent"));
		event.setSeatsAvailable(Integer.parseInt(request.getParameter("seats")));
		
		event.setStartTime("2 horas");//Lo cojo manual porque falta el campo en el form
		
		//Falta incluir la fecha y el tiempo que dura

		
		try {
			if(eventService.insertEvent(event) > 0){
				
					RequestDispatcher dispatcher=request.getRequestDispatcher("/registEvent.jsp?msg=Evento creado con éxito");
					dispatcher.forward(request, response);

			}else{
				RequestDispatcher dispatcher=request.getRequestDispatcher("/registEvent.jsp?msg=Incorrect");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
