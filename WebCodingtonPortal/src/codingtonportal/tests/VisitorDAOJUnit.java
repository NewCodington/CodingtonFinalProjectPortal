package codingtonportal.tests;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import codingtonportal.model.domain.Visitor;
import codingtonportal.model.services.VisitorServiceImpl;

public class VisitorDAOJUnit extends TestCase {
	VisitorServiceImpl visitor;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		visitor = new VisitorServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testSelectVisitor () throws SQLException{
		Visitor visit= new Visitor(23, "Charlay", "dafkj","Explicacion","jim", "45.2", "emai", "9874","12",true);		
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			assertNotNull(serviceVisitor.selectVisitor(visit));
		} catch (IOException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testviewVisitor () throws SQLException{				
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			assertNotNull(serviceVisitor.viewVisitor());			
		} catch (IOException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testloginVisitor() throws SQLException {
		Visitor visit= new Visitor(16, "Charlay", "dafkj","Explicacion","jim", "45.2", "emai", "9874","12",true);		
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			assertNotNull(serviceVisitor.loginVisitor(visit));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testinsertVisitor() throws SQLException {
		Visitor visit= new Visitor(16, "Carlos", "dafkj","Explicacion","jim", "45.2", "emai", "9874","12",true);		
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			assertNotNull(serviceVisitor.insertVisitor(visit));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testupdateVisitor() throws SQLException {
		Visitor visit= new Visitor(16, "Charly", "dafkj","Carlos Perez","jim", "45.2", "Soy muy guapo", "9874","12",true);		
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			assertNotNull(serviceVisitor.updateVisitor(visit));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testupdatePassword() throws SQLException {
		Visitor visit= new Visitor(16, "Charly", "facilisimo","Carlos Perez","jim", "45.2", "Soy muy guapo", "9874","12",true);		
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {			
			assertNotNull(serviceVisitor.updatePassword(visit));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testdeleteVisitor() throws SQLException {
		Visitor visit= new Visitor(16, "Charly", "facilisimo","Carlos Perez","jim", "45.2", "Soy muy guapo", "9874","12",true);		
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			assertNotNull(serviceVisitor.deleteVisitor(visit));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testsearchEvent() throws SQLException, ParseException {				
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			assertNotNull(serviceVisitor.searchEvent("FRI"));	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testviewEvent () throws SQLException, ParseException{				
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {			
			assertNotNull(serviceVisitor.viewEvent());			
		} catch (IOException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
	}

	@Test
	public void testisAdmin (){
		
		Visitor visit=new Visitor("Charly","dafkj","Peter","Pan","08.512.254-T","Peter.Pan12@gmail.com","6945269854","Puy Chemin,12,New Codington", false);
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			try{
				assertTrue(serviceVisitor.isAdmin(visit));	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		} catch (IOException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
	}	
}	