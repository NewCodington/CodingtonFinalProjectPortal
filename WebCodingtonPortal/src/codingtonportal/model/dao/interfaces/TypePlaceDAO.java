package codingtonportal.model.dao.interfaces;

import java.util.ArrayList;

import codingtonportal.model.domain.TypePlace;

/**
 * 
 * The interface PlaceDAO shows the services that can be used or are related to the Places.
 * 
 * @author JAVA101_01
 *
 */
public interface TypePlaceDAO {
	public ArrayList<TypePlace> viewTypePlace();
	public TypePlace selectTypePlace(TypePlace type);
}
