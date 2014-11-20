package codingtonportal.model.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import codingtonportal.model.domain.Visitor;

/**
 * This interface manages the methods related with visitors.
 * @param visitor
 * @return
 * @throws IOException
 * @throws ClassNotFoundException
 */
public interface VisitorDAO {
	public Visitor selectVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException;
	public ArrayList<Visitor> viewVisitor() throws IOException, ClassNotFoundException, SQLException;
	public Integer loginVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException;
	public Integer insertVisitor(Visitor visitor) throws IOException, ClassNotFoundException, SQLException;
	public Integer updateVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException;
	public Integer updatePassword(Visitor visitor) throws IOException, ClassNotFoundException, SQLException;
	public Integer deleteVisitor(Visitor visitor) throws IOException, ClassNotFoundException, SQLException;	
	public Integer searchEvent(String Name) throws IOException,ClassNotFoundException;
	public Integer viewEvent(String Name) throws IOException,ClassNotFoundException;
	public boolean isAdmin(Visitor visitor) throws ClassNotFoundException, IOException, SQLException;
}
