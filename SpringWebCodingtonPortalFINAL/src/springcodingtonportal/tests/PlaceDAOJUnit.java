package springcodingtonportal.tests;




import java.sql.Blob;
import java.sql.SQLException;

import javax.naming.NamingException;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springcodingtonportal.model.domain.Place;

import codingtonportal.model.services.PlaceServiceImpl;

public class PlaceDAOJUnit extends TestCase {
	
	PlaceServiceJDBC place;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		place = new PlaceServiceJDBC();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Method to insert a Place into the database.
	 * @throws SQLException
	 */
	@Test
	public void testinsertplace() throws SQLException {
		Place places = new Place (34, "Museum", 1, null,"C/olvido", "Quiero aparecer");
		PlaceServiceJDBC servicePlace = new PlaceServiceJDBC();
		try {
			assertNotNull(servicePlace.insertPlace(places));		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	/**
	 * Method to update a specific Place from the database
	 * @throws SQLException
	 */
	@Test
	public void testupdateplace() throws SQLException {
		Place places = new Place (36, "Museum", 1, null,"C/olvido", "Actualizar");
		PlaceServiceJDBC servicePlace = new PlaceServiceJDBC();
		try {
			assertNotNull(servicePlace.updatePlace(places));		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	/**
	 * Method to remove a specific Place from the database.
	 * @throws SQLException
	 */
	@Test
	public void testdeleteplace() throws SQLException {
		Place places = new Place (39, "Museum", 1, null,"C/olvido", "Quiero aparecer");
		PlaceServiceJDBC servicePlace = new PlaceServiceJDBC();
		try {
			assertNotNull(servicePlace.deletePlace(places.getIdPlace()));		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	/**
	 * Method to view all available Place from the database.
	 * @throws SQLException
	 */
	@Test
	public void testviewPlace () throws SQLException{
		PlaceServiceJDBC servicePlace = new PlaceServiceJDBC();
		try {
			assertNotNull(servicePlace.viewPlace());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to get an specific Event from the database.
	 * @throws SQLException
	 */
	@Test
	public void testselectPlace () throws SQLException{
		Place places = new Place (38, "Museum", 1, null,"C/olvido", "Quiero aparecer");
		PlaceServiceJDBC servicePlace = new PlaceServiceJDBC();
		try {
			assertNotNull(servicePlace.selectPlace(places));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


