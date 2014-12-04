package springcodingtonportal.model.services;


import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import springcodingtonportal.model.dao.RegionPlaceDAO;
import springcodingtonportal.model.domain.RegionPlace;
import springcodingtonportal.model.domain.TypePlace;
import springcodingtonportal.model.mapper.RegionPlaceMapper;
import springcodingtonportal.utils.QueriesSQL;



/**
 * 
 * Services of the Region of Places used to select and view type of places available in the application.
 * 
 */
public class RegionPlaceServiceJDBC implements RegionPlaceDAO {

	@Autowired
	private ApplicationContext appContext;
	private JdbcTemplate jdbcTemplate;
	
	
	public RegionPlaceServiceJDBC() {
		this.jdbcTemplate = null;
	}
	
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	
	/**
	 * Method to get all Region of Places from the database.
	 * 
	 * @return ArrayList<RegionPlace> with all Region of Places that exists or NULL if there is no Region of Place.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public List<RegionPlace> viewRegionPlace() throws SQLException, ClassNotFoundException, NamingException {
		// Initialize variables
		List <RegionPlace> selection = null;
				
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		selection = jdbcTemplate.query(sql.getViewTypePlace(), new RegionPlaceMapper());
		
		// Return the ArrayList of Places or null
		if (selection.size() == 0)
			return null;
		else
			return selection;
	}

	
	
	
	
	/**
	 * Method to get a Region of Place from the database. Use a Place class to input the data required.
	 * 
	 * @param regionPlace : RegionPlace class with the data necessary to get the region of place requested.
	 * 
	 * @return RegionPlace class with the Region of Place requested or NULL if the region of place does not exists.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public RegionPlace selectRegionPlace(RegionPlace region) throws SQLException, ClassNotFoundException, NamingException {
		// Initialize variables
		RegionPlace data = null;
				
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		data = jdbcTemplate.queryForObject(sql.getSelectRegionPlace(), new Object[]{region.getIdRegionPlace()}, new RegionPlaceMapper());
		
		// Return the ArrayList of Places or null
		return data;
	}





	
	/**
	 * Method to get a Region of Place from the database. Use a Type Place class to input the data required.
	 * 
	 * @param typePlace : TypePlace class with the data necessary to get the region of place requested.
	 * 
	 * @return RegionPlace class with the Region of Place requested or NULL if the region of place does not exists.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public RegionPlace getRegionPlace(TypePlace typePlace) throws SQLException,ClassNotFoundException, NamingException {
		// Initialize variables
		RegionPlace data = null;
				
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		data = jdbcTemplate.queryForObject(sql.getGetRegionPlace(), new Object[]{typePlace.getIdTypePlace()}, new RegionPlaceMapper());
		
		// Return the ArrayList of Places or null
		return data;
	}
	
}