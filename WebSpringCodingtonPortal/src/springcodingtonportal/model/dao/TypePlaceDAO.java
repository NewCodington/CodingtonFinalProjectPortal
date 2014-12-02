package springcodingtonportal.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import springcodingtonportal.model.domain.TypePlace;

/**
 * 
 * The interface TypePlaceDAO shows the services that can be used or are related to the Type of the Places.
 * 
 * @author JAVA101_01
 *
 */
public interface TypePlaceDAO {
	public List<TypePlace> viewTypePlace() throws NamingException, SQLException, ClassNotFoundException;
	public TypePlace selectTypePlace(TypePlace type) throws SQLException, ClassNotFoundException, NamingException;
}
