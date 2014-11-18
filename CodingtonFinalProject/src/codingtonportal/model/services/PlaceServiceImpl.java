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

	public boolean insertPlace(Place place) throws IOException, ClassNotFoundException   {  
		/**
		 * The administrator inserts a new Place.
		 * @param place
		 * @return
		 * @throws IOException
		 * @throws ClassNotFoundException
		 */ 
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();

		try {    
			PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("insertplace"));


			statementSQL.setString(1, place.getName());
			statementSQL.setString(2, place.getRegion());
			statementSQL.setInt(3, place.getTypePlace());
			statementSQL.setBlob(4, place.getImage());
			statementSQL.setString(5, place.getAddress());
			statementSQL.setString(6, place.getDescription());	

			statementSQL.executeUpdate();
			statementSQL.close();
			conex.close();		     

		} catch (SQLException e) {         

			return false;
		}
		return true;  
	} 

	public boolean deletePlace(Place place)   throws IOException, ClassNotFoundException   {  
		/**
		 * The administrator deletes a place from the list of places
		 * @param place
		 * @return
		 * @throws IOException
		 * @throws ClassNotFoundException
		 */
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();

		try {    
			PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("deleteplace"));
			statementSQL.setInt(1, place.getIdPlace());

			statementSQL.executeUpdate();
			statementSQL.close();  
			conex.close();
		} catch (SQLException e) {       
			return false;
		}
		return true;  
	} 

	public boolean updatePlace(Place place) throws IOException, ClassNotFoundException   {  
		/**
		 * The administrator update the place.
		 * @return
		 * @throws IOException
		 * @throws ClassNotFoundException
		 */
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();

		try {    
			PreparedStatement statementSQL = conex.getConnection().prepareStatement(conexion.getProperty("updateplace"));
			statementSQL.setString(1, place.getName());
			statementSQL.setString(2, place.getRegion());
			statementSQL.setInt(3,place.getTypePlace());
			statementSQL.setBlob(4, place.getImage());
			statementSQL.setString(5, place.getAddress());
			statementSQL.setString(6, place.getDescription());		
			statementSQL.setInt(7, place.getIdPlace());

			statementSQL.executeUpdate();
			statementSQL.close();
			conex.close();		     
		} catch (SQLException e) {         
			return false;
		}
		return true;  
	} 

	public boolean selectPlace() throws IOException, ClassNotFoundException {
		/**
		 * The administrator selects a place.
		 */	
		FERSDataConnection conex= new FERSDataConnection(); 
		PropertyAccess conexion= new PropertyAccess();
		ArrayList <Place> selection = new ArrayList <Place>();
		try {

			Statement sentencia = (conex.getConnection()).createStatement();
			ResultSet outdata= sentencia.executeQuery(conexion.getProperty("selectPlace"));                     
			while (outdata.next()){                   
				Place data = new Place();	
				data.setIdPlace(outdata.getInt(1));
				data.setName(outdata.getString(2));
				data.setRegion(outdata.getString(3));
				data.setTypePlace(outdata.getInt(4));
				data.setImage(outdata.getBlob(5));
				data.setAddress(outdata.getString(6));
				data.setDescription(outdata.getString(7));

				selection.add(data);	                             
			}   

		} catch (SQLException ex) {
			return false;
		}	
		return true;
	}
}