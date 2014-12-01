package springcodingtonportal.model.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import springcodingtonportal.model.dao.EventSignUpDAO;



/**
 * 
 * Services of the Event Registration used to register or unregister for Events and update the seats of the Events. 
 * 
 */
public class EventSignUpJDBC implements EventSignUpDAO {

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
	public Integer registerForNewEvent(Integer idVisitor, Integer idEvent) throws ClassNotFoundException, SQLException, NamingException, IOException {
		// Initialize variables
		Integer idVisitorRegistered = selectVisitorForEvent(idVisitor, idEvent);
		Integer result = null;
		
		// If the visitor isn't registered
		if (idVisitorRegistered == null) {
			
			
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
	public Integer unregisterForEvent(Integer idVisitor, Integer idEvent) throws ClassNotFoundException, SQLException, NamingException, IOException {
		// Initialize variables
		Integer result = null;
		
		
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
	public Integer incrementSeats(Integer idEvent) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		Integer seats = null;
		
		
		
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
	public Integer decrementSeats(Integer idEvent) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		Integer seats = null;
		
		
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
	public ArrayList<Integer> selectEventForVisitor(Integer idVisitor) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		ArrayList <Integer> selection = null;
		
		
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
	public Integer selectVisitorForEvent(Integer idVisitor, Integer idEvent) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		Integer result = null;
		
		
		// Return the Visitor's Ids registered for that Event or null
		return result;
	}

}