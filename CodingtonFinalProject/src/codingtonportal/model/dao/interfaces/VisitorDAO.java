package codingtonportal.model.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import codingtonportal.model.domain.Event;
import codingtonportal.model.domain.Visitor;


/**
 * The interface VisitorDAO shows the services that can be used or are related to the Visitors.
 * 
 * @author JAVA101_01
 *
 */
public interface VisitorDAO {
	public Visitor selectVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException;
	public ArrayList<Visitor> viewVisitor() throws IOException, ClassNotFoundException, SQLException;
	public Integer loginVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException;
	public Integer insertVisitor(Visitor visitor) throws IOException, ClassNotFoundException, SQLException;
	public Integer updateVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException;
	public Integer updatePassword(Visitor visitor) throws IOException, ClassNotFoundException, SQLException;
	public Integer deleteVisitor(Visitor visitor) throws IOException, ClassNotFoundException, SQLException;	
	public ArrayList<Event> searchEvent(String Name) throws IOException,ClassNotFoundException, SQLException;
	public ArrayList<Event> viewEvent() throws IOException,ClassNotFoundException, SQLException;
}
