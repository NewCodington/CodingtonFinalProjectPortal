package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import codingtonportal.model.dao.interfaces.EventSignUpDAO;
import codingtonportal.model.domain.Event;
import codingtonportal.utils.FERSDataConnection;
import codingtonportal.utils.PropertyAccess;

public class EventSignUpImpl implements EventSignUpDAO {

	
	
	/**
	 * The visitor is registered in a new event.
	 * @param idVisitor
	 * @param idEvent
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public Integer registerForNewEvent(Integer idVisitor, Integer idEvent) throws ClassNotFoundException, IOException, SQLException {
		
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		ArrayList<Integer> idVisitorRegistered = selectVisitorForEvent(idVisitor);
		
		if (idVisitorRegistered == null) {
			
			try {    
				//PreparedStatemnt for dynamic data	 
				statementSQL = con.getConnection().prepareStatement(connection.getProperty("registerForNewEvent"));
				statementSQL.setInt(1, idVisitor);
				statementSQL.setInt(2, idEvent);
	
				statementSQL.executeUpdate();     
			
			}finally {
				if (statementSQL != null) { 
					statementSQL.close();
				}
				if (con != null) {
					con.close();
				}
			}
		}
		
		else {
			return null;
		}
		
		return 0; 
	}

	
	
	/**
	 * The visitor is unregistered for a registered event.
	 * @param Name
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public Integer unregisterForEvent(Integer idVisitor, Integer idEvent) throws IOException, ClassNotFoundException, SQLException {
		
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("unregisterForEvent"));
			statementSQL.setInt(1, idVisitor);
			statementSQL.setInt(2, idEvent);

			statementSQL.executeUpdate();	     
		
		}finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
		
		return 0;  	
	}

	
	
	
	/**
	 * The update of available seats.
	 * @param event
	 * @return
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


	
	
	@Override
	public ArrayList<Integer> selectEventForVisitor(Integer idVisitor) throws ClassNotFoundException, IOException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		ArrayList <Integer> selection = null;
		Statement statementSQL = null;
		
		try {    
			statementSQL = (con.getConnection()).createStatement();
			ResultSet outdata= statementSQL.executeQuery(connection.getProperty("selectEventForVisitor"));                     
			
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

}