package codingtonportal.model.domain;

import java.sql.Blob;
import java.sql.SQLException;

import javax.naming.NamingException;

import codingtonportal.model.dao.interfaces.RegionPlaceDAO;
import codingtonportal.model.dao.interfaces.TypePlaceDAO;
import codingtonportal.model.services.RegionPlaceServiceImpl;
import codingtonportal.model.services.TypePlaceServiceImpl;



public class Place {

	/**
	 * Parameters.
	 */	
	private int idPlace;
	private String name;
	private String description;
	private Blob image;
	private String address; 
	private int typePlace; 


	/**
	 * Void constructor.
	 */
	public Place(){
		this.idPlace = 0;
		this.name = null;
		this.description = null;
		this.image = null;
		this.address = null;
		this.typePlace = 0;
	}


	/**
	 * Constructor with parameters.
	 * This constructor is used in the following methods:
	 * selectPlace, viewPlace, insertPlace, updatePlace and deletePlace.
	 * @param idPlace
	 * @param name
	 * @param region
	 * @param typePlace
	 * @param image
	 * @param address
	 * @param description
	 */
	public Place(int idPlace, String name, int typePlace, Blob image, String address, String description){
		this.idPlace = idPlace;
		this.name = name;
		this.description = description;
		this.image = image;
		this.address = address;
		this.typePlace = typePlace;
	}
	
	/**
	 * Constructor with parameters.
	 * @param place
	 */
	public Place(Place place)
	{
		this.idPlace = place.getIdPlace();

		this.name = place.getName();
		this.description = place.getDescription();
		this.image = place.getImage();
		this.address = place.getAddress();
		this.typePlace = place.getTypePlace();
	}



	/**
	 * GETTERS AND SETTERS.
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(int idPlace) {
		this.idPlace = idPlace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}


	public int getTypePlace() {
		return typePlace;
	}


	public void setTypePlace(int typePlace) {
		this.typePlace = typePlace;
	}
	
	public String getTypePlaceString() throws ClassNotFoundException, SQLException, NamingException{
		TypePlaceServiceImpl regionPlaceService = new TypePlaceServiceImpl();
		TypePlace p = new TypePlace();
		TypePlace pOut;
		
		p.setIdTypePlace(this.typePlace);
		pOut = regionPlaceService.selectTypePlace(p);
		p=null;
		return pOut.getName();			
	}
	
	public String getRegionString(int typePlace) throws ClassNotFoundException, SQLException, NamingException{
		RegionPlaceServiceImpl regionPlaceService = new RegionPlaceServiceImpl();
		TypePlace p = new TypePlace();
		RegionPlace pOut;
		
		p.setIdTypePlace(typePlace);
		pOut = regionPlaceService.getRegionPlace(p);
		p=null;
		return pOut.getName();		
	}
}
