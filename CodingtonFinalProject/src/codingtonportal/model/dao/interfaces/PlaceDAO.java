package codingtonportal.model.dao.interfaces;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import codingtonportal.model.domain.Place;

/**
 * This interface manages the methods related with the places.
 * @param place
 * @return
 * @throws IOException
 * @throws ClassNotFoundException
 */
public interface PlaceDAO {
	public Place selectPlace(Place place);
	public ArrayList<Place> viewPlace() throws IOException, ClassNotFoundException;
	public Integer insertPlace(Place place) throws IOException, ClassNotFoundException, SQLException;
	public Integer updatePlace(Place place) throws IOException, ClassNotFoundException, SQLException;
	public Integer deletePlace(Place place) throws IOException, ClassNotFoundException, SQLException;	
}
