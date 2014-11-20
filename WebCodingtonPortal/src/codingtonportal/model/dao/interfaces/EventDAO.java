package codingtonportal.model.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
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
	public Event selectEvent (Event event) throws IOException, ClassNotFoundException, SQLException;
	public ArrayList<Event> viewEvent () throws IOException, ClassNotFoundException, SQLException;
	public Integer insertEvent(Event event) throws IOException, ClassNotFoundException, SQLException;
	public Integer deleteEvent(Event event) throws IOException, ClassNotFoundException, SQLException;
	public Integer updateEvent(Event event) throws IOException, ClassNotFoundException, SQLException;
}
