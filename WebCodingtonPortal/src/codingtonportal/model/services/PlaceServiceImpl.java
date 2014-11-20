package codingtonportal.model.services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import codingtonportal.model.dao.interfaces.PlaceDAO;
import codingtonportal.model.domain.Place;
import codingtonportal.utils.PropertyAccess;
import codingtonportal.utils.FERSDataConnection;


public class PlaceServiceImpl implements PlaceDAO {

	
	
	@Override
	public Place selectPlace(Place place) throws IOException, SQLException, ClassNotFoundException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Place data = null;

		try {
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectPlace"));
			// Where clauses
			statementSQL.setInt(1, place.getIdPlace());
			
			ResultSet outdata= statementSQL.executeQuery();
			
			if (outdata.next()){
				data = new Place();
				
				data.setIdPlace(outdata.getInt("idPlace"));
				data.setName(outdata.getString("Name"));
				data.setRegion(outdata.getString("Region"));
				data.setTypePlace(outdata.getInt("TypePlace"));
				data.setImage(outdata.getBlob("Image"));
				data.setAddress(outdata.getString("Address"));
				data.setDescription(outdata.getString("Description"));	                             
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
	 * The administrator selects a place.
	 * @throws SQLException 
	 */
	@Override
	public ArrayList<Place> viewPlace() throws IOException, ClassNotFoundException, SQLException {
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		ArrayList <Place> selection = null;
		PreparedStatement statementSQL = null;
		
		try {
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("viewPlace"));
			
			ResultSet outdata= statementSQL.executeQuery();                     
			
			if (outdata.next()) {
				selection = new ArrayList <Place>();                   
				
				do {
					Place data = new Place();
					
					data.setIdPlace(outdata.getInt("idPlace"));
					data.setName(outdata.getString("Name"));
					data.setRegion(outdata.getString("Region"));
					data.setTypePlace(outdata.getInt("TypePlace"));
					data.setImage(outdata.getBlob("Image"));
					data.setAddress(outdata.getString("Address"));
					data.setDescription(outdata.getString("Description"));
	
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
	 * The administrator inserts a new Place.
	 * @param place
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */ 
	public Integer insertPlace(Place place) throws IOException, ClassNotFoundException, SQLException {  
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;

		try {    
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("insertPlace"));
			
			statementSQL.setString(1, place.getName());
			statementSQL.setString(2, place.getRegion());
			statementSQL.setInt(3, place.getTypePlace());
			statementSQL.setBlob(4, place.getImage());
			statementSQL.setString(5, place.getAddress());
			statementSQL.setString(6, place.getDescription());	

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
	 * The administrator update the place.
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public Integer updatePlace(Place place) throws IOException, ClassNotFoundException, SQLException   {  
		
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;

		try {    
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("updatePlace"));
			statementSQL.setString(1, place.getName());
			statementSQL.setString(2, place.getRegion());
			statementSQL.setInt(3,place.getTypePlace());
			statementSQL.setBlob(4, place.getImage());
			statementSQL.setString(5, place.getAddress());
			statementSQL.setString(6, place.getDescription());
			
			statementSQL.setInt(7, place.getIdPlace());

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
	 * The administrator deletes a place from the list of places
	 * @param place
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public Integer deletePlace(Place place) throws IOException, ClassNotFoundException, SQLException   {  
		FERSDataConnection con= new FERSDataConnection(); 
		PropertyAccess connection= new PropertyAccess();
		PreparedStatement statementSQL = null;
		Integer result = null;

		try {    
			statementSQL = con.getConnection().prepareStatement(connection.getProperty("deletePlace"));
			statementSQL.setInt(1, place.getIdPlace());

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

}
