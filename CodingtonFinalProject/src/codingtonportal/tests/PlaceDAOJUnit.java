package codingtonportal.tests;



import java.io.IOException;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import codingtonportal.model.domain.Place;
import codingtonportal.model.services.PlaceServiceImpl;

public class PlaceDAOJUnit extends TestCase {
	
	PlaceServiceImpl place;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		place = new PlaceServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testinsertplace() {
		Place places = new Place (1, "Museum", "North", 1, null, "C/olvido", "Quiero aparecer");
		try {
			assertTrue(place.insertPlace(places));		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	@Test
	public void testupdateplace() {
		Place places = new Place (1, "Museum", "North", 1, null, "C/olvido", "Actualizado");
		try {
			assertTrue(place.updatePlace(places));		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	@Test
	public void testdeleteplace() {
		Place places = new Place (1, "Museum", "North", 1, null, "C/olvido", "Quiero aparecer");
		try {
			assertTrue(place.deletePlace(places));		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	

}


