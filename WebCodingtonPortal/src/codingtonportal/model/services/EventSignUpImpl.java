package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import codingtonportal.model.dao.interfaces.EventSignUpDAO;
import codingtonportal.model.domain.Event;
import codingtonportal.utils.FERSDataConnection;
import codingtonportal.utils.PropertyAccess;


/**
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
	 */
	public Integer registerForNewEvent(Integer idVisitor, Integer idEvent) throws ClassNotFoundException, IOException, SQLException {
		// Initialize variables
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer idVisitorRegistered = selectVisitorForEvent(idVisitor, idEvent);
		Integer result = null;
		
		if (idVisitorRegistered == null) {
			
			try {    
				//PreparedStatemnt for dynamic data	 
				statementSQL = con.getConnection().prepareStatement(connection.getProperty("registerForNewEvent"));
				statementSQL.setInt(1, idVisitor);
				statementSQL.setInt(2, idEvent);
	
				result = statementSQL.executeUpdate();     
			
			}finally {
				if (statementSQL != null) { 
					statementSQL.close();
				}
				if (con != null) {
					con.close();
				}
			}
		}
		
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
	 */
	public Integer unregisterForEvent(Integer idVisitor, Integer idEvent) throws IOException, ClassNotFoundException, SQLException {
		
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("unregisterForEvent"));
			statementSQL.setInt(1, idVisitor);
			statementSQL.setInt(2, idEvent);

			result = statementSQL.executeUpdate();	     
		
		}finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
		
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
	 */
	@Override
	public Integer updateSeatsAvailable(Event event) throws ClassNotFoundException, IOException, SQLException {
		
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer seats = null;
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectSeats"));
			statementSQL.setInt(1, event.getEventId());
			
			ResultSet rs = statementSQL.executeQuery();
			
			if (rs.next()) {
				seats = rs.getInt("Seats_available");
				if (seats > 0) {
					seats--;
					statementSQL = con.getConnection().prepareStatement(connection.getProperty("updateSeats"));
					statementSQL.setInt(1, seats);
					statementSQL.setInt(2, event.getEventId());
					statementSQL.executeUpdate();
				}
				else {
					seats = 0;
				}
			}
			
			rs.close();
		
		}finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
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
	 */
	@Override
	public ArrayList<Integer> selectEventForVisitor(Integer idVisitor) throws ClassNotFoundException, IOException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		ArrayList <Integer> selection = null;
		PreparedStatement statementSQL = null;
		
		try {    
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectEventForVisitor"));
			statementSQL.setInt(1, idVisitor);
			
			ResultSet outdata= statementSQL.executeQuery();                     
			
			if (outdata.next()) {
				selection = new ArrayList <Integer>();
				
				do {
					Integer data = outdata.getInt("idEventR");   
	
					selection.add(data);
					
				}while(outdata.next());
			}
			outdata.close();
			
		}finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
			
		return selection;
	}



	/**
	 * Method to obtain if the Event has registered this Visitor.
	 * 
	 * @param idVisitor	: the Id of the Visitor to obtain the Events registered. 
	 * 
	 * @return ArrayList of Ids of Events or NULL if the Visitor isn't registered.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	@Override
	public Integer selectVisitorForEvent(Integer idVisitor, Integer idEvent) throws ClassNotFoundException, IOException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectVisitorForEvent"));
			
			statementSQL.setInt(1, idEvent);
			statementSQL.setInt(2, idVisitor);
			
			ResultSet rs = statementSQL.executeQuery();
			if (rs.next()) {
				result = rs.getInt("idVisitorR");
			}
			rs.close();
			
		}finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
			
		return result;
	}

}