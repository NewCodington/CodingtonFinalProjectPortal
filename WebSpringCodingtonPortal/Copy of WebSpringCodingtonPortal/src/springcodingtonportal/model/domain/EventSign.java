package springcodingtonportal.model.domain;

public class EventSign {

	/**
	 * Parameters.
	 */
	private int id;
	private int idVisitor;
	private int idEvent;

	/**
	 * Void constructor.
	 */
	public EventSign()
	{
		this.id = 0;
		this.idVisitor = 0;
		this.idEvent = 0;
	}
	
		

	/**
	 * Constructor with idVisitor and idEvent.
	 * This constructor is used in the following methods:
	 * registerForNewEvent, unregisterForEvent, incrementSeats, decrementSeats, selectEventForVisitor and selectVisitorForEvent.
	 * @param idVisitor
	 * @param idEvent
	 */
	public EventSign(int idVisitor, int idEvent)
	{
		this.idVisitor = idVisitor;
		this.idEvent = idEvent;
	}
	
	

	/**
	 * GETTERS AND SETTERS.
	 * @return
	 */
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
