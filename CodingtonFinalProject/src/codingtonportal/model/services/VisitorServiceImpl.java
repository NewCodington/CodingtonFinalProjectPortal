package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import codingtonportal.model.dao.interfaces.VisitorDAO;
import codingtonportal.model.domain.Event;
import codingtonportal.model.domain.Visitor;
import codingtonportal.utils.PropertyAccess;
import codingtonportal.utils.FERSDataConnection;


public class VisitorServiceImpl implements VisitorDAO {
	
	
	
	@Override
	public Visitor selectVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection = new PropertyAccess();
		PreparedStatement statementSQL = null;
		Visitor data = null;
		
		try {
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectVisitor"));
			
			statementSQL.setInt(1, visitor.getIdVisitor());
			
			ResultSet outdata= statementSQL.executeQuery();
			
			if (outdata.next()){                  
				data = new Visitor();
				
				data.setIdVisitor(outdata.getInt("idVisitor"));
				data.setFirstName(outdata.getString("First_name"));
				data.setLastName(outdata.getString("Last_name"));
				data.setDni(outdata.getString("DNI"));
				data.setEmail(outdata.getString("Email"));
				data.setPhoneNumber(outdata.getString("Phone_number"));
				data.setAddress(outdata.getString("Address"));
				data.setUserName(outdata.getString("Username"));
				data.setPassword(outdata.getString("Password"));
				data.setAdmin(outdata.getBoolean("isAdmin"));
					                             
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
		
		return data;
	}
	
	
	
	
	/**
	 * The administrator selects a visitor.
	 * @throws SQLException 
	 */
	public ArrayList<Visitor> viewVisitor() throws IOException, ClassNotFoundException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		ArrayList <Visitor> selection = null;
		PreparedStatement statementSQL = null;
		
		try {
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("viewVisitor"));
			
			ResultSet outdata= statementSQL.executeQuery();                     
			
			if (outdata.next()) {
				selection = new ArrayList <Visitor>();                   
				
				do {           
					Visitor data = new Visitor();
					
					data.setIdVisitor(outdata.getInt("idVisitor"));
					data.setFirstName(outdata.getString("First_name"));
					data.setLastName(outdata.getString("Last_name"));
					data.setDni(outdata.getString("DNI"));
					data.setEmail(outdata.getString("Email"));
					data.setPhoneNumber(outdata.getString("Phone_number"));
					data.setAddress(outdata.getString("Address"));
					data.setUserName(outdata.getString("Username"));
					data.setPassword(outdata.getString("Password"));
					data.setAdmin(outdata.getBoolean("isAdmin"));
	
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
	 * The visitor is logs into the portal.
	 * @param visitor
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public Integer loginVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("loginVisitor"));
			statementSQL.setString(1, visitor.getUserName());
			statementSQL.setString(2, visitor.getPassword());

			ResultSet rs = statementSQL.executeQuery();
			
			if(rs == null) {
				result = -1;
			}
			else {
				result = rs.getInt("idVisitor");
				rs.close();
			}
			 
		 } finally {
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
	 * The visitor is registered in a the portal.
	 * @param Username
	 * @param Password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException 
	 */
	public Integer insertVisitor(Visitor visitor) throws IOException, ClassNotFoundException, SQLException   {  
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("insertVisitor"));
			statementSQL.setString(1, visitor.getFirstName());
			statementSQL.setString(2, visitor.getLastName());
			statementSQL.setString(3, visitor.getDni());
			statementSQL.setString(4, visitor.getEmail());
			statementSQL.setString(5, visitor.getPhoneNumber());
			statementSQL.setString(6, visitor.getAddress());
			statementSQL.setString(7, visitor.getUserName());
			statementSQL.setString(8, visitor.getPassword());
			statementSQL.setBoolean(9, visitor.isAdmin());

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
	 * The visitor updates his personal information.
	 * @param visitor
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */

	@Override
	public Integer updateVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("updateVisitor"));
			statementSQL.setString(1, visitor.getFirstName());
			statementSQL.setString(2, visitor.getLastName());
			statementSQL.setString(3, visitor.getDni());
			statementSQL.setString(4, visitor.getEmail());
			statementSQL.setString(5, visitor.getPhoneNumber());
			statementSQL.setString(6, visitor.getAddress());
			statementSQL.setString(7, visitor.getPassword());
			//Where
			statementSQL.setInt(8, visitor.getIdVisitor());

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
	 * The visitor updates his password.
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public Integer updatePassword(Visitor visitor) throws IOException, ClassNotFoundException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("updatePassword"));
			statementSQL.setString(1, visitor.getPassword());
			//Where
			statementSQL.setInt(2, visitor.getIdVisitor());

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
	 * The visitor is deleted of the portal.
	 * @param visitor
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException 
	 */
	public Integer deleteVisitor(Visitor visitor) throws IOException, ClassNotFoundException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("deleteVisitor"));
			
			statementSQL.setInt(1, visitor.getIdVisitor());

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
	 * A list of all available events is shown.
	 * @throws SQLException 
	 */
	public ArrayList<Event> viewEvent() throws ClassNotFoundException, IOException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		ArrayList <Event> selection = null;
		PreparedStatement statementSQL = null;
		
		try {
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("viewEvent"));
			
			ResultSet outdata= statementSQL.executeQuery();                     
			
			if (outdata.next()) {
				selection = new ArrayList <Event>();                   
				
				do {           
					Event data = new Event();
					
					data.setEventId(outdata.getInt("idEvent"));
					data.setName(outdata.getString("Name"));
					data.setDescription(outdata.getString("Description"));
					data.setPlace(outdata.getInt("Place"));
					data.setDate_event(outdata.getDate("Date_event"));
					data.setStartTime(outdata.getString("StartTime"));
					data.setDuration(outdata.getString("Duration"));
					data.setEventType(outdata.getString("Event_type"));
					data.setSeatsAvailable(outdata.getInt("Seats_available"));
	
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
	 * The visitor search a event by the name.
	 * @param Name
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public ArrayList<Event> searchEvent(String Name) throws IOException, ClassNotFoundException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		ArrayList <Event> selection = null;
		PreparedStatement statementSQL = null;
		
		try {
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("searchEvent"));
			statementSQL.setString(1,Name);
			
			ResultSet outdata= statementSQL.executeQuery();                     
			
			if (outdata.next()) {
				selection = new ArrayList <Event>();                   
				
				do {           
					Event data = new Event();
					
					data.setEventId(outdata.getInt("idEvent"));
					data.setName(outdata.getString("Name"));
					data.setDescription(outdata.getString("Description"));
					data.setPlace(outdata.getInt("Place"));
					data.setDate_event(outdata.getDate("Date_event"));
					data.setStartTime(outdata.getString("StartTime"));
					data.setDuration(outdata.getString("Duration"));
					data.setEventType(outdata.getString("Event_type"));
					data.setSeatsAvailable(outdata.getInt("Seats_available"));
	
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
	
	public boolean isAdmin(Visitor visitor) throws ClassNotFoundException, IOException, SQLException {
		  FERSDataConnection conex= new FERSDataConnection(); 
		  PropertyAccess conexion= new PropertyAccess();
		  PreparedStatement statementSQL = null;
		 try {    
		   //PreparedStatemnt for dynamic data  
		   statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("loginVisitor"));
		   
		   statementSQL.setString(1, visitor.getUserName());
		   statementSQL.setString(2, visitor.getPassword());
		   
		   ResultSet rs = statementSQL.executeQuery();
		   if(rs != null) {
		    while (rs.next()) {                   
		     if(rs.getInt(10) == 1) {              
		      statementSQL.close();
		      conex.close(); 
		      return true;
		     }

		} 
		   }
		  
		   statementSQL.close();
		   conex.close();
		   
		  }catch (SQLException e) {         
		    System.out.println(e.getMessage()); 
		    
		  }finally{
		   if (statementSQL != null) {
		    statementSQL.close();
		   }
		   if (conex != null) {
		    conex.close();
		   }
		  }
		  return false;
		 
		 }
	
}
