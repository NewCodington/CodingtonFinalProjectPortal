package codingtonportal.model.domain;

public class TouristAttraction extends Place {
	
	//Atributes
	private int idTouristAttraction;
	private String typeTouristAttraction;
	private int noPeople;
	
	//Constructor
	TouristAttraction(){
		this.idTouristAttraction=0;
		this.typeTouristAttraction=null;
		this.noPeople=0;
		
	}

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
