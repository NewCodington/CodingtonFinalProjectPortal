package springcodingtonportal.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import springcodingtonportal.model.domain.RegionPlace;
import springcodingtonportal.model.domain.TypePlace;

/**
 * 
 * The interface RegionPlaceDAO shows the services that can be used or are related to the Regions Places.
 * 
 * @author JAVA101_01
 *
 */
public interface RegionPlaceDAO {
	public List<RegionPlace> viewRegionPlace() throws SQLException, ClassNotFoundException, NamingException;
	public RegionPlace selectRegionPlace(RegionPlace region) throws SQLException, ClassNotFoundException, NamingException;
	public RegionPlace getRegionPlace(TypePlace typePlace) throws SQLException, ClassNotFoundException, NamingException;
}
