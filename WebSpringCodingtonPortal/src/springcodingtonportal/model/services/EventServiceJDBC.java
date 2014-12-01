package springcodingtonportal.model.services;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.naming.NamingException;

import springcodingtonportal.model.dao.EventDAO;
import springcodingtonportal.model.domain.Event;



/**
 * 
 * Services of Events used to select, insert, update and delete events available in the application.
 * 
 */
public class EventServiceJDBC implements EventDAO {
	
	/**
	 * Method to get an Event from the database. Use an Event class to input the data required.
	 * 
	 * @param event : Event class with the data necessary to get the event requested.
	 * 
	 * @return Event class with the Event requested or NULL if the event does not exists.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws ParseException 
	 * @throws NamingException 
	 */
	@Override
	public Event selectEvent(Event event) throws ClassNotFoundException, SQLException, ParseException, NamingException {
		// Initialize variables
		Event selection = null;
		
		
		// Return the Event or null
		return selection;
	}

	
	
	
	/**
	 * Method to get all Events from the database.
	 * 
	 * @return ArrayList<Event> with all Events that exists or NULL if there is no Event.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws ParseException 
	 * @throws NamingException 
	 */
	@Override
	public ArrayList<Event> viewEvent() throws ClassNotFoundException, SQLException, ParseException, NamingException {
		// Initialize variables
		ArrayList <Event> selection = null;
		
		
		// Return the ArrayList of Events or null
		return selection;
	}
	
	
	
	/**
	 * Method to search Events for a Name from the database.
	 * 
	 * @param Name : name to search in events. 
	 * 
	 * @return ArrayList<Event> with all matching events that exists or NULL if there isn't events.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws ParseException 
	 * @throws NamingException 
	 */
	@Override
	public ArrayList<Event> searchEvent(String Name) throws ClassNotFoundException, SQLException, ParseException, NamingException {
		// Initialize variables
		ArrayList <Event> selection = null;
		
		
		// Return the ArrayList of Events or null
		return selection; 	
	}

	
	
	
	
	
	/**
	 * Method to insert an Event from the database. Use an Event class to input the data required.
	 * 
	 * @param event : Event class with the data necessary to insert.
	 * 
	 * @return Number of rows affected in the database. If the insert is correct, return 1, else return 0.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws ParseException 
	 * @throws NamingException 
	 */
	@Override
	public Integer insertEvent(Event event) throws ClassNotFoundException, SQLException, ParseException, NamingException   {  
		// Initialize variables
		Integer result = null;
		
		
		
		// Return if Event was inserted or not 
		return result;  
	} 
	
	
	
	/**
	 * Method to update an Event from the database. Use an Event class to input the data required.
	 * 
	 * @param event : Event class with the data necessary to update.
	 * 
	 * @return Number of rows affected in the database. If the update is correct, return 1, else return 0.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws ParseException 
	 * @throws NamingException 
	 */
	@Override
	public Integer updateEvent(Event event) throws ClassNotFoundException, SQLException, ParseException, NamingException {
		// Initialize variables
		Integer result = null;
		
		
		// Return if Event was updated or not 
		return result;  
	}
	
	
	
	
	
	/**
	 * Method to delete an Event from the database. Use an Event class to input the data required.
	 * 
	 * @param idEvent : Event class with the data necessary to delete.
	 * 
	 * @return Number of rows affected in the database. If the delete is correct, return 1, else return 0.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer deleteEvent(Integer idEvent) throws ClassNotFoundException, SQLException, NamingException   {  
		// Initialize variables
		Integer result = null;
		
		
		
		// Return if Event was deleted or not 
		return result;  
	}
	
}
