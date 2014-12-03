package springcodingtonportal.model.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import springcodingtonportal.model.dao.VisitorDAO;
import springcodingtonportal.model.domain.Visitor;
import springcodingtonportal.model.mapper.VisitorMapper;
import springcodingtonportal.utils.QueriesSQL;


/**
 * Services of the Visitor used to select, insert, update and delete visitors available in the application.
 * The visitor can search Events, view all events, login into the application, ...
 * 
 */
public class VisitorServiceJDBC implements VisitorDAO {
	@Autowired
	private ApplicationContext appContext;
	private JdbcTemplate jdbcTemplate;
	
	
	public VisitorServiceJDBC() {
		this.jdbcTemplate = null;
	}
	
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	   }
	
	
	
	
	/**
	 * Method to get a Visitor from the database. Use a Visitor class to input the data required.
	 * 
	 * @param visitor : Visitor class with the data necessary to get the event requested.
	 * 
	 * @return Visitor class with the Visitor requested or NULL if the visitor does not exists.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Visitor selectVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		Visitor data = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		data = jdbcTemplate.queryForObject(sql.getSelectVisitor(), new Object[]{visitor.getIdVisitor()}, new VisitorMapper());

		// Return the Visitor or null
		return data;
	}
	
	
	
	
	
	/**
	 * Method to log in a Visitor from the application. Use a Visitor class to input the data required.
	 * 
	 * @param visitor : Visitor class with the data necessary to log in.
	 * 
	 * @return Id of the visitor if exists in the application.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Visitor loginVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		Visitor data = null;
		// Create the Statement
		try {
			data = jdbcTemplate.queryForObject(sql.getLoginVisitor(), new Object[]{visitor.getUserName(), visitor.getPassword()}, new VisitorMapper());
		
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		return data;
			
	}
	
	
	
	
	
	
	
	/**
	 * Method to get all Visitors from the database.
	 * 
	 * @return ArrayList<Visitor> with all Visitors that exists or NULL if there is no Visitor.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public List<Visitor> viewVisitor() throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		List <Visitor> selection = null;
				
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");

		// Create the Statement
		selection = jdbcTemplate.query(sql.getViewVisitor(), new VisitorMapper());
		
		// Return the ArrayList of Events or null
		return selection;
	}

	
	

	/**
	 * Method to insert a Visitor from the database. Use a Visitor class to input the data required.
	 * 
	 * @param visitor : Visitor class with the data necessary to insert.
	 * 
	 * @return Number of rows affected in the database. If the insert is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer insertVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException   {  
		// Initialize variables
		Integer result = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		// Create the Statement
		result = jdbcTemplate.update(sql.getInsertVisitor(), new Object[]{visitor.getFirstName(), visitor.getLastName(), visitor.getDni(), visitor.getEmail(), visitor.getPhoneNumber(), visitor.getAddress(), visitor.getUserName(), visitor.getPassword(), visitor.isAdmin()});
		
		// Return if Event was inserted or not 
		return result; 
	} 
	
	
	
	
	/**
	 * Method to update a Visitor from the database. Use a Visitor class to input the data required.
	 * 
	 * @param visitor : Visitor class with the data necessary to update.
	 * 
	 * @return Number of rows affected in the database. If the update is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer updateVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		Integer result = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		// Create the Statement
		result = jdbcTemplate.update(sql.getUpdateVisitor(), new Object[]{visitor.getFirstName(), visitor.getLastName(), visitor.getDni(), visitor.getEmail(), visitor.getPhoneNumber(), visitor.getAddress(), visitor.getIdVisitor()});
		
		// Return if Event was inserted or not 
		return result; 		
	}
	


	
	/**
	 * Method to update a Visitor Password from the database. Use a Visitor class to input the data required.
	 * 
	 * @param visitor : Visitor class with the data necessary to update.
	 * 
	 * @return Number of rows affected in the database. If the update is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer updatePassword(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
				Integer result = null;
				
				QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
				
				// Create the Statement
				result = jdbcTemplate.update(sql.getUpdatePassword(), new Object[]{visitor.getPassword(), visitor.getIdVisitor()});
				
				// Return if Event was inserted or not 
				return result; 	 	
	}
	
	
	
	
	/**
	 * Method to delete a Visitor from the database. Use a Visitor class to input the data required.
	 * 
	 * @param visitor : Visitor class with the data necessary to delete.
	 * 
	 * @return Number of rows affected in the database. If the delete is correct, return 1, else return 0.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer deleteVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		Integer result = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		// Create the Statement
		result = jdbcTemplate.update(sql.getDeleteVisitor(), new Object[]{visitor.getIdVisitor()});
		
		// Return if Event was inserted or not 
		return result;	
	}
		
	
	
	
	/**
	 * Method to check if the Visitor is the admin application.
	 * 
	 * @param visitor : Visitor class with the data necessary to check.
	 * 
	 * @return Boolean that indicates if the Visitor is admin or not.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public boolean isAdmin(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		Visitor v = null;

		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		try {
			v = jdbcTemplate.queryForObject(sql.getLoginVisitor(), new Object[]{visitor.getUserName(), visitor.getPassword()}, new VisitorMapper());
		
		}catch(EmptyResultDataAccessException e) {
			return false;
		}
		
		// Return indicates if is admin or not
		return v.isAdmin();
	}



	

	/**
	 * Method to check if the Username Visitor exits in the application.
	 * 
	 * @param visitor : Visitor class with the data necessary to check.
	 * 
	 * @return Boolean that indicates if the Username exits or not.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NamingException 
	 */
	@Override
	public Integer exitsUsernameVisitor(Visitor visitor) throws ClassNotFoundException, SQLException, NamingException {
		// Initialize variables
		Visitor data = null;
		
		QueriesSQL sql = (QueriesSQL) appContext.getBean("beanSQL");
		
		// Create the Statement
		try {
		data = jdbcTemplate.queryForObject(sql.getExitsUserVisitor(), new Object[]{visitor.getUserName()}, new VisitorMapper());
			
		}catch(EmptyResultDataAccessException e) {
			return -1;
		}
		// Return the Id of Visitor if exists in the application
		return data.getIdVisitor();
	}
	
}
