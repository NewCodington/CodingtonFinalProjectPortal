package codingtonportal.tests;


import java.io.IOException;
//import java.sql.Date;
import java.sql.SQLException;


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
	public void testSelectEvent (){
		Event events= new Event(2,"Charla", "Explicacion de marmotas", 3, "2 horas", "17 horas", "divulgativo",12,null);
		EventServiceImpl serviceEvent = new EventServiceImpl();
		try {
			try{
				assertNotNull(serviceEvent.selectEvent(events));
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
	
	
	@Test
	public void testInsertEvent() {
	    Event events= new Event(001,"Charla", "Explicacion de marmotas", 3, "2 horas", "17 horas", "divulgativo",12, null);
		EventServiceImpl serviceEvent = new EventServiceImpl();
		try {
			try {
				assertNotNull(serviceEvent.insertEvent(events));
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
	public void testDeleteEvent() {
		Event events= new Event(001,"Charla", "Explicacion de marmotas", 3, "2 horas", "17 horas", "divulgativo",12, null);
		EventServiceImpl serviceEvent = new EventServiceImpl();
		try {
			try {
				assertNotNull(serviceEvent.deleteEvent(events));
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
	public void testUpdateEvent() {
		Event events= new Event(001,"Charla", "Explicacion de marmotas", 3, "2 horas", "17 horas", "divulgativo",12, null);
		EventServiceImpl serviceEvent = new EventServiceImpl();
		try {
			try {
				assertNotNull(serviceEvent.updateEvent(events));
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
