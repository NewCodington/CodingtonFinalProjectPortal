package codingtonportal.model.domain;

public class Market extends Place {

	//Atributes
	private int idMarket;
	private String typeMarket;
	
	//Constructor
	Market(){
		this.idMarket=0;
		this.typeMarket=null;
	}

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
