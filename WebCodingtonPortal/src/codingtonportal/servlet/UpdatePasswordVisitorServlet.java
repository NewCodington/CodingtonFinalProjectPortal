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
@WebServlet(description = "Servlet for Update Password Visitor", urlPatterns = { "/updatePasswordVisitor" })
public class UpdatePasswordVisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordVisitorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		
		VisitorServiceImpl  visitorService = new VisitorServiceImpl();
		Visitor visitor=new Visitor();
		
		
		String idVisitor=null;
		idVisitor=session.getAttribute("idVisitor").toString();

		if(idVisitor!=null)
		{
			visitor.setIdVisitor(Integer.parseInt(idVisitor));
			try {
				Visitor visitorUpdate=new Visitor(visitorService.selectVisitor(visitor));
				
				session.setAttribute("VISITOR", visitorUpdate);
			
			
			
			
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
		
		response.sendRedirect("updatePasswordVisitor.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		String idVisitor=null;
		idVisitor=session.getAttribute("idVisitor").toString();
		
		
		
		Visitor visitor=new Visitor();
	
		
		VisitorServiceImpl  visitorService = new VisitorServiceImpl();
		
		
		
		visitor.setIdVisitor(Integer.parseInt(idVisitor));
		visitor.setPassword(request.getParameter("pass"));
	
		
		
		try {
			if(visitorService.updatePassword(visitor) > 0){
				session.setAttribute("Success", "Successfully Visitor Password updated");
				session.setAttribute("ViewSuccess", "YES");
			}else{
				session.setAttribute("Error", "Incorrect Visitor values");
				response.sendRedirect("updateVisitor");
			}
			
			response.sendRedirect("visitor");
			
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
