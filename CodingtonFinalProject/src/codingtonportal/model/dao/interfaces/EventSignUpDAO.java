package codingtonportal.model.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;

import codingtonportal.model.domain.Event;

/**
 * This interface manages the methods related with the registration in the events.
 * @param idVisitor
 * @param idEvent
 * @return
 * @throws ClassNotFoundException
 * @throws IOException
 */
public interface EventSignUpDAO {
	public Integer registerForNewEvent(Integer idVisitor, Integer idEvent)throws ClassNotFoundException, IOException, SQLException ;
	public Integer unregisterForEvent(Integer idVisitor, Integer idEvent)throws IOException, ClassNotFoundException, SQLException;
	public Integer updateSeatsAvailable(Event event) throws ClassNotFoundException, IOException, SQLException;
	public Integer selectEventForVisitor(Integer idEvent)throws ClassNotFoundException, IOException, SQLException ;
}
