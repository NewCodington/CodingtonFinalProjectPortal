package springcodingtonportal.model.domain;

public class Market extends Place {


	/**
	 * Parameters. 
	 */
	private int idMarket;
	private String typeMarket;
	
	/**
	 * Void Constructor 
	 */
	Market(){
		this.idMarket = 0;
		this.typeMarket = null;
	}

	/**
	 * GETTERS AND SETTERS
	 * @return
	 */
	public int getIdMarket() {
		return idMarket;
	}

	public void setIdMarket(int idMarket) {
		this.idMarket = idMarket;
	}

	public String getTypeMarket() {
		return typeMarket;
	}

	public void setTypeMarket(String typeMarket) {
		this.typeMarket = typeMarket;
	}
	
}
