package springcodingtonportal.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import springcodingtonportal.model.domain.Place;


/**
 * 
 * The interface PlaceDAO shows the services that can be used or are related to the Places.
 * 
 * @author JAVA101_01
 *
 */
public interface PlaceDAO {
	public Place selectPlace(Place place) throws SQLException, ClassNotFoundException, NamingException;
	public List<Place> viewPlace() throws ClassNotFoundException, SQLException, NamingException;
	public Integer insertPlace(Place place) throws ClassNotFoundException, SQLException, NamingException;
	public Integer updatePlace(Place place) throws ClassNotFoundException, SQLException, NamingException;
	public Integer deletePlace(int idPlace) throws ClassNotFoundException, SQLException, NamingException;	
}
