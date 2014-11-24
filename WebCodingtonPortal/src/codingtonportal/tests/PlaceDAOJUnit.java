package codingtonportal.tests;



import java.io.IOException;
import java.sql.SQLException;

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
	public void testinsertplace() throws SQLException {
		Place places = new Place (34, "Museum", "1", 1, null,"C/olvido", "Quiero aparecer");
		PlaceServiceImpl servicePlace = new PlaceServiceImpl();
		try {
			assertNotNull(servicePlace.insertPlace(places));		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	@Test
	public void testupdateplace() throws SQLException {
		Place places = new Place (36, "Museum", "1", 1, null,"C/olvido", "Actualizar");
		PlaceServiceImpl servicePlace = new PlaceServiceImpl();
		try {
			assertNotNull(servicePlace.updatePlace(places));		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	@Test
	public void testdeleteplace() throws SQLException {
		Place places = new Place (39, "Museum", "1", 1, null,"C/olvido", "Quiero aparecer");
		PlaceServiceImpl servicePlace = new PlaceServiceImpl();
		try {
			assertNotNull(servicePlace.deletePlace(places.getIdPlace()));		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	@Test
	public void testviewPlace () throws SQLException{
		PlaceServiceImpl servicePlace = new PlaceServiceImpl();
		try {
			assertNotNull(servicePlace.viewPlace());
		} catch (IOException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testselectPlace () throws SQLException{
		Place places = new Place (38, "Museum", "1", 1, null,"C/olvido", "Quiero aparecer");
		PlaceServiceImpl servicePlace = new PlaceServiceImpl();
		try {
			assertNotNull(servicePlace.selectPlace(places));
		} catch (IOException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
	}

}


