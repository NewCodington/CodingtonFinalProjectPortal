package codingtonportal.model.domain;

public class TypePlace {
	Integer idTypePlace;
	String Name;
	String Description;
	
	public TypePlace() {
		this.idTypePlace = 0;
		this.Name = null;
		this.Description = null;
	}
	
	public TypePlace(Integer id) {
		this.idTypePlace = id;
		this.Name = null;
		this.Description = null;
	}
	
	public TypePlace(Integer id, String name) {
		this.idTypePlace = id;
		this.Name = name;
		this.Description = null;
	}
	
	public TypePlace(Integer id, String name, String desc) {
		this.idTypePlace = id;
		this.Name = name;
		this.Description = desc;
	}
	
	public TypePlace(TypePlace type) {
		this.idTypePlace = type.getIdTypePlace();
		this.Name = type.getName();
		this.Description = type.getDescription();
	}
	
	
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
