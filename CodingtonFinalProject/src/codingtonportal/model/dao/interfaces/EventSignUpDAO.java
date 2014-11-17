package codingtonportal.model.dao.interfaces;

import java.io.IOException;


public interface EventSignUpDAO {
	/**
	 * This interface manages the methods related with the registration in the events.
	 * @param idVisitor
	 * @param idEvent
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public boolean registerForNewEvent(int idVisitor, int idEvent)throws ClassNotFoundException, IOException ;
	/**
	 * The visitor is registered in a new event.
	 * @param idVisitor
	 * @param idEvent
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean unregisterForEvent(int idVisitor, int idEvent)throws IOException, ClassNotFoundException;
	/**
	 * The visitor is unregistered for a registered event.
	 * @param Name
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean searchEvent(String Name) throws IOException,ClassNotFoundException;
	/**
	 * The visitor search a event by the name.
	 * @param Name
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean viewEvent(String Name) throws IOException,ClassNotFoundException;
	/**
	 * A list of all available events is shown.
	 */

}
