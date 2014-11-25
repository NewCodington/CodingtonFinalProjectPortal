package codingtonportal.model.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;


/**
 * 
 * The interface EventSignUpDAO shows the services that can be used or are related to the Events Registrations.
 * 
 * @author JAVA101_01
 *
 */
public interface EventSignUpDAO {
	public Integer registerForNewEvent(Integer idVisitor, Integer idEvent)throws ClassNotFoundException, SQLException, NamingException, IOException ;
	public Integer unregisterForEvent(Integer idVisitor, Integer idEvent)throws ClassNotFoundException, SQLException, NamingException, IOException;
	public Integer incrementSeats(Integer idEvent) throws ClassNotFoundException, SQLException, NamingException;
	public Integer decrementSeats(Integer idEvent) throws ClassNotFoundException, SQLException, NamingException;
	public ArrayList<Integer> selectEventForVisitor(Integer idEvent)throws ClassNotFoundException, SQLException, NamingException ;
	public Integer selectVisitorForEvent(Integer idVisitor, Integer idEvent)throws ClassNotFoundException, SQLException, NamingException ;
}
