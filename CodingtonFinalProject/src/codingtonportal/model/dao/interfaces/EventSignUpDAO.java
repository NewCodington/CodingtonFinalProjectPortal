package codingtonportal.model.dao.interfaces;

import java.io.IOException;

/**
 * This interface manages the methods related with the registration in the events.
 * @param idVisitor
 * @param idEvent
 * @return
 * @throws ClassNotFoundException
 * @throws IOException
 */
public interface EventSignUpDAO {
	public boolean registerForNewEvent(int idVisitor, int idEvent)throws ClassNotFoundException, IOException ;
	public boolean unregisterForEvent(int idVisitor, int idEvent)throws IOException, ClassNotFoundException;
	public boolean searchEvent(String Name) throws IOException,ClassNotFoundException;
	public boolean viewEvent(String Name) throws IOException,ClassNotFoundException;

}
