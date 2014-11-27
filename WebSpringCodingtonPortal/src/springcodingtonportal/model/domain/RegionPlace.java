package springcodingtonportal.model.domain;

public class RegionPlace {
	
	Integer idRegionPlace;
	String Name;
	String Description;
	
	public RegionPlace() {
		this.idRegionPlace = 0;
		this.Name = null;
		this.Description = null;
	}
	
	public RegionPlace(Integer id) {
		this.idRegionPlace = id;
		this.Name = null;
		this.Description = null;
	}
	
	public RegionPlace(Integer id, String name) {
		this.idRegionPlace = id;
		this.Name = name;
		this.Description = null;
	}
	
	public RegionPlace(Integer id, String name, String desc) {
		this.idRegionPlace = id;
		this.Name = name;
		this.Description = desc;
	}
	
	public RegionPlace(RegionPlace region) {
		this.idRegionPlace = region.getIdRegionPlace();
		this.Name = region.getName();
		this.Description = region.getDescription();
	}
	
	
	public Integer getIdRegionPlace() {
		return idRegionPlace;
	}
	public void setIdRegionPlace(Integer idRegionPlace) {
		this.idRegionPlace = idRegionPlace;
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
