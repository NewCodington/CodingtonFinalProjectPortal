package codingtonportal.model.dao.interfaces;

import java.io.IOException;


public interface EventSignUpDAO {
	public boolean registerForNewEvent(int idVisitor, int idEvent)throws ClassNotFoundException, IOException ;
	public boolean unregisterForEvent(int idVisitor, int idEvent)throws IOException, ClassNotFoundException;
	public boolean searchEvent(String Search) throws IOException,ClassNotFoundException;
	public boolean viewEvent(String typeEvent) throws IOException,ClassNotFoundException;
}
