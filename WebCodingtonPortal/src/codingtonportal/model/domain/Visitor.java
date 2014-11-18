package codingtonportal.model.domain;

public class Visitor {
	
	//Atributos

	private int idVisitor;
	private String firstName;
	private String lastName;
	private String dni;
	private String email;
	private String phoneNumber;
	private String address;
	private String userName;
	private String password;
	private boolean admin;
	private int idEvent;
	
	
	//Constructor
	public Visitor()
	{
		this.idVisitor=0;
		this.firstName=null;
		this.lastName=null;
		this.dni=null;
		this.email=null;
		this.phoneNumber=null;
		this.address=null;
		this.userName=null;
		this.password=null;
		this.admin=true;
		this.idEvent=0;
		
	}
	
	//Constructor con parametros
	public Visitor(int idVisitor, String userName, String password, String firstName,
			String lastName, String dni, String email,String phoneNumber, String address, boolean admin)
	{
		
		this.idVisitor=idVisitor;
		this.firstName=firstName;
		this.lastName=lastName;
		this.dni=dni;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.address=address;
		this.userName=userName;
		this.password=password;
		this.admin=admin;
				
	}
	
	//Constructor con parametros
	public Visitor(String userName, String password)
	{
		this.userName=userName;
		this.password=password;
				
	}
	
	
	

	//Constructor con parametros
	public Visitor(int idVisitor, int idEvent)
	{
		this.idVisitor=idVisitor;
		this.idEvent=idEvent;
				
	}
	
	
	
	
	//GETTERS AND SETTERS
	public int getVisitorId() {
		return idVisitor;
	}

	public void setVisitorId(int visitorId) {
		this.idVisitor = visitorId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdVisitor() {
		return idVisitor;
	}

	public void setIdVisitor(int idVisitor) {
		this.idVisitor = idVisitor;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}



}
