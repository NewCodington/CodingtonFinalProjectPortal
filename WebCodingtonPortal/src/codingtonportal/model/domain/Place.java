package codingtonportal.model.domain;

import java.sql.Blob;



public class Place {

	/**
	 * Parameters.
	 */	
	private int idPlace;
	private String name;
	private String description;
	private String region;
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
		this.region = null;
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
	public Place(int idPlace, String name, String region, int typePlace, Blob image, String address, String description){
		this.idPlace = idPlace;
		this.name = name;
		this.description = description;
		this.region = region;
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
		this.region = place.getRegion();
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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
}
