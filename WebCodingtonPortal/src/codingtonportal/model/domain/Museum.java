package codingtonportal.model.domain;

public class Museum extends Place{
	
	//Atribute
	private int idMuseum;
	private String typeMuseum;
	
	//Constructor
	
	Museum(){
		this.idMuseum=0;
		this.typeMuseum=null;
	}

	public int getIdMuseum() {
		return idMuseum;
	}

	public void setIdMuseum(int idMuseum) {
		this.idMuseum = idMuseum;
	}

	public String getTypeMuseum() {
		return typeMuseum;
	}

	public void setTypeMuseum(String typeMuseum) {
		this.typeMuseum = typeMuseum;
	}
	
	
	

}
