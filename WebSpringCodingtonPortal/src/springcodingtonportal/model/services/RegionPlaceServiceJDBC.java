package springcodingtonportal.model.services;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import springcodingtonportal.model.dao.RegionPlaceDAO;
import springcodingtonportal.model.domain.RegionPlace;
import springcodingtonportal.model.domain.TypePlace;



/**
 * 
 * Services of the Region of Places used to select and view type of places available in the application.
 * 
 */
public class RegionPlaceServiceJDBC implements RegionPlaceDAO {

	/**
	 * Method to get all Region of Places from the database.
	 * 
	 * @return ArrayList<RegionPlace> with all Region of Places that exists or NULL if there is no Region of Place.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public ArrayList<RegionPlace> viewRegionPlace() throws SQLException, ClassNotFoundException, NamingException {
		// Initialize variables
		ArrayList <RegionPlace> selection = null;
				
				
		// Return the ArrayList of Places or null
		return selection;
	}

	
	
	
	
	/**
	 * Method to get a Region of Place from the database. Use a Place class to input the data required.
	 * 
	 * @param regionPlace : RegionPlace class with the data necessary to get the region of place requested.
	 * 
	 * @return RegionPlace class with the Region of Place requested or NULL if the region of place does not exists.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public RegionPlace selectRegionPlace(RegionPlace region) throws SQLException, ClassNotFoundException, NamingException {
		// Initialize variables
		RegionPlace data = null;

		
		// Return the Place or null
		return data;
	}





	
	/**
	 * Method to get a Region of Place from the database. Use a Type Place class to input the data required.
	 * 
	 * @param typePlace : TypePlace class with the data necessary to get the region of place requested.
	 * 
	 * @return RegionPlace class with the Region of Place requested or NULL if the region of place does not exists.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public RegionPlace getRegionPlace(TypePlace typePlace) throws SQLException,ClassNotFoundException, NamingException {
		// Initialize variables
		RegionPlace data = null;

		
		// Return the Place or null
		return data;
	}
	
}