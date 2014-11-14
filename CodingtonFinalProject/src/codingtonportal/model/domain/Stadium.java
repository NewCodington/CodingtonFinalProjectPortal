package codingtonportal.model.domain;

public class Stadium extends Place {

	// Atribute
	
	private int idStadium;
	private String sport;
	
	// Constructor
	
	Stadium(){
		
		this.idStadium=0;
		this.sport=null;
		
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
