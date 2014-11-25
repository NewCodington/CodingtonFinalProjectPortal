/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codingtonportal.utils;


import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



/**
 *
 * @author 
 */

public class FERSDataConnection {
	Context ctx;
    Connection con;
    DataSource ds;
	
    public FERSDataConnection() throws NamingException{
    	  		
        ctx = new InitialContext();
        ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/CodingtonDB");
    	    	    	
    }    
	
    
    public Connection getConnection() throws ClassNotFoundException, SQLException, NamingException{      
        con = ds.getConnection();

      return con;
    }
  
    
    public void close() throws SQLException {	
		con.close();
	}
    
}
