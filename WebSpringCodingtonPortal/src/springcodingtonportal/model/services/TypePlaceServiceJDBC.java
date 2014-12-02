package springcodingtonportal.model.services;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import springcodingtonportal.model.dao.TypePlaceDAO;
import springcodingtonportal.model.domain.TypePlace;
import springcodingtonportal.model.mapper.TypePlaceMapper;
import springcodingtonportal.utils.QueriesSQL;

/**
 * 
 * Services of the Type of Places used to select and view type of places available in the application.
 * 
 */
public class TypePlaceServiceJDBC implements TypePlaceDAO {

	@Autowired
	private ApplicationContext appContext;
	private JdbcTemplate jdbcTemplate;
	
	
	public TypePlaceServiceJDBC() {
		this.jdbcTemplate = null;
	}
	
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	/**
	 * Method to get all Types of Places from the database.
	 * 
	 * @return ArrayList<TypePlace> with all Types of Places that exists or NULL if there is no Type of Place.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public List<TypePlace> viewTypePlace() throws NamingException, SQLException, ClassNotFoundException {
		// Initialize variables
		List <TypePlace> selection = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		selection = jdbcTemplate.query(sql.getViewTypePlace(), new TypePlaceMapper());
		
		// Return the ArrayList of Places or null
		if (selection.size() == 0)
			return null;
		else
			return selection;
	}

	
	
	
	
	/**
	 * Method to get a Type of Place from the database. Use a Place class to input the data required.
	 * 
	 * @param TypePlace : Type of Place class with the data necessary to get the event requested.
	 * 
	 * @return TypePlace class with the Type of Place requested or NULL if the type of place does not exists.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public TypePlace selectTypePlace(TypePlace type) throws SQLException, ClassNotFoundException, NamingException {
		// Initialize variables
		TypePlace data = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		data = jdbcTemplate.queryForObject(sql.getSelectTypePlace(), new Object[]{type.getIdTypePlace()}, new TypePlaceMapper());
		
		// Return the ArrayList of Places or null
		return data;
	}

}
