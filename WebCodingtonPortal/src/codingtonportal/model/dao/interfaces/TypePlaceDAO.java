package codingtonportal.model.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import codingtonportal.model.domain.TypePlace;

/**
 * 
 * The interface PlaceDAO shows the services that can be used or are related to the Places.
 * 
 * @author JAVA101_01
 *
 */
public interface TypePlaceDAO {
	public ArrayList<TypePlace> viewTypePlace() throws NamingException, SQLException, ClassNotFoundException;
	public TypePlace selectTypePlace(TypePlace type) throws SQLException, ClassNotFoundException, NamingException;
}
