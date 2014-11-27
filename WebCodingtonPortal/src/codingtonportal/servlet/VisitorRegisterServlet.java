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
@WebServlet(description = "Servlet for Regist Visitor", urlPatterns = { "/registerVisitor" })
public class VisitorRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorRegisterServlet() {
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
			response.sendRedirect("registerEvent.jsp");
		}
		else{
			if(session.getAttribute("ViewSuccess")!= null && session.getAttribute("ViewSuccess").toString().equals("YES")){
				response.sendRedirect("login");
			}
			else {
				session.setAttribute("Success", null);
				session.setAttribute("ErrorUser", null);
				session.setAttribute("VisitorInfo", null);
				
				response.sendRedirect("registerVisitor.jsp");
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
			Visitor visitor=new Visitor();
			VisitorServiceImpl  visitorService = new VisitorServiceImpl();
			
			visitor.setUserName(request.getParameter("uname"));
			visitor.setFirstName(request.getParameter("fname"));
			visitor.setLastName(request.getParameter("lname"));
			visitor.setPassword(request.getParameter("pass"));
			visitor.setEmail(request.getParameter("email"));
			visitor.setDni(request.getParameter("dni"));
			visitor.setPhoneNumber(request.getParameter("phone"));
			visitor.setAddress(request.getParameter("adress"));
			visitor.setAdmin(false);
			
			if((visitorService.exitsUsernameVisitor(visitor)) == 0) {
				session.setAttribute("VisitorInfo", visitor);
				session.setAttribute("ErrorUser", "Username already exists");
				response.sendRedirect("registerVisitor.jsp");
			}
			else {
				session.setAttribute("VisitorInfo", null);
				session.setAttribute("ErrorUser", null);
				
				if(visitorService.insertVisitor(visitor) > 0){
					session.setAttribute("Success", "Successfully visitor created");
					session.setAttribute("ViewSuccess", "YES");
				}else{
					session.setAttribute("Error", "Incorrect Visitor values");
					session.setAttribute("ViewSuccess", null);
				}
			
				response.sendRedirect("registerVisitor");	
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
