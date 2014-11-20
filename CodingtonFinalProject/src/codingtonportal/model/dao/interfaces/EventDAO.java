package codingtonportal.model.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import codingtonportal.model.domain.Event;


/**
 * The interface EventDAO shows the services that can be used or are related to the Events.
 * 
 * @author JAVA101_01
 *
 */
public interface EventDAO {
	public Event selectEvent (Event event) throws IOException, ClassNotFoundException, SQLException;
	public ArrayList<Event> viewEvent () throws IOException, ClassNotFoundException, SQLException;
	public Integer insertEvent(Event event) throws IOException, ClassNotFoundException, SQLException;
	public Integer deleteEvent(Event event) throws IOException, ClassNotFoundException, SQLException;
	public Integer updateEvent(Event event) throws IOException, ClassNotFoundException, SQLException;
}
