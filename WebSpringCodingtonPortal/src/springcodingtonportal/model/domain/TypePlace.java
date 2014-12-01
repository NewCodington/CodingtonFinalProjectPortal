package springcodingtonportal.model.domain;


public class TypePlace {


	/**
	 * Parameters.
	 * @author JAVA101_01
	 *
	 */
	Integer idTypePlace;
	String Name;
	String Description;


	/**
	 * Void constructor.
	 */
	public TypePlace() {
		this.idTypePlace = 0;
		this.Name = null;
		this.Description = null;
	}
	
/**
 * Constructor with parameter id.
 * @param id
 */
	public TypePlace(Integer id) {
		this.idTypePlace = id;
		this.Name = null;
		this.Description = null;
	}
	
/**
 * Constructor with parameters.
 * @param id
 * @param name
 */
	public TypePlace(Integer id, String name) {
		this.idTypePlace = id;
		this.Name = name;
		this.Description = null;
	}
	
	/**
	 * Constructor with parameters.
	 * @param id
	 * @param name
	 * @param desc
	 */
	public TypePlace(Integer id, String name, String desc) {
		this.idTypePlace = id;
		this.Name = name;
		this.Description = desc;
	}

	/**
	 * Constructor with parameters.
	 * @param type
	 */
	public TypePlace(TypePlace type) {
		this.idTypePlace = type.getIdTypePlace();
		this.Name = type.getName();
		this.Description = type.getDescription();
	}

	
	/**
	 * GETTERS AND SETTERS.
	 * @return
	 */
	public Integer getIdTypePlace() {
		return idTypePlace;
	}
	public void setIdTypePlace(Integer idTypePlace) {
		this.idTypePlace = idTypePlace;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
}
