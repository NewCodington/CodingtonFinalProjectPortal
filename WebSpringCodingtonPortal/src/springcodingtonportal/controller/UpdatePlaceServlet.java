package springcodingtonportal.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import springcodingtonportal.model.domain.Place;
import springcodingtonportal.model.domain.TypePlace;



import codingtonportal.model.services.PlaceServiceImpl;
import codingtonportal.model.services.TypePlaceServiceImpl;




/**
 * Servlet implementation class SigninServlet
 */
@WebServlet(description = "Servlet for Regist Event", urlPatterns = { "/updatePlace" })
public class UpdatePlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		ArrayList<TypePlace> listTypePlace = null;
		TypePlaceServiceImpl typePlaceService=new TypePlaceServiceImpl();
		
		String idPlace=null;
		Place place=new Place();
		PlaceServiceImpl  placeService = new PlaceServiceImpl();
		
		idPlace=request.getParameter("updatePlace");
		session.setAttribute("idPlace", idPlace);
		
		if(idPlace!=null)
		{
			place.setIdPlace(Integer.parseInt(idPlace));
			try {
				Place placeUpdate=new Place(placeService.selectPlace(place));
				listTypePlace = typePlaceService.viewTypePlace();
				
				session.setAttribute("LISTTYPEPLACE", listTypePlace);
				session.setAttribute("PLACE", placeUpdate);
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		response.sendRedirect("updatePlace.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String idPlace=null;		
		
		try {
			Place place=new Place();
			PlaceServiceImpl  placeService = new PlaceServiceImpl();
			
			idPlace=(String) session.getAttribute("idPlace");
			place.setIdPlace(Integer.parseInt(idPlace));
			place.setName(request.getParameter("placeName"));
			place.setDescription(request.getParameter("description"));		
			//place.setImage(request.getParameter("image"));
			place.setAddress(request.getParameter("address"));
			place.setTypePlace(Integer.parseInt(request.getParameter("typePlace")));
			
			if(placeService.updatePlace(place) > 0){
				session.setAttribute("Success", "Successfully Event updated");
				session.setAttribute("ViewSuccess", "YES");
			}else{
				session.setAttribute("Error", "Incorrect Place values");
				response.sendRedirect("updatePlace");
			}
			
			response.sendRedirect("admin");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
