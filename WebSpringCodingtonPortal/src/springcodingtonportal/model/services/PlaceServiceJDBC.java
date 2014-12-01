package springcodingtonportal.model.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import springcodingtonportal.model.dao.PlaceDAO;
import springcodingtonportal.model.domain.Place;



/**
 * 
 * Services of the Place used to select, insert, update and delete places available in the application.
 * 
 */
public class PlaceServiceJDBC implements PlaceDAO {

	/**
	 * Method to get a Place from the database. Use a Place class to input the data required.
	 * 
	 * @param place : Place class with the data necessary to get the place requested.
	 * 
	 * @return Place class with the Place requested or NULL if the place does not exists.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Place selectPlace(Place place) throws SQLException, ClassNotFoundException, NamingException {
		// Initialize variables
		Place data = null;
		
		// Return the Place or null
		return data;
	}

	
	
	/**
	 * Method to get all Places from the database.
	 * 
	 * @return ArrayList<Place> with all Places that exists or NULL if there is no Place.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public ArrayList<Place> viewPlace() throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		ArrayList <Place> selection = null;
		
		
		// Return the ArrayList of Places or null
		return selection;
	}
	
	
	
	
	/**
	 * Method to insert a Place from the database. Use a Place class to input the data required.
	 * 
	 * @param place : Place class with the data necessary to insert.
	 * 
	 * @return Number of rows affected in the database. If the insert is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer insertPlace(Place place) throws ClassNotFoundException, SQLException, NamingException {  
		// Initialize variables
		Integer result = null;

		
		// Return if Place was inserted or not 
		return result;  
	} 

	
	
	
	/**
	 * Method to update a Place from the database. Use a Place class to input the data required.
	 * 
	 * @param place : Place class with the data necessary to update.
	 * 
	 * @return Number of rows affected in the database. If the update is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer updatePlace(Place place) throws ClassNotFoundException, SQLException, NamingException   {  
		// Initialize variables
		Integer result = null;

		
		// Return if Place was updated or not 
		return result;  
	}
	
	
	
	/**
	 * Method to delete a Place from the database. Use a Place class to input the data required.
	 * 
	 * @param place : Place class with the data necessary to delete.
	 * 
	 * @return Number of rows affected in the database. If the delete is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer deletePlace(int idPlace) throws ClassNotFoundException, SQLException, NamingException   {  
		// Initialize variables
		Integer result = null;

		
		// Return if Place was deleted or not 
		return result;  
	} 

}
