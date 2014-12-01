package springcodingtonportal.model.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import springcodingtonportal.model.dao.PlaceDAO;
import springcodingtonportal.model.domain.Place;
import springcodingtonportal.model.mapper.PlaceMapper;
import springcodingtonportal.utils.QueriesSQL;



/**
 * 
 * Services of the Place used to select, insert, update and delete places available in the application.
 * 
 */
public class PlaceServiceJDBC implements PlaceDAO {

	@Autowired
	private ApplicationContext appContext;
	private JdbcTemplate jdbcTemplate;
	
	
	public PlaceServiceJDBC() {
		this.jdbcTemplate = null;
	}
	
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	
	/**
	 * Method to get a Place from the database. Use a Place class to input the data required.
	 * 
	 * @param place : Place class with the data necessary to get the place requested.
	 * 
	 * @return Place class with the Place requested or NULL if the place does not exists.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Place selectPlace(Place place) throws SQLException, ClassNotFoundException, NamingException {
		// Initialize variables
		Place data = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		data = jdbcTemplate.queryForObject(sql.getSelectPlace(), new Object[]{place.getIdPlace()}, new PlaceMapper());

		// Return the place or null
		return data;
	}

	
	
	/**
	 * Method to get all Places from the database.
	 * 
	 * @return ArrayList<Place> with all Places that exists or NULL if there is no Place.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public List<Place> viewPlace() throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		List <Place> selection = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		selection = jdbcTemplate.query(sql.getViewPlace(), new PlaceMapper());
		
		// Return the ArrayList of Places or null
		return selection;
	}
	
	
	
	
	/**
	 * Method to insert a Place from the database. Use a Place class to input the data required.
	 * 
	 * @param place : Place class with the data necessary to insert.
	 * 
	 * @return Number of rows affected in the database. If the insert is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer insertPlace(Place place) throws ClassNotFoundException, SQLException, NamingException {  
		// Initialize variables
		Integer result = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		// Create the Statement
		result = jdbcTemplate.update(sql.getInsertPlace(), place.getName(), place.getTypePlace(), place.getImage(), place.getAddress(), place.getDescription());
		
		// Return if Event was inserted or not 
		return result;
	} 

	
	
	
	/**
	 * Method to update a Place from the database. Use a Place class to input the data required.
	 * 
	 * @param place : Place class with the data necessary to update.
	 * 
	 * @return Number of rows affected in the database. If the update is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer updatePlace(Place place) throws ClassNotFoundException, SQLException, NamingException   {  
		// Initialize variables
		Integer result = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		// Create the Statement
		result = jdbcTemplate.update(sql.getUpdatePlace(), place.getName(), place.getTypePlace(), place.getImage(), place.getAddress(), place.getDescription(), place.getIdPlace());
		
		// Return if Event was inserted or not 
		return result;
	}
	
	
	
	/**
	 * Method to delete a Place from the database. Use a Place class to input the data required.
	 * 
	 * @param place : Place class with the data necessary to delete.
	 * 
	 * @return Number of rows affected in the database. If the delete is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer deletePlace(int idPlace) throws ClassNotFoundException, SQLException, NamingException   {  
		// Initialize variables
		Integer result = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		// Create the Statement
		result = jdbcTemplate.update(sql.getDeletePlace(), idPlace);
		
		// Return if Event was inserted or not 
		return result;
	} 

}
