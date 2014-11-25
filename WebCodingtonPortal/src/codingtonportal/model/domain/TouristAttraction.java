package codingtonportal.model.domain;

public class TouristAttraction extends Place {
	
	/**
	 * Parameters.
	 */
	private int idTouristAttraction;
	private String typeTouristAttraction;
	private int noPeople;
	
	/**
	 * Void constructor.
	 */
	TouristAttraction(){
		this.idTouristAttraction = 0;
		this.typeTouristAttraction = null;
		this.noPeople = 0;
		
	}

	/**
	 * GETTERS AND SETTERS.
	 * @return
	 */
	public int getIdTouristAttraction() {
		return idTouristAttraction;
	}

	public void setIdTouristAttraction(int idTouristAttraction) {
		this.idTouristAttraction = idTouristAttraction;
	}

	public String getTypeTouristAttraction() {
		return typeTouristAttraction;
	}

	public void setTypeTouristAttraction(String typeTouristAttraction) {
		this.typeTouristAttraction = typeTouristAttraction;
	}

	public int getNoPeople() {
		return noPeople;
	}

	public void setNoPeople(int noPeople) {
		this.noPeople = noPeople;
	}

}
