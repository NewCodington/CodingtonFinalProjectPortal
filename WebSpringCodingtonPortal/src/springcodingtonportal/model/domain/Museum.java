package springcodingtonportal.model.domain;

public class Museum extends Place{
	
	/**
	 * Parameters.
	 */
	private int idMuseum;
	private String typeMuseum;
	
	/**
	 * Void Constructor
	 */		
	Museum(){
		this.idMuseum = 0;
		this.typeMuseum = null;
	}

	/**
	 * GETTERS AND SETTERS.
	 * @return
	 */
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
