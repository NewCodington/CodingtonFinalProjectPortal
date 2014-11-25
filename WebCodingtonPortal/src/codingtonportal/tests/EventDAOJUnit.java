package codingtonportal.tests;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import codingtonportal.model.domain.Event;
import codingtonportal.model.services.EventServiceImpl;

public class EventDAOJUnit extends TestCase{
	EventServiceImpl event;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		event = new EventServiceImpl();
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
		EventServiceImpl serviceEvent = new EventServiceImpl();
		try {
			assertNotNull(serviceEvent.selectEvent(events));						
		} catch (IOException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		EventServiceImpl serviceEvent = new EventServiceImpl();
		try {
			try{
				assertNotNull(serviceEvent.viewEvent());
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
	 * Method to insert an Event in the database.
	 * @throws SQLException
	 * @throws ParseException
	 */
	@Test
	public void testInsertEvent() throws SQLException, ParseException {
		Event events= new Event(001,"Charla", "Explicacion de marmotas", 3, "2 horas", "17 horas", "divulgativo",12, null);
		EventServiceImpl serviceEvent = new EventServiceImpl();
		try {
			assertNotNull(serviceEvent.insertEvent(events));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		EventServiceImpl serviceEvent = new EventServiceImpl();
		try {
			assertNotNull(serviceEvent.deleteEvent(events.getEventId()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		EventServiceImpl serviceEvent = new EventServiceImpl();
		try {
			assertNotNull(serviceEvent.updateEvent(events));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
