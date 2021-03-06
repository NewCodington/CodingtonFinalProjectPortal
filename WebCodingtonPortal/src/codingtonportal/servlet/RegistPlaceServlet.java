package codingtonportal.servlet;

import java.io.File;
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

import codingtonportal.model.domain.Place;
import codingtonportal.model.domain.TypePlace;
import codingtonportal.model.services.PlaceServiceImpl;
import codingtonportal.model.services.TypePlaceServiceImpl;
import codingtonportal.utils.ImageConversion;



/**
 * Servlet implementation class SigninServlet
 */
@WebServlet(description = "Servlet for Regist Place", urlPatterns = { "/registerPlace" })
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
		HttpSession session = request.getSession();
		ArrayList<TypePlace> listTypePlace = null;
		TypePlaceServiceImpl typePlaceService=new TypePlaceServiceImpl();
		
		if(session.getAttribute("Error")!= null && !session.getAttribute("Error").toString().equals(""))
		{
			response.sendRedirect("registerPlace.jsp");
		}
		else
		{
			if(session.getAttribute("ViewSuccess")!= null && session.getAttribute("ViewSuccess").toString().equals("YES")){
				session.setAttribute("Error", null);
				
				response.sendRedirect("admin");
			}
			else {
				session.setAttribute("Error", null);
				session.setAttribute("Success", null);
				
				try {
					listTypePlace = typePlaceService.viewTypePlace();
					
					session.setAttribute("LISTTYPEPLACE", listTypePlace);
					response.sendRedirect("registerPlace.jsp");
					
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}				
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		Place place=new Place();
		PlaceServiceImpl  placeService = new PlaceServiceImpl();
		ImageConversion nev= new ImageConversion();
	
		try {
			nev.insertImage_Page(request, response);
			//place = nev.insertImage(request, response);
			/*if(placeService.insertPlace(place) > 0){
				session.setAttribute("Success", "Successfully Place created ");
				session.setAttribute("ViewSuccess", "YES");
			}else{
				session.setAttribute("Error", "Incorrect Place values");
			}*/
			//System.out.println(nev.showImage());
		
			nev.showImage();
			response.sendRedirect("registerPlace");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (SQLException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}*/
						 
	}
}
