package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import codingtonportal.model.dao.interfaces.PlaceDAO;
import codingtonportal.model.domain.Place;
import codingtonportal.utils.PropertyAccess;
import codingtonportal.utils.FERSDataConnection;


/**
 * Services of the Place used to select, insert, update and delete places available in the application.
 * 
 */
public class PlaceServiceImpl implements PlaceDAO {

	/**
	 * Method to get a Place from the database. Use a Place class to input the data required.
	 * 
	 * @param place : Place class with the data necessary to get the event requested.
	 * 
	 * @return Place class with the Place requested or NULL if the place does not exists.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	@Override
	public Place selectPlace(Place place) throws IOException, SQLException, ClassNotFoundException {
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
				data.setRegion(outdata.getString("Region"));
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
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	@Override
	public ArrayList<Place> viewPlace() throws IOException, ClassNotFoundException, SQLException {
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
					data.setRegion(outdata.getString("Region"));
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
	 */
	@Override
	public Integer insertPlace(Place place) throws IOException, ClassNotFoundException, SQLException {  
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;

		try { 
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("insertplace"));
			// Add conditions
			statementSQL.setString(1, place.getName());
			statementSQL.setString(2, place.getRegion());
			statementSQL.setInt(3, place.getTypePlace());
			statementSQL.setBlob(4, place.getImage());
			statementSQL.setString(5, place.getAddress());
			statementSQL.setString(6, place.getDescription());	

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
	 */
	@Override
	public Integer updatePlace(Place place) throws IOException, ClassNotFoundException, SQLException   {  
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;

		try {    
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("updateplace"));
			// Add conditions
			statementSQL.setString(1, place.getName());
			statementSQL.setString(2, place.getRegion());
			statementSQL.setInt(3,place.getTypePlace());
			statementSQL.setBlob(4, place.getImage());
			statementSQL.setString(5, place.getAddress());
			statementSQL.setString(6, place.getDescription());
			// Where clauses
			statementSQL.setInt(7, place.getIdPlace());

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
	 */
	@Override
	public Integer deletePlace(int idPlace) throws IOException, ClassNotFoundException, SQLException   {  
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;

		try {    
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("deleteplace"));
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
