package springcodingtonportal.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import springcodingtonportal.model.domain.Visitor;


/**
 * 
 * The interface VisitorDAO shows the services that can be used or are related to the Visitors.
 * 
 * @author JAVA101_01
 *
 */
public interface VisitorDAO {
	public Visitor selectVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;
	public List<Visitor> viewVisitor() throws ClassNotFoundException, SQLException, NamingException;
	public Visitor loginVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;
	public Integer exitsUsernameVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;
	public Integer insertVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;
	public Integer updateVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;
	public Integer updatePassword(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;
	public Integer deleteVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;	
	public boolean isAdmin(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException;
}
