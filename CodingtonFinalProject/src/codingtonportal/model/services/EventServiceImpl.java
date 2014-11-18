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

	public boolean insertEvent(Event event) throws IOException, ClassNotFoundException   {  
		/**
		 * The administrator inserts a new event with all his features.
		 * @param event
		 * @return
		 * @throws IOException
		 * @throws ClassNotFoundException
		 */
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
		/**
		 * The administrator deletes events from the list of events.
		 * @param event
		 * @return
		 * @throws IOException
		 * @throws ClassNotFoundException
		 */
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
		/**
		 * The administrator update the event.
		 * @return
		 * @throws IOException
		 * @throws ClassNotFoundException
		 */
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

	public boolean selectEvent() throws IOException, ClassNotFoundException {
		/**
		 * The administrator selects a event.
		 */
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();
		ArrayList <Event> selection = new ArrayList <Event>();
		try {

			Statement sentencia = (conex.getConnection()).createStatement();
			ResultSet outdata= sentencia.executeQuery(conexion.getProperty("selectEvent"));                     
			while (outdata.next()){                   
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
			}
			for (Event element : selection)
				System.out.println(
						element.getEventId()+" - " + element.getName()+" - "+ element.getDescription() + " - "+ element.getPlace() + " - "+element.getStartTime()+" - "+element.getDuration()+" - "+element.getEventType()+" - "+element.getSeatsAvailable());	            

		} catch (SQLException ex) {
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
