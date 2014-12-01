package springcodingtonportal.model.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import springcodingtonportal.model.dao.TypePlaceDAO;
import springcodingtonportal.model.domain.TypePlace;

/**
 * 
 * Services of the Type of Places used to select and view type of places available in the application.
 * 
 */
public class TypePlaceServiceJDBC implements TypePlaceDAO {

	/**
	 * Method to get all Types of Places from the database.
	 * 
	 * @return ArrayList<TypePlace> with all Types of Places that exists or NULL if there is no Type of Place.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public ArrayList<TypePlace> viewTypePlace() throws NamingException, SQLException, ClassNotFoundException {
		// Initialize variables
		ArrayList <TypePlace> selection = null;
		
		
		
		// Return the ArrayList of Places or null
		return selection;
	}

	
	
	
	
	/**
	 * Method to get a Type of Place from the database. Use a Place class to input the data required.
	 * 
	 * @param TypePlace : Type of Place class with the data necessary to get the event requested.
	 * 
	 * @return TypePlace class with the Type of Place requested or NULL if the type of place does not exists.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public TypePlace selectTypePlace(TypePlace type) throws SQLException, ClassNotFoundException, NamingException {
		// Initialize variables
		TypePlace data = null;

		
		// Return the Place or null
		return data;
	}

}
