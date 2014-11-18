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
		EventSign eventSigns= new EventSign(1,4);
		try {
			assertTrue(EventSign.registerForNewEvent(eventSigns.getIdVisitor(), eventSigns.getIdEvent()));
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
		
		EventSign eventSigns=new EventSign();
		
		try {
			assertTrue(EventSign.searchEvent(eventSigns.getName()));
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
		EventSign eventSigns=new EventSign();
		try {
			assertTrue(EventSign.viewEvent(eventSigns.getName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}


