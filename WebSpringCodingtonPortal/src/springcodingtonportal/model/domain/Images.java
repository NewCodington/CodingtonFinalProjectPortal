package springcodingtonportal.model.domain;

import java.io.InputStream;


public class Images {


	/**
	 * Parameters.
	 * @author JAVA101_01
	 *
	 */
	InputStream images;
	String Name;
	


	/**
	 * Void constructor.
	 */
	public Images() {
		this.images= null;
		this.Name = null;		
	}


	
	public Images(String name) {
		this.Name = name;
	}


	/**
	 * GETTERS AND SETTERS.
	 * @return
	 */

	public InputStream getImages() {
		return images;
	}



	public void setImages(InputStream images) {
		this.images = images;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}
	

}
