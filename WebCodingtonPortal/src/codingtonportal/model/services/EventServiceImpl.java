package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import codingtonportal.model.dao.interfaces.EventDAO;
import codingtonportal.model.domain.Event;
import codingtonportal.utils.FERSDataConnection;
import codingtonportal.utils.PropertyAccess;


/**
 * Services of Events used to select, insert, update and delete events available in the application.
 * 
 */
public class EventServiceImpl implements EventDAO {
	
	/**
	 * Method to get an Event from the database. Use an EventDAO class to input the data required.
	 * 
	 * @param event : EventDAO class with the data necessary to get the event requested.
	 * 
	 * @return EventDAO class with the Event requested or NULL if the event does not exists.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	@Override
	public Event selectEvent(Event event) throws IOException,ClassNotFoundException, SQLException {
		// Initialize variables
		FERSDataConnection con = new FERSDataConnection(); 
		PropertyAccess connection = new PropertyAccess();
		Event selection = null;
		PreparedStatement statementSQL = null;
		
		try {
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectEvent"));
			// Where clauses
			statementSQL.setInt(1, event.getEventId());
			
			// Execute query
			ResultSet outdata= statementSQL.executeQuery();
			
			// If the Resultset brigns the Event
			if (outdata.next()) {
				// Create a new Event
				selection = new Event();
				
				// Complete the fields
				selection.setEventId(outdata.getInt("idEvent"));
				selection.setName(outdata.getString("Name"));
				selection.setDescription(outdata.getString("Description"));
				selection.setPlace(outdata.getInt("Place"));
				selection.setDate_event(outdata.getDate("Date_event"));
				selection.setStartTime(outdata.getString("StartTime"));
				selection.setDuration(outdata.getString("Duration"));
				selection.setEventType(outdata.getString("Event_type"));
				selection.setSeatsAvailable(outdata.getInt("Seats_available"));
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
		// Return the Event or null
		return selection;
	}

	
	
	
	/**
	 * Method to get all Events from the database.
	 * 
	 * @return ArrayList<Event> with all Events that exists or NULL if there is no Event.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	@Override
	public ArrayList<Event> viewEvent() throws IOException,ClassNotFoundException, SQLException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		ArrayList <Event> selection = null;
		PreparedStatement statementSQL = null;

		try {
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("viewEvent"));
			
			// Execute query
			ResultSet outdata= statementSQL.executeQuery();                     
			
			// If the Resultset brigns the Event
			if (outdata.next()) {
				// Create an ArrayList of Events
				selection = new ArrayList <Event>();
				
				do {
					// Create a new Event
					Event data = new Event();	   

					// Complete the fields
					data.setEventId(outdata.getInt("idEvent"));
					data.setName(outdata.getString("Name"));
					data.setDescription(outdata.getString("Description"));
					data.setPlace(outdata.getInt("Place"));
					data.setDate_event(outdata.getDate("Date_event"));
					data.setStartTime(outdata.getString("StartTime"));
					data.setDuration(outdata.getString("Duration"));
					data.setEventType(outdata.getString("Event_type"));
					data.setSeatsAvailable(outdata.getInt("Seats_available"));
	
					// Add to ArrayList
					selection.add(data);
					
				// Continue add Events while the Resultset have
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
		// Return the ArrayList of Events or null
		return selection;
	}
	
	
	
	
	/**
	 * Method to insert an Event from the database. Use an EventDAO class to input the data required.
	 * 
	 * @param event : EventDAO class with the data necessary to insert.
	 * 
	 * @return Number of rows affected in the database. If the insert is correct, return 1.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	@Override
	public Integer insertEvent(Event event) throws IOException, ClassNotFoundException, SQLException   {  
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try { 
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("insertEvent"));
			// Add conditions
			statementSQL.setString(1, event.getName());
			statementSQL.setString(2, event.getDescription());
			statementSQL.setInt(3, event.getPlace());
			statementSQL.setDate(4, event.getDate_event());
			statementSQL.setString(5, event.getStartTime());
			statementSQL.setString(6, event.getDuration());
			statementSQL.setString(7, event.getEventType());
			statementSQL.setInt(8, event.getSeatsAvailable());

			// Execute query
			result = statementSQL.executeUpdate();
		
		// Close the Statement and Connection
		} finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
		// Return if Event was inserted or not 
		return result;  
	} 
	
	
	
	/**
	 * Method to delete an Event from the database. Use an EventDAO class to input the data required.
	 * 
	 * @param event : EventDAO class with the data necessary to delete.
	 * 
	 * @return Number of rows affected in the database. If the delete is correct, return 1.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	@Override
	public Integer deleteEvent(Event event) throws IOException, ClassNotFoundException, SQLException   {  
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try { 
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("deleteEvent"));
			//Where clauses
			statementSQL.setInt(1, event.getEventId());
			
			// Execute query
			result = statementSQL.executeUpdate();
    
		// Close the Statement and Connection
		} finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
		// Return if Event was deleted or not 
		return result;  
	}
	
	

	
	/**
	 * Method to update an Event from the database. Use an EventDAO class to input the data required.
	 * 
	 * @param event : EventDAO class with the data necessary to update.
	 * 
	 * @return Number of rows affected in the database. If the insert is correct, return 1.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	@Override
	public Integer updateEvent(Event event) throws IOException, ClassNotFoundException, SQLException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			// Create the Statement
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("updateEvent"));
			// Add conditions
			statementSQL.setString(1, event.getName());
			statementSQL.setString(2, event.getDescription());
			statementSQL.setInt(3, event.getPlace());
			statementSQL.setDate(4, event.getDate_event());
			statementSQL.setString(5, event.getStartTime());
			statementSQL.setString(6, event.getDuration());
			statementSQL.setString(7, event.getEventType());
			statementSQL.setInt(8, event.getSeatsAvailable());
			// Where clauses
			statementSQL.setInt(9, event.getEventId());

			// Execute query
			result = statementSQL.executeUpdate();		     
		
		// Close the Statement and Connection
		} finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
		// Return if Event was updated or not 
		return result;  
	}
}
