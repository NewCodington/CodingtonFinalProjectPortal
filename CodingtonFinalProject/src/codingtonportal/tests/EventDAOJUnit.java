package codingtonportal.tests;


import java.io.IOException;
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

	@Test
	public void testInsertEvent() {
	    Event events= new Event(001,"Charla", "Explicacion de marmotas", 3, "2 horas", "17 horas", "divulgativo",12);
		try {
			assertTrue(event.insertEvent(events));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateEvent() {
		Event events= new Event(9, "Charla", "Explicacion de pelicanos", 3, "2 horas", "17 horas", "divulgativo",15);
		try {
			assertTrue(event.updateEvent(events));
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
	public void testUpdateSeatsAvailable() {
		Event events= new Event(8, "Charla", "Explicacion de pelicanos", 3, "2 horas", "17 horas", "divulgativo",125);
		try {
			assertTrue(event.updateSeatsAvailable(events));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	*/
	
	@Test
	public void testDeleteEvent() {
		Event events= new Event(8, "Charla", "Explicacion de marmotas", 3, "2 horas", "17 horas", "divulgativo",12);
		try {
			assertTrue(event.deleteEvent(events));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
