package springcodingtonportal.model.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import springcodingtonportal.model.dao.EventSignUpDAO;
import springcodingtonportal.model.domain.EventSign;
import springcodingtonportal.model.mapper.EventSignUpMapper;
import springcodingtonportal.utils.QueriesSQL;



/**
 * 
 * Services of the Event Registration used to register or unregister for Events and update the seats of the Events. 
 * 
 */
public class EventSignUpServiceJDBC implements EventSignUpDAO {

	@Autowired
	private ApplicationContext appContext;
	private JdbcTemplate jdbcTemplate;
	
	
	public EventSignUpServiceJDBC() {
		this.jdbcTemplate = null;
	}
	
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	
	/**
	 * Method to register a Visitor into an Event if the Visitor not is registered in that Event.
	 * 
	 * @param idVisitor	: the Id of the Visitor to register in the Event. 
	 * @param idEvent	: the Id of the event in which register the user wants.
	 * 
	 * @return Number of rows affected in the database. If the register is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	public Integer registerForNewEvent(Integer idVisitor, Integer idEvent) throws ClassNotFoundException, SQLException, NamingException, IOException {
		// Initialize variables
		Integer idVisitorRegistered = selectVisitorForEvent(idEvent, idVisitor);
		Integer result = null;
		
		// If the visitor isn't registered
		if (idVisitorRegistered == -1) {
			// Update seats if available
			Integer seatsAvailable = decrementSeats(idEvent);
			
			// If seats availabe, register a Visitor into Event
			if (seatsAvailable != 0) {
				QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
				
				// Create the Statement
				result = jdbcTemplate.update(sql.getRegisterForNewEvent(), new Object[]{idVisitor, idEvent});

			}
			
		}
		// Return if Visitor was registered or not 
		return result; 
	}

	
	
	
	/**
	 * Method to unregister a Visitor to an Event if the Visitor is registered in that Event.
	 * 
	 * @param idVisitor	: the Id of the Visitor to unregister in the Event. 
	 * @param idEvent	: the Id of the event in which unregister the user wants.
	 * 
	 * @return Number of rows affected in the database. If the unregister is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	public Integer unregisterForEvent(Integer idVisitor, Integer idEvent) throws ClassNotFoundException, SQLException, NamingException, IOException {
		// Initialize variables
		Integer result = null;
		
		// Update seats if available
		Integer seatsAvailable = incrementSeats(idEvent);
		
		// Unregister for Event
		if (seatsAvailable != null) {
			QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
			
			// Create the Statement
			result = jdbcTemplate.update(sql.getUnregisterForEvent(), new Object[]{idVisitor, idEvent});
		}
		
		// Return if Visitor was unregistered or not 
		return result;  	
	}

	
	
	
	/**
	 * Method to update the seats available in the event especified.
	 * 
	 * @param event	: the Event to update the seats available. 
	 * 
	 * @return Number of seats available after update it, if the Event hasn't got seats, return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer incrementSeats(Integer idEvent) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		Integer seats = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		// Create the Statement
		seats = jdbcTemplate.queryForInt(sql.getSelectSeats(),  idEvent);
		seats++;
		// Create the Statement
		jdbcTemplate.update(sql.getUpdateSeats(), new Object[]{seats, idEvent});
					
		// Return if Visitor was unregistered or not 
		return seats;  	
	}

	
	
	
	
	/**
	 * Method to update the seats available in the event especified.
	 * 
	 * @param event	: the Event to update the seats available. 
	 * 
	 * @return Number of seats available after update it, if the Event hasn't got seats, return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer decrementSeats(Integer idEvent) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		Integer seats = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		// Create the Statement
		seats = jdbcTemplate.queryForInt(sql.getSelectSeats(),  idEvent);
		
		if (seats > 0) {
			seats--;
			// Create the Statement
			jdbcTemplate.update(sql.getUpdateSeats(), new Object[]{seats, idEvent});
			
		}
		// If the seats are 0, not if it decreases
		else {
			seats = 0;
		}
					
		// Return if Visitor was unregistered or not 
		return seats;  	 	
	}


	
	/**
	 * Method to obtain all Ids of Events in which Visitor is registered.
	 * 
	 * @param idVisitor	: the Id of the Visitor to obtain the Events registered. 
	 * 
	 * @return ArrayList of Ids of Events or NULL if the Visitor isn't registered.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public List<EventSign> selectEventForVisitor(Integer idVisitor) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		List<EventSign> selection = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		// Create the Statement
		selection = jdbcTemplate.query(sql.getSelectEventForVisitor(),  new Object[]{idVisitor}, new EventSignUpMapper());
		
		// Return the Event's Ids registered for Visitor or not
		if (selection.size() == 0)
			return null;
		else
			return selection;
	}



	/**
	 * Method to obtain if the Event has registered this Visitor.
	 * 
	 * @param idVisitor	: the Id of the Visitor to to check if is registered.
	 * @param idEvent	: the Id of the Event to check if the visitor is registered. 
	 * 
	 * @return Visitor's Id if is registered in the Event or null if isn't registered.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer selectVisitorForEvent(Integer idEvent, Integer idVisitor) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		Integer result = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		try {
		// Create the Statement
		result = jdbcTemplate.queryForInt(sql.getSelectVisitorForEvent(),  new Object[]{idEvent, idVisitor});
		
		}catch(EmptyResultDataAccessException e) {
			return -1;
		}	
		
		// Return the Visitor's Ids registered for that Event or null
		return result;
	}

}