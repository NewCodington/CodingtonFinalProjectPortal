package codingtonportal.model.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import codingtonportal.model.domain.Event;


/**
 * The interface EventSignUpDAO shows the services that can be used or are related to the Events Registrations.
 * 
 * @author JAVA101_01
 *
 */
public interface EventSignUpDAO {
	public Integer registerForNewEvent(Integer idVisitor, Integer idEvent)throws ClassNotFoundException, IOException, SQLException ;
	public Integer unregisterForEvent(Integer idVisitor, Integer idEvent)throws IOException, ClassNotFoundException, SQLException;
	public Integer updateSeatsAvailable(Event event) throws ClassNotFoundException, IOException, SQLException;
	public ArrayList<Integer> selectEventForVisitor(Integer idEvent)throws ClassNotFoundException, IOException, SQLException ;
	public Integer selectVisitorForEvent(Integer idEvent)throws ClassNotFoundException, IOException, SQLException ;
}
