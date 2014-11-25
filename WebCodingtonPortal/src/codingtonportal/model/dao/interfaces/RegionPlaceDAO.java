package codingtonportal.model.dao.interfaces;

import java.util.ArrayList;

import codingtonportal.model.domain.RegionPlace;

/**
 * 
 * The interface PlaceDAO shows the services that can be used or are related to the Places.
 * 
 * @author JAVA101_01
 *
 */
public interface RegionPlaceDAO {
	public ArrayList<RegionPlace> viewRegionPlace();
	public RegionPlace selectRegionPlace(RegionPlace region);
}
