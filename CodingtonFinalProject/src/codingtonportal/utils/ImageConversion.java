package codingtonportal.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageConversion {
	private FileInputStream image;
	FERSDataConnection conex;
	File photo= new File ("C:/Users/JAVA101_01/Desktop/voleibol.png");	
	
	public boolean insertImage () throws ClassNotFoundException, FileNotFoundException{
		try{
			image = new FileInputStream (photo);
			PreparedStatement statementSQL = conex.getConnection().prepareStatement("insert into codington.prueba_ester values (?,?,?);");
			statementSQL.setString(1, "name");
			statementSQL.setBinaryStream(2, image, (int) photo.length());
			statementSQL.setInt(3, 41);
			statementSQL.executeUpdate();
			statementSQL.close();
			
		}catch(SQLException e){
			return false;
		}	
		return true;		
	}
	

}
