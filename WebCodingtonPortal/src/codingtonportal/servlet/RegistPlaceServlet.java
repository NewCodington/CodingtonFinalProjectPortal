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
import codingtonportal.model.services.PlaceServiceImpl;



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
		PlaceServiceImpl  placeService = new PlaceServiceImpl();
		
		
		
		
		
		place.setName(request.getParameter("placeName"));
		place.setDescription(request.getParameter("description"));
		place.setRegion(request.getParameter("region"));
		
		//place.setImage(request.getParameter("image"));
		
		
		place.setAddress(request.getParameter("address"));
		place.setTypePlace(Integer.parseInt(request.getParameter("typePlace")));
		

		
		//Falta incluir la fecha y el tiempo que dura

		
		try {
			if(placeService.insertPlace(place)){
				
					RequestDispatcher dispatcher=request.getRequestDispatcher("/registPlace.jsp?msg=Evento creado con éxito");
					dispatcher.forward(request, response);

			}else{
				RequestDispatcher dispatcher=request.getRequestDispatcher("/registPlace.jsp?msg=Incorrect");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
