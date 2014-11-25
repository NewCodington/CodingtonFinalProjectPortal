package codingtonportal.model.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import codingtonportal.model.domain.RegionPlace;

/**
 * 
 * The interface RegionPlaceDAO shows the services that can be used or are related to the Regions Places.
 * 
 * @author JAVA101_01
 *
 */
public interface RegionPlaceDAO {
	public ArrayList<RegionPlace> viewRegionPlace() throws SQLException, ClassNotFoundException, NamingException;
	public RegionPlace selectRegionPlace(RegionPlace region) throws SQLException, ClassNotFoundException, NamingException;
}
