package codingtonportal.model.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import codingtonportal.model.dao.interfaces.RegionPlaceDAO;
import codingtonportal.model.domain.Place;
import codingtonportal.model.domain.RegionPlace;
import codingtonportal.utils.FERSDataConnection;
import codingtonportal.utils.PropertyAccess;


public class RegionPlaceServiceImpl implements RegionPlaceDAO {

	@Override
	public ArrayList<RegionPlace> viewRegionPlace() throws SQLException, ClassNotFoundException, NamingException {
		// Initialize variables
				FERSDataConnection con= new FERSDataConnection(); 
				PropertyAccess connection= new PropertyAccess();
				ArrayList <RegionPlace> selection = null;
				PreparedStatement statementSQL = null;
				
				try {
					// Create the Statement
					statementSQL = con.getConnection().prepareStatement(connection.getProperty("viewRegionPlace"));
					
					// Execute query
					ResultSet outdata= statementSQL.executeQuery();                     
					
					// If the Resultset brigns the Place
					if (outdata.next()) {
						// Create an ArrayList of Places
						selection = new ArrayList <RegionPlace>();                   
						
						do {
							// Create a new Place
							RegionPlace data = new RegionPlace();
							
							// Complete the fields
							data.setIdRegionPlace(outdata.getInt("idRegionPlace"));
							data.setName(outdata.getString("Name"));
							data.setDescription(outdata.getString("Description"));
			
							// Add to ArrayList
							selection.add(data);
						
						// Continue add Places while the Resultset have
						}while(outdata.next());
					}  
					// Close the Resultset
					outdata.close();

				// Close the Statement and Connection
				}finally {
					if (statementSQL != null) { 
						statementSQL.close();
					}
					if (con != null) {
						con.close();
					}
				}	
				// Return the ArrayList of Places or null
				return selection;
	}

	@Override
	public RegionPlace selectRegionPlace(RegionPlace region) throws SQLException, ClassNotFoundException, NamingException {
		// Initialize variables
				FERSDataConnection con= new FERSDataConnection(); 
				PropertyAccess connection= new PropertyAccess();
				PreparedStatement statementSQL = null;
				RegionPlace data = null;

				try {
					// Create the Statement
					statementSQL = con.getConnection().prepareStatement(connection.getProperty("selectRegionPlace"));
					// Where clauses
					statementSQL.setInt(1, region.getIdRegionPlace());
					
					// Execute query
					ResultSet outdata= statementSQL.executeQuery();
					
					// If the Resultset brigns the Place
					if (outdata.next()){
						// Create a new Place
						data = new RegionPlace();
						
						// Complete the fields
						data.setIdRegionPlace(outdata.getInt("idRegionPlace"));
						data.setName(outdata.getString("Name"));
						data.setDescription(outdata.getString("Description"));                           
					}	
					// Close the Resultset
					outdata.close();
				
				// Close the Statement and Connection
				}finally {
					if (statementSQL != null) { 
						statementSQL.close();
					}
					if (con != null) {
						con.close();
					}
				}
				// Return the Place or null
				return data;
	}

}
