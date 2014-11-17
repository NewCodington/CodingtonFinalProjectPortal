package codingtonportal.model.dao.interfaces;


import java.io.IOException;

import codingtonportal.model.domain.Place;

public interface PlaceDAO {
	/**
	 * This interface manages the methods related with the places.
	 * @param place
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean insertPlace(Place place) throws IOException, ClassNotFoundException;
	/**
	 * The administrator inserts a new Place.
	 * @param place
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean deletePlace(Place place) throws IOException, ClassNotFoundException;
	/**
	 * The administrator deletes a place from the list of places
	 * @param place
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean updatePlace(Place place) throws IOException, ClassNotFoundException;
	/**
	 * The administrator update the place.
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean selectPlace() throws IOException, ClassNotFoundException;
	/**
	 * The administrator selects a place.
	 */

}
