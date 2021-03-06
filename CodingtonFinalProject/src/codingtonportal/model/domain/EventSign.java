package codingtonportal.model.domain;

public class EventSign {


	//Parameters
	private int id;
	private int idVisitor;
	private int idEvent;
	private String Name;

	//Void constructor
	public EventSign()
	{
		this.id = 0;
		this.idVisitor = 0;
		this.idEvent = 0;

	}
	
	//Constructor with parameters
	public EventSign(int idVisitor, int idEvent, String Name)
	{
		this.idVisitor = idVisitor;
		this.idEvent = idEvent;
		this.Name = Name;
	}
		

	//Constructor with idVisitor and idEvent
	public EventSign(int idVisitor, int idEvent)
	{
		this.idVisitor = idVisitor;
		this.idEvent = idEvent;

	}
	
	//Constructor with Name
	public EventSign(String Name)
	{
		this.Name = Name;
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

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}


}
