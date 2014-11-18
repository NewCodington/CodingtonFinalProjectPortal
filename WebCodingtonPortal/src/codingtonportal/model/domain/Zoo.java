package codingtonportal.model.domain;

public class Zoo extends Place{
	
	//Atributes
	private int idZoo;
	private int noOfAnimals;
	private String nameAnimals;
	
	//Constructor
	
	Zoo(){
		this.idZoo=0;
		this.noOfAnimals=0;
		this.nameAnimals=null;
	}

	public int getIdZoo() {
		return idZoo;
	}

	public void setIdZoo(int idZoo) {
		this.idZoo = idZoo;
	}

	public int getNoOfAnimals() {
		return noOfAnimals;
	}

	public void setNoOfAnimals(int noOfAnimals) {
		this.noOfAnimals = noOfAnimals;
	}

	public String getNameAnimals() {
		return nameAnimals;
	}

	public void setNameAnimals(String nameAnimals) {
		this.nameAnimals = nameAnimals;
	}

}
