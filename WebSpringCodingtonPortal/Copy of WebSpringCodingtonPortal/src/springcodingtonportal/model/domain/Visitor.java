package springcodingtonportal.model.domain;

public class Visitor {

	/**
	 * Parameters.
	 */
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



	/**
	 * Void constructor.
	 */
	public Visitor()
	{
		this.idVisitor = 0;
		this.firstName = null;
		this.lastName = null;
		this.dni = null;
		this.email = null;
		this.phoneNumber = null;
		this.address = null;
		this.userName = null;
		this.password = null;
		this.admin = false;


	}

	/**
	 * Constructor with parameters except idVisitor. 
	 * This constructor is used in the following methods:
	 * insertVisitor, updateVisitor and isAdmin.
	 * @param userName
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param dni
	 * @param email
	 * @param phoneNumber
	 * @param address
	 * @param admin
	 */
	public Visitor(String userName, String password, String firstName,
			String lastName, String dni, String email,String phoneNumber, String address, boolean admin)
	{

		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.admin = admin;

	}

	/**
	 * Constructor with parameters.
	 * This constructor is used in the following methods:
	 * selectVisitor, viewVisitor and deleteVisitor.
	 * @param idVisitor
	 * @param userName
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param dni
	 * @param email
	 * @param phoneNumber
	 * @param address
	 * @param admin
	 */
	public Visitor(int idVisitor, String userName, String password, String firstName,
			String lastName, String dni, String email,String phoneNumber, String address, boolean admin)
	{

		this.idVisitor = idVisitor;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.admin = admin;

	}

	/**
	 * Constructor with userName and password.
	 * This constructor is used in the following methods:
	 * loginVisitor and updatePassword.
	 * @param userName
	 * @param password
	 */
	public Visitor(String userName, String password)
	{
		
		this.userName=userName;
		this.password=password;

	}

	/**
	 * Constructor
	 * @param visitor
	 */
	public Visitor(Visitor visitor)
	{
		
		this.idVisitor = visitor.getVisitorId();
		this.firstName = visitor.getFirstName();
		this.lastName = visitor.getLastName();
		this.dni = visitor.getDni();
		this.email = visitor.getEmail();
		this.phoneNumber = visitor.getPhoneNumber();
		this.address = visitor.getAddress();
		this.userName = visitor.getUserName();
		this.password = visitor.getPassword();
		this.admin = visitor.isAdmin();

	}

	/**
	 * GETTERS AND SETTERS.
	 * @return
	 */
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
