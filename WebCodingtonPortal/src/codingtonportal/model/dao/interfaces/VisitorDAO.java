package codingtonportal.model.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

import codingtonportal.model.domain.Visitor;


/**
 * 
 * The interface VisitorDAO shows the services that can be used or are related to the Visitors.
 * 
 * @author JAVA101_01
 *
 */
public interface VisitorDAO {
	public Visitor selectVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;
	public ArrayList<Visitor> viewVisitor() throws ClassNotFoundException, SQLException, NamingException;
	public Integer loginVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;
	public Integer exitsUsernameVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;
	public Integer insertVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;
	public Integer updateVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;
	public Integer updatePassword(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;
	public Integer deleteVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;	
	public boolean isAdmin(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;
}
