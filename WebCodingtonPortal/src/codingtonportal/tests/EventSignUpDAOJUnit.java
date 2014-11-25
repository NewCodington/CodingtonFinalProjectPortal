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

	/**
	 * Method to register a Visitor into an Event unless the Visitor is already registered in that Event.
	 * @throws SQLException
	 */
	@Test
	public void testregisterForNewEvent() throws SQLException {
		EventSign eventSigns= new EventSign(3,4);
		EventSignUpImpl serviceEventSignUp = new EventSignUpImpl();
		try {
			assertNotNull(serviceEventSignUp.registerForNewEvent(eventSigns.getIdVisitor(),eventSigns.getIdEvent()));		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to unregister a Visitor from an Event if the Visitor is registered in that Event.
	 * @throws SQLException
	 */
	@Test
	public void testunregisterForEvent() throws SQLException {
		EventSign eventSigns= new EventSign(2,4);
		EventSignUpImpl serviceEventSignUp = new EventSignUpImpl();
		try {
			assertNotNull(serviceEventSignUp.unregisterForEvent(eventSigns.getIdVisitor(), eventSigns.getIdEvent()));			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to update the seats available in an specified Event when a visitor is unregistered from that Event.
	 * @throws SQLException
	 */
	@Test
	public void testincrementSeats() throws SQLException {
		EventSign eventSigns= new EventSign(2,4);
		EventSignUpImpl serviceEventSignUp = new EventSignUpImpl();
		try {
			assertNotNull(serviceEventSignUp.incrementSeats(eventSigns.getIdEvent()));			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to update the seats available in an specified Event when a visitor is registered in that Event.
	 * @throws SQLException
	 */
	@Test
	public void testdecrementSeats() throws SQLException {
		EventSign eventSigns= new EventSign(2,4);
		EventSignUpImpl serviceEventSignUp = new EventSignUpImpl();
		try {			
			assertNotNull(serviceEventSignUp.decrementSeats(eventSigns.getIdEvent()));			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to get all the Ids of Events in which each visitor has registered.

	 */
	@Test	
	public void testselectEventForVisitor (){
		EventSign eventSigns= new EventSign(3,4);
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
	
	/**
	 * Method to obtain if the Event has registered for a Visitor.
	 */
	@Test
	public void testselectVisitorForEvent() {
		EventSign eventSigns = new EventSign(3,4);								                                   		
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


