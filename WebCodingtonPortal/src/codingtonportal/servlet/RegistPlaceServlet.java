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
import codingtonportal.model.domain.Place;
import codingtonportal.model.services.EventServiceImpl;



/**
 * Servlet implementation class SigninServlet
 */
@WebServlet(description = "Servlet for Regist Place", urlPatterns = { "/RegistPlaceServlet" })
public class RegistPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistPlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/registPlace.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Place place=new Place();
		
		PlaceServiceImpl  eventService = new EventServiceImpl();
		
		place.setName(request.getParameter("eventName"));
		place.setDescription(request.getParameter("description"));
		place.setPlace(Integer.parseInt(request.getParameter("place")));
		
		place.setDuration(request.getParameter("duration"));
		place.setEventType(request.getParameter("typeOfEvent"));
		place.setSeatsAvailable(Integer.parseInt(request.getParameter("seats")));
		
		place.setStartTime("2 horas");//Lo cojo manual porque falta el campo en el form
		
		//Falta incluir la fecha y el tiempo que dura

		
		try {
			if(eventService.insertEvent(event)){
				
					RequestDispatcher dispatcher=request.getRequestDispatcher("/registEvent.jsp?msg=Evento creado con éxito");
					dispatcher.forward(request, response);

			}else{
				RequestDispatcher dispatcher=request.getRequestDispatcher("/registEvent.jsp?msg=Incorrect");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
