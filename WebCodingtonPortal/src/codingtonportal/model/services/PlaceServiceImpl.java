package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import codingtonportal.model.dao.interfaces.PlaceDAO;
import codingtonportal.model.domain.Place;
import codingtonportal.utils.PropertyAccess;
import codingtonportal.utils.FERSDataConnection;


/**
 * 
 * Services of the Place used to select, insert, update and delete places available in the application.
 * 
 */
public class PlaceServiceImpl implements PlaceDAO {

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
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Place data = null;

		try {
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectPlace"));
			// Where clauses
			statementSQL.setInt(1, place.getIdPlace());
			
			// Execute query
			ResultSet outdata= statementSQL.executeQuery();
			
			// If the Resultset brigns the Place
			if (outdata.next()){
				// Create a new Place
				data = new Place();
				
				// Complete the fields
				data.setIdPlace(outdata.getInt("idPlace"));
				data.setName(outdata.getString("Name"));
				data.setTypePlace(outdata.getInt("TypePlace"));
				data.setImage(outdata.getBlob("Image"));
				data.setAddress(outdata.getString("Address"));
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
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		ArrayList <Place> selection = null;
		PreparedStatement statementSQL = null;
		
		try {
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("viewPlace"));
			
			// Execute query
			ResultSet outdata= statementSQL.executeQuery();                     
			
			// If the Resultset brigns the Place
			if (outdata.next()) {
				// Create an ArrayList of Places
				selection = new ArrayList <Place>();                   
				
				do {
					// Create a new Place
					Place data = new Place();
					
					// Complete the fields
					data.setIdPlace(outdata.getInt("idPlace"));
					data.setName(outdata.getString("Name"));
					data.setTypePlace(outdata.getInt("TypePlace"));
					data.setImage(outdata.getBlob("Image"));
					data.setAddress(outdata.getString("Address"));
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
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;

		try { 
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("insertPlace"));
			// Add conditions
			statementSQL.setString(1, place.getName());
			statementSQL.setInt(2, place.getTypePlace());
			statementSQL.setBlob(3, place.getImage());
			statementSQL.setString(4, place.getAddress());
			statementSQL.setString(5, place.getDescription());	

			// Execute query
			result = statementSQL.executeUpdate();		     

		// Close the Statement and Connection
		}finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}	
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
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;

		try {    
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("updatePlace"));
			// Add conditions
			statementSQL.setString(1, place.getName());
			statementSQL.setInt(2,place.getTypePlace());
			statementSQL.setBlob(3, place.getImage());
			statementSQL.setString(4, place.getAddress());
			statementSQL.setString(5, place.getDescription());
			// Where clauses
			statementSQL.setInt(6, place.getIdPlace());

			// Execute query
			result = statementSQL.executeUpdate();
		    
		// Close the Statement and Connection
		}finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}	
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
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;

		try {    
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("deletePlace"));
			//Where clauses
			statementSQL.setInt(1, idPlace);

			// Execute query
			result = statementSQL.executeUpdate();

		// Close the Statement and Connection
		}finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}	
		// Return if Place was deleted or not 
		return result;  
	} 

}
