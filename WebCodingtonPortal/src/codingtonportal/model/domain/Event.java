package codingtonportal.model.domain;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Event {

	//Parameter
	private int eventId;
	private String name;
	private String description;
	private int place;
	private String duration;
	private String startTime;
	private String eventType;
	private int seatsAvailable;
	private Date date_event;
	
	
	
	// void Constructor
	public Event()
	{
		this.eventId = 0;
		this.name = null;
		this.description = null;
		this.place = 0;
		this.duration = null;
		this.startTime = null;
		this.eventType = null;
		this.seatsAvailable = 0;
		this.date_event = null;
	}

	//Constructor with parameters
	public Event(int eventId, String name, String description, int place,
			String duration, String startTime, String eventType, int seatsAvailable, Date date_event)
	{
		this.eventId = eventId;
		this.name = name;
		this.description = description;
		this.place = place;
		this.duration = duration;
		this.startTime = startTime;
		this.eventType = eventType;
		this.seatsAvailable = seatsAvailable;
		this.date_event = date_event;
		
	}
	
	//Constructor with parameters except id
	public Event(String name, String description, int place,
			String duration, String startTime, String eventType, int seatsAvailable, Date date_event)
	{		
		this.name = name;
		this.description = description;
		this.place = place;
		this.duration = duration;
		this.startTime = startTime;
		this.eventType = eventType;
		this.seatsAvailable = seatsAvailable;
		this.date_event = date_event;
		
	}
	
	//Constructor with parameters
	public Event(Event event) throws ParseException
	{
		this.eventId = event.getEventId();
		this.name = event.getName();
		this.description = event.getDescription();
		this.place = event.getPlace();
		this.duration = event.getDuration();
		this.startTime = event.getStartTime();
		this.eventType = event.getEventType();
		this.seatsAvailable = event.getSeatsAvailable();
		this.date_event = event.getDate_event();
	}
	
	
	
	
	//GETTERS AND SETTERS
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public Date getDate_event() throws ParseException {
		return this.date_event;
	}


	public void setDate_event(java.util.Date dateInput) throws ParseException {
		SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd" );
		java.util.Date dateOutput = targetFormat.parse(targetFormat.format(dateInput));
		
		this.date_event = new Date(dateOutput.getTime());
	}

	public String getDate_eventString() throws ParseException {
		SimpleDateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy" );
		
		java.util.Date dateOutput = targetFormat.parse(targetFormat.format(this.date_event));
		String dateString = targetFormat.format(dateOutput);
		
		return dateString;
		
	}


}
