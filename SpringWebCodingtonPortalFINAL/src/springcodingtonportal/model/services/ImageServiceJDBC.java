package springcodingtonportal.model.services;

import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import springcodingtonportal.model.dao.ImageDAO;
import springcodingtonportal.model.domain.Images;
import springcodingtonportal.model.mapper.ImageBlobMapper;
import springcodingtonportal.model.mapper.ImageMapper;
import springcodingtonportal.utils.QueriesSQL;

/**
 * 
 * Services of the Type of Places used to select and view type of places available in the application.
 * 
 */
public class ImageServiceJDBC implements ImageDAO {

	@Autowired
	private ApplicationContext appContext;
	private JdbcTemplate jdbcTemplate;
	
	
	public ImageServiceJDBC() {
		this.jdbcTemplate = null;
	}
	
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public InputStream selectImage(String name) throws SQLException, ClassNotFoundException, NamingException {
		// Initialize variables
		Images data = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		//data = jdbcTemplate.queryForObject(sql.getSelectTypePlace(), new Object[]{type.getIdTypePlace()}, new TypePlaceMapper());
		try {
		data = jdbcTemplate.queryForObject(sql.getSelectImage(),new Object[]{name},new ImageMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		// Return the ArrayList of Places or null
		return data.getImages();
	}

	@Override
	public Integer insertImage(Images image) throws ClassNotFoundException, SQLException, ParseException, NamingException {
		// TODO Auto-generated method stub
		// Initialize variables
		Integer result = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		// Create the Statement
		result = jdbcTemplate.update(sql.getInsertImage(), new Object[]{image.getImages(),image.getName()});		
		
		// Return if Event was inserted or not 
		return result; 
		
	}
	
	public InputStream selectImageId(int idPlace) throws SQLException, ClassNotFoundException, NamingException {
		// Initialize variables
		Images data = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		//data = jdbcTemplate.queryForObject(sql.getSelectTypePlace(), new Object[]{type.getIdTypePlace()}, new TypePlaceMapper());
		try {
		data = jdbcTemplate.queryForObject(sql.getSelectImageId(),new Object[]{idPlace},new ImageBlobMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}

		// Return the ArrayList of Places or null
		return data.getImages();
	}


}
