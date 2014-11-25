package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

import codingtonportal.model.dao.interfaces.VisitorDAO;
import codingtonportal.model.domain.Visitor;
import codingtonportal.utils.FERSDataConnection;
import codingtonportal.utils.PropertyAccess;


/**
 * Services of the Visitor used to select, insert, update and delete visitors available in the application.
 * The visitor can search Events, view all events, login into the application, ...
 * 
 */
public class VisitorServiceImpl implements VisitorDAO {
	
	
	/**
	 * Method to get a Visitor from the database. Use a Visitor class to input the data required.
	 * 
	 * @param visitor : Visitor class with the data necessary to get the event requested.
	 * 
	 * @return Visitor class with the Visitor requested or NULL if the visitor does not exists.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Visitor selectVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException, NamingException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection = new PropertyAccess();
		PreparedStatement statementSQL = null;
		Visitor data = null;
		
		try {
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectVisitor"));
			// Where clauses
			statementSQL.setInt(1, visitor.getIdVisitor());
			
			// Execute query
			ResultSet outdata= statementSQL.executeQuery();
			
			// If the Resultset brigns the Visitor
			if (outdata.next()){
				// Create a new Visitor
				data = new Visitor();
				
				// Complete the fields
				data.setIdVisitor(outdata.getInt("idVisitor"));
				data.setFirstName(outdata.getString("First_name"));
				data.setLastName(outdata.getString("Last_name"));
				data.setDni(outdata.getString("DNI"));
				data.setEmail(outdata.getString("Email"));
				data.setPhoneNumber(outdata.getString("Phone_number"));
				data.setAddress(outdata.getString("Address"));
				data.setUserName(outdata.getString("Username"));
				data.setPassword(outdata.getString("Password"));
				data.setAdmin(outdata.getBoolean("isAdmin"));
					                             
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
		// Return the Visitor or null
		return data;
	}
	
	
	
	
	/**
	 * Method to get all Visitors from the database.
	 * 
	 * @return ArrayList<Visitor> with all Visitors that exists or NULL if there is no Visitor.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public ArrayList<Visitor> viewVisitor() throws IOException, ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		ArrayList <Visitor> selection = null;
		PreparedStatement statementSQL = null;
		
		try {
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("viewVisitor"));
			
			// Execute query
			ResultSet outdata= statementSQL.executeQuery();                     
			
			// If the Resultset brigns the Visitor
			if (outdata.next()) {
				// Create an ArrayList of Visitors
				selection = new ArrayList <Visitor>();                   
				
				do {   
					// Create a new Visitor
					Visitor data = new Visitor();
					
					// Complete the fields
					data.setIdVisitor(outdata.getInt("idVisitor"));
					data.setFirstName(outdata.getString("First_name"));
					data.setLastName(outdata.getString("Last_name"));
					data.setDni(outdata.getString("DNI"));
					data.setEmail(outdata.getString("Email"));
					data.setPhoneNumber(outdata.getString("Phone_number"));
					data.setAddress(outdata.getString("Address"));
					data.setUserName(outdata.getString("Username"));
					data.setPassword(outdata.getString("Password"));
					data.setAdmin(outdata.getBoolean("isAdmin"));
	
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
		// Return the ArrayList of Visitors or null
		return selection;
	}

	
	
	
	/**
	 * Method to log in a Visitor from the application. Use a Visitor class to input the data required.
	 * 
	 * @param visitor : Visitor class with the data necessary to log in.
	 * 
	 * @return Id of the visitor if exists in the application.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer loginVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException, NamingException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("loginVisitor"));
			// Add conditions
			statementSQL.setString(1, visitor.getUserName());
			statementSQL.setString(2, visitor.getPassword());

			// Execute query
			ResultSet rs = statementSQL.executeQuery();
			
			// If the Visitor doesn't exists
			if(!rs.next()) {
				result = -1;
			}
			
			else {
				// Get the Id of the Visitor
				result = rs.getInt("idVisitor");
				// Close the Resulset
				rs.close();
			}
			 
		// Close the Statement and Connection
		} finally {
			if (statementSQL != null) {
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
		// Return the Id of Visitor if exists in the application
		return result;
	}

	
	

	/**
	 * Method to insert a Visitor from the database. Use a Visitor class to input the data required.
	 * 
	 * @param visitor : Visitor class with the data necessary to insert.
	 * 
	 * @return Number of rows affected in the database. If the insert is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer insertVisitor(Visitor visitor) throws IOException, ClassNotFoundException, SQLException, NamingException   {  
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("insertVisitor"));
			// Add conditions
			statementSQL.setString(1, visitor.getFirstName());
			statementSQL.setString(2, visitor.getLastName());
			statementSQL.setString(3, visitor.getDni());
			statementSQL.setString(4, visitor.getEmail());
			statementSQL.setString(5, visitor.getPhoneNumber());
			statementSQL.setString(6, visitor.getAddress());
			statementSQL.setString(7, visitor.getUserName());
			statementSQL.setString(8, visitor.getPassword());
			statementSQL.setBoolean(9, visitor.isAdmin());

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
		// Return if Visitor was inserted or not 
		return result;  
	} 
	
	
	
	
	/**
	 * Method to update a Visitor from the database. Use a Visitor class to input the data required.
	 * 
	 * @param visitor : Visitor class with the data necessary to update.
	 * 
	 * @return Number of rows affected in the database. If the update is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer updateVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException, NamingException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("updateVisitor"));
			// Add conditions
			statementSQL.setString(1, visitor.getFirstName());
			statementSQL.setString(2, visitor.getLastName());
			statementSQL.setString(3, visitor.getDni());
			statementSQL.setString(4, visitor.getEmail());
			statementSQL.setString(5, visitor.getPhoneNumber());
			statementSQL.setString(6, visitor.getAddress());
			
			// Where clauses
			statementSQL.setInt(7, visitor.getIdVisitor());

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
		// Return if Visitor was updated or not 
		return result;  		
	}
	


	
	/**
	 * Method to update a Visitor Password from the database. Use a Visitor class to input the data required.
	 * 
	 * @param visitor : Visitor class with the data necessary to update.
	 * 
	 * @return Number of rows affected in the database. If the update is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer updatePassword(Visitor visitor) throws IOException, ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("updatepassword"));
			// Add conditions
			statementSQL.setString(1, visitor.getPassword());
			// Where clauses
			statementSQL.setInt(2, visitor.getIdVisitor());

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
		// Return if Visitor Password was updated or not 
		return result;  	
	}
	
	
	
	
	/**
	 * Method to delete a Visitor from the database. Use a Visitor class to input the data required.
	 * 
	 * @param visitor : Visitor class with the data necessary to delete.
	 * 
	 * @return Number of rows affected in the database. If the delete is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer deleteVisitor(Visitor visitor) throws IOException, ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("deleteVisitor"));
			//Where clauses
			statementSQL.setInt(1, visitor.getIdVisitor());

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
		// Return if Visitor was deleted or not 
		return result;  	
	}
		
	
	
	
	/**
	 * Method to check if the Visitor is the admin application.
	 * 
	 * @param visitor : Visitor class with the data necessary to check.
	 * 
	 * @return Boolean that indicates if the Visitor is admin or not.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public boolean isAdmin(Visitor visitor) throws ClassNotFoundException, IOException, SQLException, NamingException {
		// Initialize variables
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {  
			// Create the Statement 
			statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("loginVisitor"));
			// Add conditions
			statementSQL.setString(1, visitor.getUserName());
			statementSQL.setString(2, visitor.getPassword());
		   
			// Execute query
			ResultSet rs = statementSQL.executeQuery();
			
			// If the pair of elements exists
			if(rs.next()) {                 
				result = rs.getInt("isAdmin");               
			} 
		
		// Close the Statement and Connection
		}finally{
			if (statementSQL != null) {
				statementSQL.close();
			}
			if (conex != null) {
				conex.close();
			}
		}
		// Return indicates if is admin or not
		if (result == 1)	return true;
		else 				return false;
	}
	
}
