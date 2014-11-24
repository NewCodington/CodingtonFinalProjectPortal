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
	public void testSelectPlace (){
		Place places = new Place (34, "Museum", "1", 1, null,"C/olvido", "Quiero aparecer");
		PlaceServiceImpl servicePlace = new PlaceServiceImpl();
		try {
			try{
				assertNotNull(servicePlace.selectPlace(places));
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
	public void testviewPlace (){
		PlaceServiceImpl servicePlace = new PlaceServiceImpl();
		try {
			try{
				assertNotNull(servicePlace.viewPlace());	
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
	public void testinsertplace() {
		Place places = new Place (100,"Museum", "1", 1, null, "C/olvido", "Quiero aparecer");		
		PlaceServiceImpl servicePlace = new PlaceServiceImpl();
		try {
			try {
				assertNotNull(servicePlace.insertPlace(places));
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
	public void testupdateplace() {
		Place places = new Place (100, "Museum", "1", 1, null,"C/olvido", "Actualizado");
		PlaceServiceImpl servicePlace = new PlaceServiceImpl();
		try {
			try {
				assertNotNull(servicePlace.updatePlace(places));
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
	public void testdeleteplace() {
		Place places = new Place (34, "Museum", "1", 1, null,"C/olvido", "Quiero aparecer");
		PlaceServiceImpl servicePlace = new PlaceServiceImpl();
		try {
			try {
				assertNotNull(servicePlace.deletePlace(places));
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


