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
@WebServlet(description = "Servlet for Log in to website", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("Error")!= null && !session.getAttribute("Error").toString().equals("")){
			response.sendRedirect("login.jsp");
		}
		else{
			if(session.getAttribute("Visitor")!= null)
				response.sendRedirect("visitor");
			else {
				response.sendRedirect("admin");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		Visitor visitor = new Visitor(request.getParameter("username"), request.getParameter("password"));

		VisitorServiceImpl  visitorService = new VisitorServiceImpl();
		
		try {
			visitor.setIdVisitor(visitorService.loginVisitor(visitor));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if ((visitor.getIdVisitor()) >= 0) {
				if(visitorService.isAdmin(visitor)){

					session.setAttribute("idAdmin",visitor.getIdVisitor());
					session.setAttribute("Admin", visitor.getUserName());
					
					response.sendRedirect("admin");
					
				}else{
					session.setAttribute("idVisitor",visitor.getIdVisitor());
					session.setAttribute("Visitor",visitor.getUserName());

					response.sendRedirect("visitor");
				}
				

			}else{
				session.setAttribute("Error", "User or password incorrect");
				response.sendRedirect("login");
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
