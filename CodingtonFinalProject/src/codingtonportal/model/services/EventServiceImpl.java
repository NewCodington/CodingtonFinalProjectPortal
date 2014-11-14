package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import codingtonportal.model.dao.interfaces.EventDAO;
import codingtonportal.model.domain.Event;

import codingtonportal.utils.FERSDataConnection;
import codingtonportal.utils.PropertyAccess;

public class EventServiceImpl implements EventDAO {
	
	 public boolean insertEvent(Event event) throws IOException, ClassNotFoundException   {  
		 FERSDataConnection conex= new FERSDataConnection(); 
		 PropertyAccess conexion= new PropertyAccess();
		 try {    
			PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("insertEvent"));
			statementSQL.setString(1, event.getName());
			statementSQL.setString(2, event.getDescription());
			statementSQL.setInt(3, event.getPlace());
			statementSQL.setString(4, event.getDuration());
			statementSQL.setString(5, event.getStartTime());
			statementSQL.setString(6, event.getEventType());
			statementSQL.setInt(7, event.getSeatsAvailable());
			
			statementSQL.executeUpdate();
			statementSQL.close();
			conex.close();		     
			} catch (SQLException e) {         
				return false;
			}
		 	
		return true;  
	} 
	
	
	 public boolean deleteEvent(Event event) throws IOException, ClassNotFoundException   {  
		 FERSDataConnection conex= new FERSDataConnection(); 
		 PropertyAccess conexion= new PropertyAccess(); 
		 try {    
			 PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("deleteEvent"));
			 statementSQL.setInt(1, event.getEventId());
			 statementSQL.executeUpdate();
		
			 statementSQL.close();  
			 conex.close();    
		} catch (SQLException e) {         
			
			return false; 
		}
		
		 return true;  
	}


	@Override
	public boolean updateEvent(Event event) throws IOException, ClassNotFoundException {
		FERSDataConnection conex= new FERSDataConnection(); 
		 PropertyAccess conexion= new PropertyAccess();
		 try {    
			PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("updateEvent"));
			statementSQL.setString(1, event.getName());
			statementSQL.setString(2, event.getDescription());
			statementSQL.setInt(3, event.getPlace());
			statementSQL.setString(4, event.getDuration());
			statementSQL.setString(5, event.getStartTime());
			statementSQL.setString(6, event.getEventType());
			statementSQL.setInt(7, event.getSeatsAvailable());
			statementSQL.setInt(8, event.getEventId());
			
			statementSQL.executeUpdate();
			statementSQL.close();
			conex.close();		     
			} catch (SQLException e) {         
				return false;
			}
		 	
		return true;  
	}

/*
	@Override
	public boolean updateSeatsAvailable(Event event) throws ClassNotFoundException, IOException {
		FERSDataConnection conex= new FERSDataConnection(); 
		 PropertyAccess conexion= new PropertyAccess();
		 try {    
			PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("updateSeats"));
			statementSQL.setInt(1, event.getSeatsAvailable());
			statementSQL.setInt(2, event.getEventId());
			
			statementSQL.executeUpdate();
			statementSQL.close();
			conex.close();		     
			} catch (SQLException e) {         
				return false;
			}
		 	
		return true;  
	}
	*/
}
