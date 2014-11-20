package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import codingtonportal.model.dao.interfaces.VisitorDAO;
import codingtonportal.model.domain.Place;
import codingtonportal.model.domain.Visitor;
import codingtonportal.utils.PropertyAccess;
import codingtonportal.utils.FERSDataConnection;


public class VisitorServiceImpl implements VisitorDAO {
	
	
	
	@Override
	public Visitor selectVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection = new PropertyAccess();
		Visitor data = null;
		PreparedStatement statementSQL = null;
		
		try {

			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectVisitor"));
			statementSQL.setInt(1, visitor.getIdVisitor());
			
			ResultSet outdata= statementSQL.executeQuery();
			
			if (outdata.next()){                  
				data = new Visitor();
				
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
		Statement statementSQL = null;
		
		try {
			statementSQL = (con.getConnection()).createStatement();
			
			ResultSet outdata= statementSQL.executeQuery(connection.getProperty("viewVisitor"));                     
			
			if (outdata.next()) {
				selection = new ArrayList <Visitor>();                   
				
				do {           
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
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("loginVisitor"));
			statementSQL.setString(1, visitor.getUserName());
			statementSQL.setString(2, visitor.getPassword());

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
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("updatePassword"));
			statementSQL.setString(1, visitor.getPassword());
			//Where
			statementSQL.setInt(2, visitor.getIdVisitor());

			statementSQL.execute();		     

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
		
		try {    
			//PreparedStatemnt for dynamic data	 
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("deleteVisitor"));
			statementSQL.setInt(1, visitor.getIdVisitor());

			statementSQL.execute();		     

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
	 * A list of all available events is shown.
	 */
	public Integer viewEvent(String Name) throws ClassNotFoundException, IOException {
		
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		try {    
			//PreparedStatemnt for dynamic data	 
			PreparedStatement statementSQL = con.getConnection().prepareStatement(connection.getProperty("viewevent"));

			statementSQL.executeQuery();
			statementSQL.close();
			con.close();		     

		} catch (SQLException e) {         
			System.out.println(e.getMessage());  
			return -1;
		}
		return 0; 	
	}
	/**
	 * The visitor search a event by the name.
	 * @param Name
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Integer searchEvent(String Name) throws IOException, ClassNotFoundException {
		
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		try {    
			//PreparedStatemnt for dynamic data	 
			PreparedStatement statementSQL = con.getConnection().prepareStatement(connection.getProperty("searchevent"));

			statementSQL.setString(1, Name);

			statementSQL.execute();
			statementSQL.close();
			con.close();		     

		} catch (SQLException e) {         
			System.out.println(e.getMessage()); 
			return -1;
		}
		return 0;  	
	}
}
