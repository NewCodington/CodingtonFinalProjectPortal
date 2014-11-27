package springcodingtonportal.model.domain;

public class Theatre extends Place {

	/**
	 * Parameters.
	 */
	private int idTheatre;
	
	/**
	 * Void constructor.
	 */
	Theatre()
	{
		this.idTheatre = 0;
		
	}

	/**
	 * GETTERS AND SETTERS.
	 * @return
	 */
	public int getIdTheatre() {
		return idTheatre;
	}

	public void setIdTheatre(int idTheatre) {
		this.idTheatre = idTheatre;
	}
	
		
	
}
