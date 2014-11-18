package codingtonportal.model.dao.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import codingtonportal.model.domain.Event;

/**
 * This interface manages the methods relate with the events.
 * @param event
 * @return
 * @throws IOException
 * @throws ClassNotFoundException
 */

public interface EventDAO {
	public boolean insertEvent(Event event) throws IOException, ClassNotFoundException;
	public boolean deleteEvent(Event event) throws IOException, ClassNotFoundException;
	public boolean updateEvent(Event event) throws IOException, ClassNotFoundException;
	public ArrayList<Event> selectEvent () throws IOException, ClassNotFoundException;
	//public boolean updateSeatsAvailable(Event event) throws ClassNotFoundException, IOException;

}
