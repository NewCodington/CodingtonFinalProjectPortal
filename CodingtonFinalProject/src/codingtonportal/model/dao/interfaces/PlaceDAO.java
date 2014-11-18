package codingtonportal.model.dao.interfaces;


import java.io.IOException;

import codingtonportal.model.domain.Place;

/**
 * This interface manages the methods related with the places.
 * @param place
 * @return
 * @throws IOException
 * @throws ClassNotFoundException
 */
public interface PlaceDAO {
	public boolean insertPlace(Place place) throws IOException, ClassNotFoundException;
	public boolean deletePlace(Place place) throws IOException, ClassNotFoundException;
	public boolean updatePlace(Place place) throws IOException, ClassNotFoundException;
	public boolean selectPlace() throws IOException, ClassNotFoundException;
}
