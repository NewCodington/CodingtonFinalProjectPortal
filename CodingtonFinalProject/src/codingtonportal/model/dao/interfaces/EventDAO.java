package codingtonportal.model.dao.interfaces;

import java.io.IOException;

import codingtonportal.model.domain.Event;

public interface EventDAO {
	/**
	 * This interface manages the methods relate with the events.
	 * @param event
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public boolean insertEvent(Event event) throws IOException, ClassNotFoundException;
	/**
	 * The admin inserts events.
	 * @param event
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean deleteEvent(Event event) throws IOException, ClassNotFoundException;
	/**
	 * The admin deletes events from the list of events.
	 * @param event
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean updateEvent(Event event) throws IOException, ClassNotFoundException;
	/**
	 * The admin update the event.
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean selectEvent () throws IOException, ClassNotFoundException;
	/**
	 * Select a event.
	 */

}
