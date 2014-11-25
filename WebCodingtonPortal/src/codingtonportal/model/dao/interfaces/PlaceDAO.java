package codingtonportal.model.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import codingtonportal.model.domain.Place;


/**
 * 
 * The interface PlaceDAO shows the services that can be used or are related to the Places.
 * 
 * @author JAVA101_01
 *
 */
public interface PlaceDAO {
	public Place selectPlace(Place place) throws IOException, SQLException, ClassNotFoundException, NamingException;
	public ArrayList<Place> viewPlace() throws IOException, ClassNotFoundException, SQLException, NamingException;
	public Integer insertPlace(Place place) throws IOException, ClassNotFoundException, SQLException, NamingException;
	public Integer updatePlace(Place place) throws IOException, ClassNotFoundException, SQLException, NamingException;
	public Integer deletePlace(int idPlace) throws IOException, ClassNotFoundException, SQLException, NamingException;	
}
