package codingtonportal.tests;

import java.io.IOException;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import codingtonportal.model.domain.*;

import codingtonportal.model.services.EventSignUpImpl;


public class EventSignUpDAOJUnit extends TestCase {
	EventSignUpImpl EventSign;
	private EventSign eventSigns;
	private EventSign eventSigns2;
	

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
		EventSign eventSigns= new EventSign();
		try {
			assertTrue(EventSign.registerForNewEvent(eventSigns.getIdVisitor(),eventSigns.getIdEvent()));
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
		EventSign eventSigns= new EventSign();
		try {
			assertTrue(EventSign.unregisterForEvent( eventSigns.getIdVisitor(), eventSigns.getIdEvent()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testsearchEvent() {
		setEventSigns2(new EventSign());
		try {
			assertTrue(EventSign.searchEvent("jeeg"));
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
		setEventSigns(new EventSign());
		try {
			assertTrue(EventSign.viewEvent("jeeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public EventSign getEventSigns() {
		return eventSigns;
	}

	public void setEventSigns(EventSign eventSigns) {
		this.eventSigns = eventSigns;
	}

	public EventSign getEventSigns2() {
		return eventSigns2;
	}

	public void setEventSigns2(EventSign eventSigns2) {
		this.eventSigns2 = eventSigns2;
	}
}


