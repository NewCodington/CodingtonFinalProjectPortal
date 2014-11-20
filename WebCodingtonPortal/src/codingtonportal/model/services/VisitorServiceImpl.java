package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import codingtonportal.model.dao.interfaces.VisitorDAO;
import codingtonportal.model.domain.Visitor;
import codingtonportal.utils.PropertyAccess;
import codingtonportal.utils.FERSDataConnection;



public class VisitorServiceImpl implements VisitorDAO {
	
	public boolean insertVisitor(Visitor visitor) throws IOException, ClassNotFoundException{  
	
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();
		PreparedStatement statementSQL = null;
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("insertVisitor"));
			
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
	

	
	public boolean loginVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException {
		
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();
		PreparedStatement statementSQL = null;
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("loginVisitor"));
			statementSQL.setString(1, visitor.getUserName());
			statementSQL.setString(2, visitor.getPassword());
			
			ResultSet rs = statementSQL.executeQuery();
			
			if(rs != null && rs.next()) {
				return true;
			}
			else {
				return false;
			}
		
		 } catch (SQLException e) {         
			 System.out.println(e.getMessage());  
			 return false;
			 
		 } finally {
			if (statementSQL != null) {
				statementSQL.close();
			}
			
			if (conex != null){
				conex.close();
			}
		}
	
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


	
	public boolean deleteVisitor(Visitor visitor) throws IOException, ClassNotFoundException, SQLException {
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();
		PreparedStatement statementSQL = null;
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("deleteVisitor"));
			
			statementSQL.setInt(1, visitor.getIdVisitor());
			
			statementSQL.execute();
			statementSQL.close();
			conex.close();		     
	  
		 } catch (SQLException e) {         
			 System.out.println(e.getMessage());  
			 return false;
			 
		}finally{
			if (statementSQL != null){
				statementSQL.close();
			}
			if (conex != null){
				conex.close();
			}
		}
		return true;  	
	}



	public boolean updateInformation(Visitor visitor) throws ClassNotFoundException, IOException, SQLException {
	
		 FERSDataConnection conex= new FERSDataConnection(); 
		 PropertyAccess conexion= new PropertyAccess();
		 PreparedStatement statementSQL = null;
		 
		 try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("updateVisitor"));
		
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
			
		}finally{
			if (statementSQL != null){
				statementSQL.close();
			}
			if (conex != null){
				conex.close();
			}
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


	public boolean selectVisitor() throws IOException, ClassNotFoundException {
		FERSDataConnection conex= new FERSDataConnection(); 
		 PropertyAccess conexion= new PropertyAccess();
		 ArrayList <Visitor> selection = new ArrayList <Visitor>();
		 try {
			 
	            Statement sentencia = (conex.getConnection()).createStatement();
	            ResultSet outdata= sentencia.executeQuery(conexion.getProperty("selectVisitor"));                     
	            while (outdata.next()){                   
	            	Visitor data = new Visitor();
	            	data.setIdVisitor(outdata.getInt(1));
	            	data.setFirstName(outdata.getString(2));
	            	data.setLastName(outdata.getString(3));
	            	data.setDni(outdata.getString(4));
	            	data.setEmail(outdata.getString(5));
	            	data.setPhoneNumber(outdata.getString(6));
	            	data.setAddress(outdata.getString(7));
	            	data.setUserName(outdata.getString(8));
	            	data.setPassword(outdata.getString(9));
	            	data.setAdmin(outdata.getBoolean(10));
	            	
	            	selection.add(data);	                             
	            }
	            
	        } catch (SQLException ex) {
	            return false;
	        } 		
		return true;
	}

	


	


	




}
