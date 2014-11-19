package codingtonportal.model.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;

import codingtonportal.model.domain.Visitor;

public interface VisitorDAO {
	public boolean insertVisitor(Visitor visitor) throws IOException, ClassNotFoundException, SQLException;
	public boolean loginVisitor(Visitor visitor) throws ClassNotFoundException, IOException, SQLException;
	public boolean deleteVisitor(Visitor visitor) throws IOException, ClassNotFoundException, SQLException;
	public boolean updateInformation(Visitor visitor) throws ClassNotFoundException, IOException, SQLException;
	public boolean updatePassword(Visitor visitor) throws IOException, ClassNotFoundException, SQLException;
	public boolean selectVisitor() throws IOException, ClassNotFoundException, SQLException;
	public boolean isAdmin(Visitor visitor) throws ClassNotFoundException, IOException, SQLException;
	}
