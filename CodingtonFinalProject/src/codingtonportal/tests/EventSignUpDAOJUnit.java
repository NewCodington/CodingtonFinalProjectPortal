package codingtonportal.tests;

import java.io.IOException;
import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import codingtonportal.model.domain.*;

import codingtonportal.model.services.EventSignUpImpl;


public class EventSignUpDAOJUnit extends TestCase {
	EventSignUpImpl EventSign;
	

	@Before
	public void setUp() throws Exception {
		super.setUp();
		EventSign = new EventSignUpImpl();
	
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testregisterForNewEvent() {
		EventSign eventSigns= new EventSign(2,4);
		EventSignUpImpl serviceEventSignUp = new EventSignUpImpl();
		try {
			try {
				assertNotNull(serviceEventSignUp.registerForNewEvent(eventSigns.getIdEvent(),eventSigns.getIdVisitor()));
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
	public void testunregisterForEvent() {
		EventSign eventSigns= new EventSign(4,2);
		EventSignUpImpl serviceEventSignUp = new EventSignUpImpl();
		try {
			try {
				assertNotNull(serviceEventSignUp.unregisterForEvent(eventSigns.getIdVisitor(), eventSigns.getIdEvent()));
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
	public void testUpdateSeatsAvailable() {
		Event events=new Event();
		//2	The Science of Natural Disasters	Earthquakes. Volcanoes. Tornadoes...	2	2014-12-11	17.00 PM	120 min	Science	60
		//EventSign eventSigns = new EventSign();								                                   		
		EventSignUpImpl serviceEventSignUp = new EventSignUpImpl();
		try {
			try {
				assertNotNull(serviceEventSignUp.updateSeatsAvailable(events));
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
	public void testselectEventForVisitor (){
		EventSign eventSigns= new EventSign();
		EventSignUpImpl serviceEventSignUp = new EventSignUpImpl();
		try {
			try{
				assertNotNull(serviceEventSignUp.selectEventForVisitor(eventSigns.getIdVisitor()));
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
	public void testselectVisitorForEvent() {
		EventSign eventSigns = new EventSign();								                                   		
		EventSignUpImpl serviceEventSignUp = new EventSignUpImpl();
		try {
			try {
				assertNotNull(serviceEventSignUp.selectVisitorForEvent(eventSigns.getIdVisitor(),eventSigns.getIdEvent()));
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


