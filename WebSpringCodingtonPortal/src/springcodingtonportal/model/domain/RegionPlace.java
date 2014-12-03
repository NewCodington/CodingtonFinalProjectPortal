package springcodingtonportal.model.domain;

public class RegionPlace {
	
	/**
	 * Parameters
	 */
	Integer idRegionPlace;
	String Name;
	String Description;
	
	/**
	 * void constructor
	 */
	public RegionPlace() {
		this.idRegionPlace = 0;
		this.Name = null;
		this.Description = null;
	}
	
	/**
	 * Constructor with parameters.
	 * @param id
	 */
	public RegionPlace(Integer id) {
		this.idRegionPlace = id;
		this.Name = null;
		this.Description = null;
	}
	
	/**
	 * Constructor with parameters.
	 * @param id
	 * @param name
	 */
	public RegionPlace(Integer id, String name) {
		this.idRegionPlace = id;
		this.Name = name;
		this.Description = null;
	}
	
	/**
	 * Constructor with parameters.
	 * @param id
	 * @param name
	 * @param desc
	 */
	public RegionPlace(Integer id, String name, String desc) {
		this.idRegionPlace = id;
		this.Name = name;
		this.Description = desc;
	}
	
	/**
	 * Constructor with parameters.
	 * @param region
	 */
	public RegionPlace(RegionPlace region) {
		this.idRegionPlace = region.getIdRegionPlace();
		this.Name = region.getName();
		this.Description = region.getDescription();
	}
	
	/**
	 * GETTERS AND SETTERS
	 * @return
	 */
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
