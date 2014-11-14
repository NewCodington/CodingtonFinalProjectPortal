package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import codingtonportal.model.dao.interfaces.VisitorDAO;
import codingtonportal.model.domain.Visitor;
import codingtonportal.utils.PropertyAccess;
import codingtonportal.utils.FERSDataConnection;



public class VisitorServiceImpl implements VisitorDAO {

	public boolean insertVisitor(Visitor visitor) throws IOException, ClassNotFoundException   {  
	
			 FERSDataConnection conex= new FERSDataConnection(); 
			 PropertyAccess conexion= new PropertyAccess();
			 try {    
			//PreparedStatemnt for dynamic data	 
			PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("insertVisitor"));
			
			//statementSQL.setInt(1, visitor.getIdVisitor());
			statementSQL.setString(1, visitor.getFirstName());
			statementSQL.setString(2, visitor.getLastName());
			statementSQL.setString(3, visitor.getDni());
			statementSQL.setString(4, visitor.getEmail());
			statementSQL.setString(5, visitor.getPhoneNumber());
			statementSQL.setString(6, visitor.getAddress());
			statementSQL.setString(7, visitor.getUserName());
			statementSQL.setString(8, visitor.getPassword());
			statementSQL.setBoolean(9, visitor.isAdmin());
	
			statementSQL.executeUpdate();
			statementSQL.close();
			conex.close();		     
		
		 } catch (SQLException e) {         
			 System.out.println(e.getMessage());  
			 
		 return false;	
		 }
			return true;  
		 } 
	

	public boolean loginVisitor(String Username, String Password) throws ClassNotFoundException, IOException {
		
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();
		try {    
		//PreparedStatemnt for dynamic data	 
		PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("loginVisitor"));
		
		
		statementSQL.setString(1, Username);
		statementSQL.setString(2, Password);
		

		statementSQL.execute();
		statementSQL.close();
		conex.close();		     

		 } catch (SQLException e) {         
			 System.out.println(e.getMessage());  
			 return false;
		}
		return true;  	
	}


	public boolean deleteVisitor(Visitor visitor) throws IOException, ClassNotFoundException {
	
		
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();
		try {    
		//PreparedStatemnt for dynamic data	 
		PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("deleteVisitor"));
		
		statementSQL.setInt(1, visitor.getIdVisitor());
		
		statementSQL.execute();
		statementSQL.close();
		conex.close();		     
	  
		 } catch (SQLException e) {         
			 System.out.println(e.getMessage());  
			 return false;
			
			 }
		return true;  	
	}



	public boolean updateInformation(Visitor visitor) throws ClassNotFoundException, IOException {
	
		 FERSDataConnection conex= new FERSDataConnection(); 
		 PropertyAccess conexion= new PropertyAccess();
		 try {    
		//PreparedStatemnt for dynamic data	 
		PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("updateVisitor"));
	
		statementSQL.setString(1, visitor.getFirstName());
		statementSQL.setString(2, visitor.getLastName());
		statementSQL.setString(3, visitor.getDni());
		statementSQL.setString(4, visitor.getEmail());
		statementSQL.setString(5, visitor.getPhoneNumber());
		statementSQL.setString(6, visitor.getAddress());
		statementSQL.setString(7, visitor.getPassword());
		//Where
		statementSQL.setInt(8, visitor.getIdVisitor());
		
		statementSQL.executeUpdate();
		statementSQL.close();
		conex.close();		     
		
		 } catch (SQLException e) {         
			 System.out.println(e.getMessage()); 
			 return false;
			
			 }
		return true;  		
	}



	public boolean updatePassword(Visitor visitor) throws IOException, ClassNotFoundException {
		
		 FERSDataConnection conex= new FERSDataConnection(); 
		 PropertyAccess conexion= new PropertyAccess();
		 try {    
		//PreparedStatemnt for dynamic data	 
		PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("updatepassword"));
	
		
		statementSQL.setString(1, visitor.getPassword());
		//Where
		statementSQL.setInt(2, visitor.getIdVisitor());
		
		statementSQL.execute();
		statementSQL.close();
		conex.close();		     
	
		 } catch (SQLException e) {         
			 System.out.println(e.getMessage());  
			return false;
			 }
		return true;  	
		
		
	}



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

	
	public boolean searchEvent(String Search) throws IOException, ClassNotFoundException {
		
		
		FERSDataConnection conex= new FERSDataConnection(); 
		 PropertyAccess conexion= new PropertyAccess();
		 try {    
		//PreparedStatemnt for dynamic data	 
		PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("searchevent"));
	
		statementSQL.setString(1, Search);
		
		statementSQL.executeQuery();
		statementSQL.close();
		conex.close();		     

		 } catch (SQLException e) {         
			 System.out.println(e.getMessage()); 
			 return false;
			  
			 }
		return true;  	
	}


	public boolean viewEvent() throws ClassNotFoundException, IOException {
		
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
