package codingtonportal.model.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import codingtonportal.model.dao.interfaces.RegionPlaceDAO;
import codingtonportal.model.domain.RegionPlace;
import codingtonportal.model.domain.TypePlace;
import codingtonportal.utils.FERSDataConnection;
import codingtonportal.utils.PropertyAccess;


/**
 * 
 * Services of the Region of Places used to select and view type of places available in the application.
 * 
 */
public class RegionPlaceServiceImpl implements RegionPlaceDAO {

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
				FERSDataConnection con= new FERSDataConnection(); 
				PropertyAccess connection= new PropertyAccess();
				ArrayList <RegionPlace> selection = null;
				PreparedStatement statementSQL = null;
				
				try {
					// Create the Statement
					statementSQL = con.getConnection().prepareStatement(connection.getProperty("viewRegionPlace"));
					
					// Execute query
					ResultSet outdata= statementSQL.executeQuery();                     
					
					// If the Resultset brigns the Region of Place
					if (outdata.next()) {
						// Create an ArrayList of Region Places
						selection = new ArrayList <RegionPlace>();                   
						
						do {
							// Create a new Region Place
							RegionPlace data = new RegionPlace();
							
							// Complete the fields
							data.setIdRegionPlace(outdata.getInt("idRegionPlace"));
							data.setName(outdata.getString("Name"));
							data.setDescription(outdata.getString("Description"));
			
							// Add to ArrayList
							selection.add(data);
						
						// Continue add Places while the Resultset have
						}while(outdata.next());
					}  
					// Close the Resultset
					outdata.close();

				// Close the Statement and Connection
				}finally {
					if (statementSQL != null) { 
						statementSQL.close();
					}
					if (con != null) {
						con.close();
					}
				}	
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
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		RegionPlace data = null;

		try {
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectRegionPlace"));
			// Where clauses
			statementSQL.setInt(1, region.getIdRegionPlace());
					
			// Execute query
			ResultSet outdata= statementSQL.executeQuery();
					
			// If the Resultset brigns the Region Place
			if (outdata.next()){
				// Create a new Region Place
				data = new RegionPlace();
						
				// Complete the fields
				data.setIdRegionPlace(outdata.getInt("idRegionPlace"));
				data.setName(outdata.getString("Name"));
				data.setDescription(outdata.getString("Description"));                           
			}	
			// Close the Resultset
			outdata.close();
				
		// Close the Statement and Connection
		}finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
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
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		RegionPlace data = null;

		try {
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("getRegionPlace"));
			// Where clauses
			statementSQL.setInt(1, typePlace.getIdTypePlace());
						
			// Execute query
			ResultSet outdata= statementSQL.executeQuery();
							
			// If the Resultset brigns the Region of Place
			if (outdata.next()){
				// Create a new Region Place
				data = new RegionPlace();
								
				// Complete the fields
				data.setIdRegionPlace(outdata.getInt("idRegionPlace"));
				data.setName(outdata.getString("Name"));
				data.setDescription(outdata.getString("Description"));                           
			}	
			// Close the Resultset
			outdata.close();
						
		// Close the Statement and Connection
		}finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
		// Return the Place or null
		return data;
	}
	
}