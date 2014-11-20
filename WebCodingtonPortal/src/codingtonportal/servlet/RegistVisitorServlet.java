package codingtonportal.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codingtonportal.model.domain.Visitor;
import codingtonportal.model.services.VisitorServiceImpl;


/**
 * Servlet implementation class SigninServlet
 */
@WebServlet(description = "Servlet for Regist Visitor", urlPatterns = { "/RegistVisitorServlet" })
public class RegistVisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistVisitorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Visitor visitor=new Visitor();
		VisitorServiceImpl  visitorService = new VisitorServiceImpl();
		
		visitor.setFirstName(request.getParameter("fname"));
		visitor.setLastName(request.getParameter("lname"));
		visitor.setUserName(request.getParameter("uname"));
		visitor.setPassword(request.getParameter("pass"));
		visitor.setEmail(request.getParameter("email"));
		visitor.setDni(request.getParameter("dni"));
		visitor.setPhoneNumber(request.getParameter("phone"));
		visitor.setAddress(request.getParameter("adress"));
		visitor.setAdmin(false);

		//= new Visitor(request.getParameter("fname"),request.getParameter("lname"),request.getParameter("fname"),);
	//dcvn
		
		try {
			if(visitorService.insertVisitor(visitor)){
				
					RequestDispatcher dispatcher=request.getRequestDispatcher("/Signin.jsp");
					dispatcher.forward(request, response);

			}else{
				RequestDispatcher dispatcher=request.getRequestDispatcher("/regist.jsp?msg=Incorrect");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}

}
