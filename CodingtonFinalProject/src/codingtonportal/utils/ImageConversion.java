package codingtonportal.utils;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import codingtonportal.model.domain.Place;

public class ImageConversion {
	private FileInputStream image;
	
	File photo= new File ("C:/Users/JAVA101_01/Desktop/voleibol.png");	
	
	public boolean insertImage () throws ClassNotFoundException, IOException{
		FERSDataConnection conex= new FERSDataConnection(); 
		try{
			image = new FileInputStream (photo);
			PreparedStatement statementSQL = conex.getConnection().prepareStatement
					("insert into codington.prueba_ester values (?,?,?);");
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
	
	public boolean showImage () throws ClassNotFoundException, IOException{
		FERSDataConnection conex= new FERSDataConnection(); 
		ArrayList <Place> selection = new ArrayList <Place>();
		
		try{			
			Statement sentencia = (conex.getConnection()).createStatement();
			ResultSet outdata= sentencia.executeQuery("select imagen from codington.prueba_ester");			
			while (outdata.next()){
				Place  places = new Place();
				Blob blob = outdata.getBlob("imagen");
				byte[] image = blob.getBytes(1,(int) blob.length());
				BufferedImage img = null;
				try{
					img = ImageIO.read(new ByteArrayInputStream (image));
					
					
				}catch(IOException ex){;
					System.out.println("problemas en el fichero");
				}
				places.setImage(image);				
				selection.add(places);
			}
			for (Place element : selection)
				System.out.println("Soy Image fea: \n"+	element.getImage());
		
		}catch(SQLException e){		
			System.out.println("Ai mai ay problemas\n" + e);
			return false;
		}	

		return true;
	}
}
