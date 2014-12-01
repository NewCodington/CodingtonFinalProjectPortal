package springcodingtonportal.tests;



import java.sql.SQLException;
import java.text.ParseException;

import javax.naming.NamingException;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springcodingtonportal.model.domain.Event;

import codingtonportal.model.services.EventServiceImpl;


public class EventDAOJUnit extends TestCase{
	EventServiceJDBC event;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		event = new EventServiceJDBC();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Method to get a specific Event from the database.
	 * @throws SQLException
	 * @throws ParseException
	 */
	@Test
	public void testSelectEvent () throws SQLException, ParseException{
		Event events= new Event(2,"Charla", "Explicacion de marmotas", 3, "2 horas", "17 horas", "divulgativo",12,null);
		EventServiceJDBC serviceEvent = new EventServiceJDBC();
		try {
			assertNotNull(serviceEvent.selectEvent(events));						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to view all available events from the database.
	 * @throws ParseException
	 */
	@Test
	public void testviewEvent () throws ParseException{
		EventServiceJDBC serviceEvent = new EventServiceJDBC();
		try {
			try{
				assertNotNull(serviceEvent.viewEvent());
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
	
	/**
	 * Method to search Events by partial names from the database.
	 * @throws SQLException
	 * @throws ParseException
	 */
	@Test
	public void testsearchEvent() throws SQLException, ParseException {				
		EventServiceJDBC serviceEvent = new EventServiceJDBC();
		try {
			assertNotNull(serviceEvent.searchEvent("FRI"));	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to insert an Event in the database.
	 * @throws SQLException
	 * @throws ParseException
	 */
	@Test
	public void testInsertEvent() throws SQLException, ParseException {
		Event events= new Event(001,"Charla", "Explicacion de marmotas", 3, "2 horas", "17 horas", "divulgativo",12, null);
		EventServiceJDBC serviceEvent = new EventServiceJDBC();
		try {
			assertNotNull(serviceEvent.insertEvent(events));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to remove a specific Event from the database.
	 * @throws SQLException
	 */
	@Test
	public void testDeleteEvent() throws SQLException {
		Event events= new Event(001,"Charla", "Explicacion de marmotas", 3, "2 horas", "17 horas", "divulgativo",12, null);
		EventServiceJDBC serviceEvent = new EventServiceJDBC();
		try {
			assertNotNull(serviceEvent.deleteEvent(events.getEventId()));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to update a specific Event from the database.
	 * @throws SQLException
	 * @throws ParseException
	 */
	@Test
	public void testUpdateEvent() throws SQLException, ParseException {
		Event events= new Event(001,"Charla", "Explicacion de marmotas", 3, "2 horas", "17 horas", "divulgativo",12, null);
		EventServiceJDBC serviceEvent = new EventServiceJDBC();
		try {
			assertNotNull(serviceEvent.updateEvent(events));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
