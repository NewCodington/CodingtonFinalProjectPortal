package codingtonportal.model.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import codingtonportal.model.dao.interfaces.TypePlaceDAO;
import codingtonportal.model.domain.TypePlace;
import codingtonportal.utils.FERSDataConnection;
import codingtonportal.utils.PropertyAccess;


/**
 * 
 * Services of the Type of Places used to select and view type of places available in the application.
 * 
 */
public class TypePlaceServiceImpl implements TypePlaceDAO {

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
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		ArrayList <TypePlace> selection = null;
		PreparedStatement statementSQL = null;
		
		try {
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("viewTypePlace"));
			
			// Execute query
			ResultSet outdata= statementSQL.executeQuery();                     
			
			// If the Resultset brigns the Place
			if (outdata.next()) {
				// Create an ArrayList of Places
				selection = new ArrayList <TypePlace>();                   
				
				do {
					// Create a new Place
					TypePlace data = new TypePlace();
					
					// Complete the fields
					data.setIdTypePlace(outdata.getInt("idTypePlace"));
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
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		TypePlace data = null;

		try {
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectTypePlace"));
			// Where clauses
			statementSQL.setInt(1, type.getIdTypePlace());
			
			// Execute query
			ResultSet outdata= statementSQL.executeQuery();
			
			// If the Resultset brigns the Place
			if (outdata.next()){
				// Create a new Place
				data = new TypePlace();
				
				// Complete the fields
				data.setIdTypePlace(outdata.getInt("idTypePlace"));
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
