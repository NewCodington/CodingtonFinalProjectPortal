package springcodingtonportal.model.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;

import springcodingtonportal.model.domain.Event;


/**
 * 
 * The interface EventDAO shows the services that can be used or are related to the Events.
 * 
 * @author JAVA101_01
 *
 */
public interface EventDAO {
	public Event selectEvent (Event event) throws ClassNotFoundException, SQLException, ParseException, NamingException;
	public List<Event> viewEvent () throws ClassNotFoundException, SQLException, ParseException, NamingException;
	public List<Event> eventForPlace (Integer typePlace) throws ClassNotFoundException, SQLException, ParseException, NamingException;
	public List<Event> searchEvent(String Name) throws ClassNotFoundException, SQLException, ParseException, NamingException;
	public Integer insertEvent(Event event) throws ClassNotFoundException, SQLException, ParseException, NamingException;
	public Integer deleteEvent(Integer idEvent) throws ClassNotFoundException, SQLException, NamingException;
	public Integer updateEvent(Event event) throws ClassNotFoundException, SQLException, ParseException, NamingException;
}
