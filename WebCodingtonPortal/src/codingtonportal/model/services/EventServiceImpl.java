package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import codingtonportal.model.dao.interfaces.EventDAO;
import codingtonportal.model.domain.Event;
import codingtonportal.utils.FERSDataConnection;
import codingtonportal.utils.PropertyAccess;


public class EventServiceImpl implements EventDAO {
	
	
	
	@Override
	public Event selectEvent(Event event) throws IOException,ClassNotFoundException, SQLException {
		FERSDataConnection con = new FERSDataConnection(); 
		PropertyAccess connection = new PropertyAccess();
		Event selection = null;
		PreparedStatement statementSQL = null;
		try {

			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectEvent"));
			statementSQL.setInt(1, event.getEventId());
			ResultSet outdata= statementSQL.executeQuery();
			
			if (outdata.next()) {
				selection = new Event();
				
				selection.setEventId(outdata.getInt(1));
				selection.setName(outdata.getString(2));
				selection.setDescription(outdata.getString(3));
				selection.setPlace(outdata.getInt(4));
				selection.setStartTime(outdata.getString(5));
				selection.setDuration(outdata.getString(6));
				selection.setEventType(outdata.getString(7));
				selection.setSeatsAvailable(outdata.getInt(8));
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

	
	
	
	@Override
	public ArrayList<Event> viewEvent() throws IOException,ClassNotFoundException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		ArrayList <Event> selection = null;
		Statement statementSQL = null;

		try {
			statementSQL = (con.getConnection()).createStatement();
			ResultSet outdata= statementSQL.executeQuery(connection.getProperty("viewEvent"));                     
			
			if (outdata.next()) {
				selection = new ArrayList <Event>();
				
				do {
					Event data = new Event();	   
					data.setEventId(outdata.getInt(1));
					data.setName(outdata.getString(2));
					data.setDescription(outdata.getString(3));
					data.setPlace(outdata.getInt(4));
					data.setStartTime(outdata.getString(5));
					data.setDuration(outdata.getString(6));
					data.setEventType(outdata.getString(7));
					data.setSeatsAvailable(outdata.getInt(8));
	
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
	 * The administrator inserts a new event with all his features.
	 * @param event
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public Integer insertEvent(Event event) throws IOException, ClassNotFoundException, SQLException   {  
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		
		try {    
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("insertEvent"));
			statementSQL.setString(1, event.getName());
			statementSQL.setString(2, event.getDescription());
			statementSQL.setInt(3, event.getPlace());
			statementSQL.setString(4, event.getDuration());
			statementSQL.setString(5, event.getStartTime());
			statementSQL.setString(6, event.getEventType());
			statementSQL.setInt(7, event.getSeatsAvailable());

			statementSQL.executeUpdate();	     
		
		} finally {
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
	 * The administrator deletes events from the list of events.
	 * @param event
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public Integer deleteEvent(Event event) throws IOException, ClassNotFoundException, SQLException   {  
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		
		try {    
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("deleteEvent"));
			statementSQL.setInt(1, event.getEventId());
			statementSQL.executeUpdate();
    
		} finally {
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
	 * The administrator update the event.
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public Integer updateEvent(Event event) throws IOException, ClassNotFoundException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		
		try {    
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("updateEvent"));
			statementSQL.setString(1, event.getName());
			statementSQL.setString(2, event.getDescription());
			statementSQL.setInt(3, event.getPlace());
			statementSQL.setString(4, event.getDuration());
			statementSQL.setString(5, event.getStartTime());
			statementSQL.setString(6, event.getEventType());
			statementSQL.setInt(7, event.getSeatsAvailable());
			statementSQL.setInt(8, event.getEventId());

			statementSQL.executeUpdate();		     
		
		} finally {
			if (statementSQL != null) { 
				statementSQL.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return 0;  
	}
}
