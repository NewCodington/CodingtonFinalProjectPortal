package codingtonportal.model.domain;

public class Park extends Place {
	

	/**
	 * Parameters.
	 */
	private int idPark;
	private String parkCategory;


	/**
	 * Void Constructor
	 */
	Park(){
	this.idPark = 0;
	this.parkCategory = null;
	}

	/**
	 * GETTERS AND SETTERS.
	 * @return
	 */
	public int getIdPark() {
		return idPark;
	}

	public void setIdPark(int idPark) {
		this.idPark = idPark;
	}

	public String getParkCategory() {
		return parkCategory;
	}

	public void setParkCategory(String parkCategory) {
		this.parkCategory = parkCategory;
	}
	
	
}
