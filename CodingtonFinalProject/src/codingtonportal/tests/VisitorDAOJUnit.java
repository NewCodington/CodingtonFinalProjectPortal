package codingtonportal.tests;


import java.io.IOException;
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
	public void testinsertVisitor() {
		Visitor visit= new Visitor(1, "Charla2", "dafkj","Explicacion",
				"jim", "45.2", "emai", "9874","12",true);
		try {
			assertTrue(visitor.insertVisitor(visit));
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
		try {
			assertTrue(visitor.loginVisitor(visit.getUserName(),visit.getPassword()));
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
		Visitor visit= new Visitor(12, "Charla", "dafkj","Explicacion", 
				"jim", "45.2", "emai", "9874","12",true);
		try {
			assertTrue(visitor.deleteVisitor(visit));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testupdateInformation() {
		Visitor visit= new Visitor(13, "Pepe", "dafkj","pepe", 
				"jim", "45.2", "emai", "9874","12",true);
		try {
			assertTrue(visitor.updateInformation(visit));
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
		Visitor visit= new Visitor(13, "Charla", "aaaaaa","Explicacion", 
				"jim", "45.2", "emai", "9874","12",true);
		try {
			assertTrue(visitor.updatePassword(visit));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testregisterForNewEvent() {
		Visitor visit= new Visitor(13,11);
		try {
			assertTrue(visitor.registerForNewEvent(visit.getIdVisitor(),visit.getIdEvent()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testunregisterForEvent() {
		Visitor visit= new Visitor(13, 11);
		try {
			assertTrue(visitor.unregisterForEvent(visit.getIdVisitor(),visit.getIdEvent()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*
	@Test
	public void testsearchEvent() {
		Visitor visit= new Visitor(2,1);
		try {
			assertTrue(visitor.searchEvent(visit));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testviewEvent() {
		Visitor visit= new Visitor();
		try {
			assertTrue(visitor.viewEvent(visit));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
