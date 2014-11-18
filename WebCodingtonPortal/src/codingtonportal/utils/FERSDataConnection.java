/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codingtonportal.utils;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author 
 */

public class FERSDataConnection {
     // las variables hay que cambiarlas
//    private String url= "jdbc:oracle:thin:@localhost:1521:xe";
	static Connection connection ;
	private String driver;
	private String url;
    private String user;
    private String pass;
    
	
    public FERSDataConnection() throws IOException{
    	PropertyAccess conexion= new PropertyAccess();
    	
    	this.driver=conexion.getProperty("driver");
    	this.url=conexion.getProperty("connection");
    	this.user= conexion.getProperty("username");
    	this.pass= conexion.getProperty("password");
    	
    }
    
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUser (){
		return user;
	}
	
	public void setUser (String user){
		this.user= user;
	}
	
	public String getPass (){
		return pass;
	}
	
	public void setPass(String pass){
		this.pass=pass;
	}
    
  public Connection getConnection() throws ClassNotFoundException, SQLException{
      
          //Cargamos el driver que está en libraries mysql y establecemos la conexión.
    	  
    	  
			Class.forName(this.driver);
			connection = DriverManager.getConnection(this.url, this.user, this.pass);

      return connection;
  }
  
  public void close() throws SQLException
	{	
		connection.close();
	}
    
}
