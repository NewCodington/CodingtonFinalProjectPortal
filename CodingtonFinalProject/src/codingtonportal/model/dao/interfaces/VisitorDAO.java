package codingtonportal.model.dao.interfaces;

import java.io.IOException;

import codingtonportal.model.domain.Visitor;

/**
 * This interface manages the methods related with visitors.
 * @param visitor
 * @return
 * @throws IOException
 * @throws ClassNotFoundException
 */
public interface VisitorDAO {
	public boolean insertVisitor(Visitor visitor) throws IOException, ClassNotFoundException;
	public boolean loginVisitor(String Username, String Password) throws ClassNotFoundException, IOException;
	public boolean deleteVisitor(Visitor visitor) throws IOException, ClassNotFoundException;
	public boolean updateInformation(Visitor visitor) throws ClassNotFoundException, IOException;
	public boolean updatePassword(Visitor visitor) throws IOException, ClassNotFoundException;
	public boolean selectVisitor() throws IOException, ClassNotFoundException;
}
