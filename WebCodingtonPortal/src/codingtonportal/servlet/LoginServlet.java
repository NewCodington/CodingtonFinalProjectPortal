package codingtonportal.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import codingtonportal.model.domain.Visitor;
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
		
		if (session.getAttribute("ViewErrorPriv")!= null && session.getAttribute("ViewErrorPriv").toString().equals("YES")) {
			session.setAttribute("ViewErrorPriv", null);
			session.setAttribute("Error", null);
			session.setAttribute("ErrorLogin", null);
			session.setAttribute("Success", null);
			
			response.sendRedirect("login.jsp");
		}
		else {
			if (session.getAttribute("ViewErrorLogin")!= null && session.getAttribute("ViewErrorLogin").toString().equals("YES")) {
				session.setAttribute("ViewErrorLogin", null);
				session.setAttribute("ErrorPriv", null);
				session.setAttribute("Error", null);
				session.setAttribute("Success", null);
				
				response.sendRedirect("login.jsp");
			}
			else {
				if (session.getAttribute("ViewError")!= null && session.getAttribute("ViewError").toString().equals("YES")) {
					session.setAttribute("ViewError", null);
					session.setAttribute("ErrorPriv", null);
					session.setAttribute("ErrorLogin", null);
					session.setAttribute("Success", null);
					
					response.sendRedirect("login.jsp");
				}
				else {
					if(session.getAttribute("ViewSuccess")!= null && session.getAttribute("ViewSuccess").toString().equals("YES")){
						session.setAttribute("ViewSuccess", null);
						session.setAttribute("Error", null);
						session.setAttribute("ErrorPriv", null);
						session.setAttribute("ErrorLogin", null);
						
						response.sendRedirect("login.jsp");
					}
					else {
						session.setAttribute("Error", null);
						session.setAttribute("ErrorPriv", null);
						session.setAttribute("ErrorLogin", null);
						session.setAttribute("Success", null);
						
						if(session.getAttribute("Visitor")!= null) {
							response.sendRedirect("visitor");
						}
						else if (session.getAttribute("Admin")!= null) { 
							response.sendRedirect("admin");
						}
						else
							response.sendRedirect("login.jsp");
					}
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

		try {
			Visitor visitor = new Visitor(request.getParameter("username"), request.getParameter("password"));

			VisitorServiceImpl  visitorService = new VisitorServiceImpl();

			visitor.setIdVisitor(visitorService.loginVisitor(visitor));
				
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
				session.setAttribute("ErrorLogin", "User or password incorrect");
				session.setAttribute("ViewErrorLogin", "YES");
				
				response.sendRedirect("login");
			}
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
