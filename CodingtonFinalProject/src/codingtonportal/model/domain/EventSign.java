package codingtonportal.model.domain;

public class EventSign {
	
	
	//Atribute
	private int id;
	private int idVisitor;
	private int idEvent;
	
	//Constructor
	EventSign()
	{
		this.id=0;
		this.idVisitor=0;
		this.idEvent=0;
		
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdVisitor() {
		return idVisitor;
	}

	public void setIdVisitor(int idVisitor) {
		this.idVisitor = idVisitor;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	
	

}
