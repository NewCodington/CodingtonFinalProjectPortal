package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import codingtonportal.model.dao.interfaces.EventSignUpDAO;
import codingtonportal.utils.FERSDataConnection;
import codingtonportal.utils.PropertyAccess;


/**
 * 
 * Services of the Event Registration used to register or unregister for Events and update the seats of the Events. 
 * 
 */
public class EventSignUpImpl implements EventSignUpDAO {

	/**
	 * Method to register a Visitor into an Event if the Visitor not is registered in that Event.
	 * 
	 * @param idVisitor	: the Id of the Visitor to register in the Event. 
	 * @param idEvent	: the Id of the event in which register the user wants.
	 * 
	 * @return Number of rows affected in the database. If the register is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	public Integer registerForNewEvent(Integer idVisitor, Integer idEvent) throws ClassNotFoundException, IOException, SQLException, NamingException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer idVisitorRegistered = selectVisitorForEvent(idVisitor, idEvent);
		Integer result = null;
		
		// If the visitor isn't registered
		if (idVisitorRegistered == null) {
			
			try {
			// Update seats if available
				Integer seatsAvailable = decrementSeats(idEvent);
			
			// If seats availabe, register a Visitor into Event
				if (seatsAvailable != 0) {
					// Create the Statement
					statementSQL = con.getConnection().prepareStatement(connection.getProperty("registerForNewEvent"));
					// Add conditions
					statementSQL.setInt(1, idVisitor);
					statementSQL.setInt(2, idEvent);
		
					// Execute Query
					result = statementSQL.executeUpdate();
				}
				
			// Close the Statement and Connection
			}finally {
				if (statementSQL != null) { 
					statementSQL.close();
				}
				if (con != null) {
					con.close();
				}
			}
		}
		// Return if Visitor was registered or not 
		return result; 
	}

	
	
	
	/**
	 * Method to unregister a Visitor to an Event if the Visitor is registered in that Event.
	 * 
	 * @param idVisitor	: the Id of the Visitor to unregister in the Event. 
	 * @param idEvent	: the Id of the event in which unregister the user wants.
	 * 
	 * @return Number of rows affected in the database. If the unregister is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	public Integer unregisterForEvent(Integer idVisitor, Integer idEvent) throws IOException, ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			// Update seats if available
			Integer seatsAvailable = incrementSeats(idEvent);
			
			// Unregister for Event
			if (seatsAvailable != null) {
				// Create the Statement
				statementSQL = con.getConnection().prepareStatement(connection.getProperty("unregisterForEvent"));
				// Add conditions
				statementSQL.setInt(1, idVisitor);
				statementSQL.setInt(2, idEvent);
	
				// Execute Query
				result = statementSQL.executeUpdate();	     
			}
			
		// Close the Statement and Connection
		}finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
		// Return if Visitor was unregistered or not 
		return result;  	
	}

	
	
	
	/**
	 * Method to update the seats available in the event especified.
	 * 
	 * @param event	: the Event to update the seats available. 
	 * 
	 * @return Number of seats available after update it, if the Event hasn't got seats, return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer incrementSeats(Integer idEvent) throws ClassNotFoundException, IOException, SQLException, NamingException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer seats = null;
		
		try {    
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectSeats"));
			// Add conditions
			statementSQL.setInt(1, idEvent);
			
			// Execute Query
			ResultSet rs = statementSQL.executeQuery();
			
			// If there are seats available
			if (rs.next()) {
				seats = rs.getInt("Seats_available");

				seats++;
				statementSQL = con.getConnection().prepareStatement(connection.getProperty("updateSeats"));
				statementSQL.setInt(1, seats);
				statementSQL.setInt(2, idEvent);
				statementSQL.executeUpdate();
			}
			// Close the Resultset
			rs.close();
		
		// Close the Statement and Connection
		}finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
		// Return if Visitor was unregistered or not 
		return seats;  	
	}

	
	
	
	
	/**
	 * Method to update the seats available in the event especified.
	 * 
	 * @param event	: the Event to update the seats available. 
	 * 
	 * @return Number of seats available after update it, if the Event hasn't got seats, return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer decrementSeats(Integer idEvent) throws ClassNotFoundException, IOException, SQLException, NamingException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer seats = null;
		
		try {    
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectSeats"));
			// Add conditions
			statementSQL.setInt(1, idEvent);
			
			// Execute Query
			ResultSet rs = statementSQL.executeQuery();
			
			// If there are seats available
			if (rs.next()) {
				seats = rs.getInt("Seats_available");
				// If the seats are more than 0
				if (seats > 0) {
					seats--;
					statementSQL = con.getConnection().prepareStatement(connection.getProperty("updateSeats"));
					statementSQL.setInt(1, seats);
					statementSQL.setInt(2, idEvent);
					statementSQL.executeUpdate();
				}
				// If the seats are 0, not if it decreases
				else {
					seats = 0;
				}
			}
			// Close the Resultset
			rs.close();
		
		// Close the Statement and Connection
		}finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
		// Return if Visitor was unregistered or not 
		return seats;  	
	}


	
	/**
	 * Method to obtain all Ids of Events in which Visitor is registered.
	 * 
	 * @param idVisitor	: the Id of the Visitor to obtain the Events registered. 
	 * 
	 * @return ArrayList of Ids of Events or NULL if the Visitor isn't registered.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public ArrayList<Integer> selectEventForVisitor(Integer idVisitor) throws ClassNotFoundException, IOException, SQLException, NamingException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		ArrayList <Integer> selection = null;
		PreparedStatement statementSQL = null;
		
		try {   
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectEventForVisitor"));
			// Where clauses
			statementSQL.setInt(1, idVisitor);
			
			// Execute Query
			ResultSet outdata= statementSQL.executeQuery();                     
			
			// If there are events available
			if (outdata.next()) {
				// Create a new ArrayList
				selection = new ArrayList <Integer>();
				
				do {
					// Create a new Id
					Integer data = outdata.getInt("idEventR");   
	
					// Add to ArrayList
					selection.add(data);
					
				// Continue add Ids while the Resultset have
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
		// Return the Event's Ids registered for Visitor or not
		return selection;
	}



	/**
	 * Method to obtain if the Event has registered this Visitor.
	 * 
	 * @param idVisitor	: the Id of the Visitor to to check if is registered.
	 * @param idEvent	: the Id of the Event to check if the visitor is registered. 
	 * 
	 * @return Visitor's Id if is registered in the Event or null if isn't registered.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer selectVisitorForEvent(Integer idVisitor, Integer idEvent) throws ClassNotFoundException, IOException, SQLException, NamingException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectVisitorForEvent"));
			// Where clauses
			statementSQL.setInt(1, idEvent);
			statementSQL.setInt(2, idVisitor);
			
			// Execute Query
			ResultSet rs = statementSQL.executeQuery();
			
			// If the Visitor has registered for that Event
			if (rs.next()) {
				// Get the Id of the visitor to return
				result = rs.getInt("idVisitorR");
			}
			
			// Close the Resultset
			rs.close();
		
		// Close the Statement and Connection
		}finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
		// Return the Visitor's Ids registered for that Event or null
		return result;
	}

}