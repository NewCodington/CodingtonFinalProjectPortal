package codingtonportal.model.domain;

import java.sql.Blob;

public class Place {
	
	//Atribute	
	private int idPlace;
	private String name;
	private String description;
	private String region;
	private Blob image;
	private String address; 
	private int typePlace; 
	
	
	//Constructor
	protected Place(){
		this.idPlace=0;
		this.name=null;
		this.description=null;
	    this.region=null;
		this.image=null;
		this.address=null;
		this.typePlace=0;
	}
	
	public Place(int idPlace, String name, String region, int typePlace, Blob image, String address, String description){
		this.idPlace=idPlace;
		this.name=name;
		this.description=description;
	    this.region=region;
		this.image=image;
		this.address=address;
		this.typePlace=typePlace;
	}
	
	
	

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

	/**
	 * @return the typePlace
	 */
	public int getTypePlace() {
		return typePlace;
	}

	/**
	 * @param typePlace the typePlace to set
	 */
	public void setTypePlace(int typePlace) {
		this.typePlace = typePlace;
	}
}
