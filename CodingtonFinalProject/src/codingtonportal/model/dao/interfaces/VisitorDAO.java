package codingtonportal.model.dao.interfaces;

import java.io.IOException;

import codingtonportal.model.domain.Visitor;

public interface VisitorDAO {
	/**
	 * This interface manages the methods related with visitors.
	 * @param visitor
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean insertVisitor(Visitor visitor) throws IOException, ClassNotFoundException;
	/**
	 * The visitor is registered in a the portal.
	 * @param Username
	 * @param Password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	
	public boolean loginVisitor(String Username, String Password) throws ClassNotFoundException, IOException;
	/**
	 * The visitor is logs into the portal.
	 * @param visitor
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean deleteVisitor(Visitor visitor) throws IOException, ClassNotFoundException;
	/**
	 * The visitor is deleted of the portal.
	 * @param visitor
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	
	public boolean updateInformation(Visitor visitor) throws ClassNotFoundException, IOException;
	/**
	 * The visitor updates his personal information.
	 * @param visitor
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean updatePassword(Visitor visitor) throws IOException, ClassNotFoundException;
	/**
	 * The visitor updates his password.
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public boolean selectVisitor() throws IOException, ClassNotFoundException;
	/**
	 * The administrator selects a visitor.
	 */

}
