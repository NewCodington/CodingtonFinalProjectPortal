package codingtonportal.tests;


import java.io.IOException;
import java.sql.SQLException;

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
	public void testSelectVisitor (){
		Visitor visit= new Visitor(16, "Charlay", "dafkj","Explicacion","jim", "45.2", "emai", "9874","12",true);		
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			try{
				assertNotNull(serviceVisitor.selectVisitor(visit));	
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
	

	@Test
	public void testviewVisitor (){
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			try{
				assertNotNull(serviceVisitor.viewVisitor());	
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
	
	
	@Test
	public void testloginVisitor() {
		Visitor visit= new Visitor("Charla","dafkj");
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			try{
			assertNotNull(serviceVisitor.loginVisitor(visit));
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
	
	
	@Test
	public void testinsertVisitor() {
		Visitor visit= new Visitor( "Charlie", "dafkj","Explicacion",
				"jim", "45.2", "emai", "9874","12",true);
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			try{
			assertNotNull(serviceVisitor.insertVisitor(visit));
			} catch (SQLException e){
				//TODO Auto-generated catch block
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

	
	@Test
	public void testupdateVisitor() {
		Visitor visit= new Visitor("Pepe", "dafkj","pepe", 
				"jim", "45.2", "emai", "9874","12",true);
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			try{
			assertNotNull(serviceVisitor.updateVisitor(visit));
			} catch (SQLException e){
				//TODO Auto-generated catch block
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
	
	
	@Test
	public void testupdatePassword() {
		Visitor visit= new Visitor("PeterP","peterp6");
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			try{
			assertNotNull(serviceVisitor.updatePassword(visit));
			} catch (SQLException e){
				//TODO Auto-generated catch block
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
	

	@Test
	public void testdeleteVisitor() {
		Visitor visit= new Visitor(6, "Charla2", "dafkj","Explicacion", 
				"jim", "45.2", "emai", "9874","12",true);
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			try{
			assertNotNull(serviceVisitor.deleteVisitor(visit));
			} catch (SQLException e){
				//TODO Auto-generated catch block
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

	
	@Test
	public void testsearchEvent (){
		
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			try{
				assertNotNull(serviceVisitor.searchEvent("FRI"));	
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
	
	
	@Test
	public void testviewEvent (){
		VisitorServiceImpl serviceVisitor = new VisitorServiceImpl();
		try {
			try{
				assertNotNull(serviceVisitor.viewEvent());	
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
	
	
	@Test
	public void testisAdmin (){
		
		Visitor visit=new Visitor("admin","admin","Peter","Pan","08.512.254-T","Peter.Pan12@gmail.com","6945269854","Puy Chemin,12,New Codington", false);
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
