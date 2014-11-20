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
import codingtonportal.model.domain.Visitor;
import codingtonportal.model.services.EventServiceImpl;
import codingtonportal.model.services.EventSignUpImpl;
import codingtonportal.model.services.VisitorServiceImpl;


/**
 * Servlet implementation class SigninServlet
 */
@WebServlet(description = "Servlet for Log in to website", urlPatterns = { "/SigninServlet" })
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Signin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Visitor visitor = new Visitor(request.getParameter("username"), request.getParameter("password"));

		VisitorServiceImpl  visitorService = new VisitorServiceImpl();
		Integer idVisitor = 0;
		try {
			if((idVisitor = visitorService.loginVisitor(visitor))>=0){
				if(visitorService.isAdmin(visitor)){

					RequestDispatcher dispatcher=request.getRequestDispatcher("/admin.jsp");
					dispatcher.forward(request, response);
					
				}else{
					EventServiceImpl eventService=new EventServiceImpl();
					HttpSession session=request.getSession();
					ArrayList<Event> eventsList;
					eventsList = eventService.viewEvent();
					session.setAttribute("EVENTLIST", eventsList);
					
					EventSignUpImpl eventSignUp=new EventSignUpImpl();
					
					eventsRegisterList = eventSignUp.selectEventForVisitor(idVisitor);
					
					ArrayList<Event> eventsRegisterList;
					eventsRegisterList = eventSignUp.selectEventForVisitor(idVisitor);
					session.setAttribute("EVENTLIST", eventsRegisterList);
					
					RequestDispatcher dispatcher=request.getRequestDispatcher("/home.jsp");
					dispatcher.forward(request, response);
				}
				

			}else{
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Signin.jsp?msg=User or password incorrect");
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
