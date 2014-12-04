package springcodingtonportal.model.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;


import javax.naming.NamingException;


import springcodingtonportal.model.domain.Images;


/**
 * 
 * The interface TypePlaceDAO shows the services that can be used or are related to the Type of the Places.
 * 
 * @author JAVA101_01
 *
 */
public interface ImageDAO {
	
	public InputStream selectImage(String name) throws SQLException, ClassNotFoundException, NamingException;
	public Integer insertImage(Images image) throws ClassNotFoundException, SQLException, ParseException, NamingException;


}
