package codingtonportal.model.domain;

public class Stadium extends Place {

	// Parameters
	
	private int idStadium;
	private String sport;
	
	// Void constructor
	
	Stadium(){
		
		this.idStadium = 0;
		this.sport = null;
		
	}

	public int getIdStadium() {
		return idStadium;
	}

	public void setIdStadium(int idStadium) {
		this.idStadium = idStadium;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}
	
		
}
