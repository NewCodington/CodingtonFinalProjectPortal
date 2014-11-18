package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import codingtonportal.model.dao.interfaces.EventSignUpDAO;
//import codingtonportal.model.domain.Event;
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
	 */
	public boolean registerForNewEvent(int idVisitor, int idEvent) throws ClassNotFoundException, IOException {
		
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();
		try {    
			//PreparedStatemnt for dynamic data	 
			PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("registerevent"));

			statementSQL.setInt(1, idVisitor);
			statementSQL.setInt(2, idEvent);

			statementSQL.execute();
			statementSQL.close();
			conex.close();		     

		} catch (SQLException e) {         
			System.out.println(e.getMessage());  	  
			return false; 
		}
		return true; 
	}

	/**
	 * The visitor is unregistered for a registered event.
	 * @param Name
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public boolean unregisterForEvent(int idVisitor, int idEvent) throws IOException, ClassNotFoundException {
		
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();
		try {    
			//PreparedStatemnt for dynamic data	 
			PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("unregisterevent"));

			statementSQL.setInt(1, idVisitor);
			statementSQL.setInt(2, idEvent);

			statementSQL.execute();
			statementSQL.close();
			conex.close();		     

		} catch (SQLException e) {         
			System.out.println(e.getMessage());  
			return false;
		}
		return true;  	
	}

	/**
	 * The visitor search a event by the name.
	 * @param Name
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public boolean searchEvent(String Name) throws IOException, ClassNotFoundException {
		
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();
		try {    
			//PreparedStatemnt for dynamic data	 
			PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("searchevent"));

			statementSQL.setString(1, Name);

			statementSQL.execute();
			statementSQL.close();
			conex.close();		     

		} catch (SQLException e) {         
			System.out.println(e.getMessage()); 
			return false;
		}
		return true;  	
	}

	/**
	 * A list of all available events is shown.
	 */
	public boolean viewEvent(String Name) throws ClassNotFoundException, IOException {
		
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();
		try {    
			//PreparedStatemnt for dynamic data	 
			PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("viewevent"));

			statementSQL.executeQuery();
			statementSQL.close();
			conex.close();		     

		} catch (SQLException e) {         
			System.out.println(e.getMessage());  
			return false;
		}
		return true; 	
	}

}