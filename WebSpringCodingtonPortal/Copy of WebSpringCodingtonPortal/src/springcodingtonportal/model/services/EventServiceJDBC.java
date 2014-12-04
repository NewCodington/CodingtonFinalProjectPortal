package springcodingtonportal.model.services;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import springcodingtonportal.model.dao.EventDAO;
import springcodingtonportal.model.domain.Event;
import springcodingtonportal.model.mapper.EventMapper;
import springcodingtonportal.utils.QueriesSQL;



/**
 * 
 * Services of Events used to select, insert, update and delete events available in the application.
 * 
 */
public class EventServiceJDBC implements EventDAO {
	@Autowired
	private ApplicationContext appContext;
	private JdbcTemplate jdbcTemplate;
	
	
	public EventServiceJDBC() {
		this.jdbcTemplate = null;
	}
	
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	
	/**
	 * Method to get an Event from the database. Use an Event class to input the data required.
	 * 
	 * @param event : Event class with the data necessary to get the event requested.
	 * 
	 * @return Event class with the Event requested or NULL if the event does not exists.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws ParseException 
	 * @throws NamingException 
	 */
	@Override
	public Event selectEvent(Event event) throws ClassNotFoundException, SQLException, ParseException, NamingException {
		// Initialize variables
		Event data = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		data = jdbcTemplate.queryForObject(sql.getSelectEvent(), new Object[]{event.getEventId()}, new EventMapper());

		// Return the Visitor or null
		return data;
	}

	
	
	
	/**
	 * Method to get all Events from the database.
	 * 
	 * @return ArrayList<Event> with all Events that exists or NULL if there is no Event.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws ParseException 
	 * @throws NamingException 
	 */
	@Override
	public List<Event> viewEvent() throws ClassNotFoundException, SQLException, ParseException, NamingException {
		// Initialize variables
		List <Event> selection = null;
				
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		selection = jdbcTemplate.query(sql.getViewEvent(), new EventMapper());
		
		// Return the ArrayList of Events or null
		if (selection.size() == 0)
			return null;
		else
			return selection;
	}
	
	
	
	
	
	/**
	 * Method to get Events depends on type of Place from the database.
	 * 
	 * @return ArrayList<Event> with all Events or NULL if there is no Event.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws ParseException 
	 * @throws NamingException 
	 */
	@Override
	public List<Event> eventForPlace(Integer typePlace) throws ClassNotFoundException, SQLException, ParseException, NamingException {
		// Initialize variables
		List <Event> selection = null;
				
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		selection = jdbcTemplate.query(sql.getEventForPlace(), new Object[]{typePlace}, new EventMapper());
		
		// Return the ArrayList of Events or null
		if (selection.size() == 0)
			return null;
		else
			return selection;
	}
	
	
	
	
	
	/**
	 * Method to search Events for a Name from the database.
	 * 
	 * @param Name : name to search in events. 
	 * 
	 * @return ArrayList<Event> with all matching events that exists or NULL if there isn't events.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws ParseException 
	 * @throws NamingException 
	 */
	@Override
	public List<Event> searchEvent(String Name) throws ClassNotFoundException, SQLException, ParseException, NamingException {
		// Initialize variables
		List <Event> selection = null;
				
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		selection = jdbcTemplate.query(sql.getSearchEvent(), new Object[]{Name}, new EventMapper());
		
		// Return the ArrayList of Events or null
		if (selection.size() == 0)
			return null;
		else
			return selection;
	}

	
	
	
	
	
	/**
	 * Method to insert an Event from the database. Use an Event class to input the data required.
	 * 
	 * @param event : Event class with the data necessary to insert.
	 * 
	 * @return Number of rows affected in the database. If the insert is correct, return 1, else return 0.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws ParseException 
	 * @throws NamingException 
	 */
	@Override
	public Integer insertEvent(Event event) throws ClassNotFoundException, SQLException, ParseException, NamingException   {  
		// Initialize variables
		Integer result = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		// Create the Statement
		result = jdbcTemplate.update(sql.getInsertEvent(), new Object[]{event.getName(), event.getDescription(), event.getPlace(), event.getDate_event(), event.getStartTime(), event.getDuration(), event.getEventType(), event.getSeatsAvailable()});
		
		// Return if Event was inserted or not 
		return result;  
	} 
	
	
	
	/**
	 * Method to update an Event from the database. Use an Event class to input the data required.
	 * 
	 * @param event : Event class with the data necessary to update.
	 * 
	 * @return Number of rows affected in the database. If the update is correct, return 1, else return 0.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws ParseException 
	 * @throws NamingException 
	 */
	@Override
	public Integer updateEvent(Event event) throws ClassNotFoundException, SQLException, ParseException, NamingException {
		// Initialize variables
		Integer result = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		// Create the Statement
		result = jdbcTemplate.update(sql.getUpdateEvent(), new Object[]{event.getName(), event.getDescription(), event.getPlace(), event.getDate_event(), event.getStartTime(), event.getDuration(), event.getEventType(), event.getSeatsAvailable(), event.getEventId()});
		
		// Return if Event was inserted or not 
		return result;  
	}
	
	
	
	
	
	/**
	 * Method to delete an Event from the database. Use an Event class to input the data required.
	 * 
	 * @param idEvent : Event class with the data necessary to delete.
	 * 
	 * @return Number of rows affected in the database. If the delete is correct, return 1, else return 0.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer deleteEvent(Integer idEvent) throws ClassNotFoundException, SQLException, NamingException   {  
		// Initialize variables
		Integer result = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		// Create the Statement
		result = jdbcTemplate.update(sql.getDeleteEvent(), new Object[]{idEvent});
		
		// Return if Event was inserted or not 
		return result;
	}
	
}
