package codingtonportal.model.dao.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import codingtonportal.model.domain.Event;

public interface EventDAO {
	/**
	 * This interface manages the methods relate with the events.
	 * @param event
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public boolean insertEvent(Event event) throws IOException, ClassNotFoundException;
	/**
	 * The administrator inserts a new event.
	 * @param event
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean deleteEvent(Event event) throws IOException, ClassNotFoundException;
	/**
	 * The administrator deletes events from the list of events.
	 * @param event
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean updateEvent(Event event) throws IOException, ClassNotFoundException;
	public ArrayList<Event> selectEvent () throws IOException, ClassNotFoundException;
	//public ArrayList <Event> selectEvent() throws IOException, ClassNotFoundException;
	
		/**
		 * The administrator selects a event.
		 */
		//public boolean updateSeatsAvailable(Event event) throws ClassNotFoundException, IOException;

}
