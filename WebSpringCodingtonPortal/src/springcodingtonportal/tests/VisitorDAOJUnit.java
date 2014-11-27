package springcodingtonportal.tests;



import java.sql.SQLException;

import javax.naming.NamingException;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springcodingtonportal.model.domain.Visitor;
import codingtonportal.model.services.VisitorServiceImpl;

public class VisitorDAOJUnit extends TestCase {
	VisitorServiceJDBC visitor;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		visitor = new VisitorServiceJDBC();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Method to get an specific Visitor from the database.
	 * @throws SQLException
	 */
	@Test
	public void testSelectVisitor () throws SQLException{
		Visitor visit= new Visitor(23, "Charlay", "dafkj","Explicacion","jim", "45.2", "emai", "9874","12",true);		
		VisitorServiceJDBC serviceVisitor = new VisitorServiceJDBC();
		try {
			assertNotNull(serviceVisitor.selectVisitor(visit));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to view all Visitors from the database.
	 * @throws SQLException
	 */
	@Test
	public void testviewVisitor () throws SQLException{				
		VisitorServiceJDBC serviceVisitor = new VisitorServiceJDBC();
		try {
			assertNotNull(serviceVisitor.viewVisitor());			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method by which a Visitor logs into the application.
	 * @throws SQLException
	 */
	@Test
	public void testloginVisitor() throws SQLException {
		Visitor visit= new Visitor(16, "Charlay", "dafkj","Explicacion","jim", "45.2", "emai", "9874","12",true);		
		VisitorServiceJDBC serviceVisitor = new VisitorServiceJDBC();
		try {
			assertNotNull(serviceVisitor.loginVisitor(visit));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to insert a Visitor into the database.
	 * @throws SQLException
	 */
	@Test
	public void testinsertVisitor() throws SQLException {
		Visitor visit= new Visitor(16, "Carlos", "dafkj","Explicacion","jim", "45.2", "emai", "9874","12",true);		
		VisitorServiceJDBC serviceVisitor = new VisitorServiceJDBC();
		try {
			assertNotNull(serviceVisitor.insertVisitor(visit));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to update the personal information from a Visitor in the database.
	 * @throws SQLException
	 */
	@Test
	public void testupdateVisitor() throws SQLException {
		Visitor visit= new Visitor(16, "Charly", "dafkj","Carlos Perez","jim", "45.2", "Soy muy guapo", "9874","12",true);		
		VisitorServiceJDBC serviceVisitor = new VisitorServiceJDBC();
		try {
			assertNotNull(serviceVisitor.updateVisitor(visit));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method by which a visitor updated his password.
	 * @throws SQLException
	 */
	@Test
	public void testupdatePassword() throws SQLException {
		Visitor visit= new Visitor(16, "Charly", "facilisimo","Carlos Perez","jim", "45.2", "Soy muy guapo", "9874","12",true);		
		VisitorServiceJDBC serviceVisitor = new VisitorServiceJDBC();
		try {			
			assertNotNull(serviceVisitor.updatePassword(visit));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to remove a Visitor from the database.
	 * @throws SQLException
	 */
	@Test
	public void testdeleteVisitor() throws SQLException {
		Visitor visit= new Visitor(16, "Charly", "facilisimo","Carlos Perez","jim", "45.2", "Soy muy guapo", "9874","12",true);		
		VisitorServiceJDBC serviceVisitor = new VisitorServiceJDBC();
		try {
			assertNotNull(serviceVisitor.deleteVisitor(visit));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to check if the Visitor is the administrator application.
	 */
	@Test
	public void testisAdmin (){
		
		Visitor visit=new Visitor("Charly","dafkj","Peter","Pan","08.512.254-T","Peter.Pan12@gmail.com","6945269854","Puy Chemin,12,New Codington", false);
		VisitorServiceJDBC serviceVisitor = new VisitorServiceJDBC();
		try {
			try{
				assertTrue(serviceVisitor.isAdmin(visit));	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
	}	
}	