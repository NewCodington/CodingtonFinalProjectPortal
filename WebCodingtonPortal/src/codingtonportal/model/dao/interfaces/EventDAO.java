package codingtonportal.model.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.naming.NamingException;

import codingtonportal.model.domain.Event;


/**
 * 
 * The interface EventDAO shows the services that can be used or are related to the Events.
 * 
 * @author JAVA101_01
 *
 */
public interface EventDAO {
	public Event selectEvent (Event event) throws IOException, ClassNotFoundException, SQLException, ParseException, NamingException;
	public ArrayList<Event> viewEvent () throws IOException, ClassNotFoundException, SQLException, ParseException, NamingException;
	public Integer insertEvent(Event event) throws IOException, ClassNotFoundException, SQLException, ParseException, NamingException;
	public Integer deleteEvent(Integer idEvent) throws IOException, ClassNotFoundException, SQLException, NamingException;
	public Integer updateEvent(Event event) throws IOException, ClassNotFoundException, SQLException, ParseException, NamingException;
}
