package codingtonportal.utils;





import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import codingtonportal.model.domain.Place;



public class ImageConversion {
    /**
     * @throws ClassNotFoundException 
     * @throws NamingException 
	 * 
	 */

	public Place insertImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException, ClassNotFoundException {        
        DiskFileItemFactory factory = new DiskFileItemFactory();            
        ServletFileUpload sfu  = new ServletFileUpload(factory);
        Place place=new Place();
        List<FileItem> items = null;	
  		FileItem input= null ;
  		FERSDataConnection con= new FERSDataConnection(); 
  		
        try {
			items = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ArrayList<Object> extra = new ArrayList <Object>();
        for (FileItem fileItem : items){
        	if (fileItem.isFormField()) {
        		String fieldValue = fileItem.getString();
        		extra.add(fieldValue);
        	}
        	else {
        		extra.add(fileItem.getInputStream());
        		input = items.get(2);  
        		
        	}
        }                                 

            place.setName((String) extra.get(0));
            place.setDescription((String) extra.get(1));
            place.setImage(input.getInputStream());
            place.setAddress((String) extra.get(3));
            place.setTypePlace(Integer.parseInt((String) extra.get(4)));
            return place;     
	}
	
	
	public String showImage() throws IOException, ClassNotFoundException, NamingException{
		
		FERSDataConnection conex= new FERSDataConnection(); 
		ArrayList <Place> selection = new ArrayList <Place>();
		Blob imBlob = null;
		InputStream in = null;
		File outimag =new File("C:/Users/JAVA101_01/Desktop/NewCodingtonPortal.git/trunk/images");
		String g = null;

		BufferedImage bufferedImage = null;
		
		try{			
			Statement sentencia = (conex.getConnection()).createStatement();
			ResultSet outdata= sentencia.executeQuery("select image from codington.place where name= 'sip';");			
			while (outdata.next()){				
				Place  places = new Place();
				imBlob=outdata.getBlob("image");								
				 OutputStream out;
			     byte[] bytes = imBlob.getBytes(1, (int) imBlob.length());
			     bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));
			     String p = this.getClass().getName();

			     ImageIO.write(bufferedImage, "JPEG", outimag);
			     //ImageIO.write(bufferedImage, "JPEG", new File("images/ester.jpg")); 
			     //outimag = new File ("C:/Users/JAVA101_01/Desktop/"+ImageIO.write(bufferedImage, "JPEG", new File("C:/Users/JAVA101_01/Desktop/ester.jpg")));
		         String s = outimag.getAbsoluteFile().toString();
		         g = outimag.getAbsolutePath().toString();
			     return g;		     
				
			}
			for (Place element : selection)
				System.out.println("Soy Image fea: \n"+	bufferedImage);
		
		}catch(SQLException e){		
			System.out.println("Ai mai ay problemas\n" + e);
			//return null;
		}	
		return g;
	}

	public void insertImage_Page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException, ClassNotFoundException {        
        DiskFileItemFactory factory = new DiskFileItemFactory();            
        ServletFileUpload sfu  = new ServletFileUpload(factory);
        List<FileItem> items = null;	
  		FileItem input= null ;
  		FERSDataConnection con= new FERSDataConnection(); 
  		
        try {
			items = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ArrayList<Object> extras = new ArrayList <Object>();
        for (FileItem fileItem : items){
        	if (fileItem.isFormField()) {
        		String fieldValue = fileItem.getString();
        		extras.add(fieldValue);
        	}
        	else {
        		extras.add(fileItem.getInputStream());
        		input = items.get(2);  
        		
        	}
        }                                 

		try { 
			// Create the Statement
			PreparedStatement statementSQL = con.getConnection().prepareStatement("insert into aux_image values (?,?)");
			// Add conditions						
			statementSQL.setBlob(1,input.getInputStream());
			statementSQL.setString(2,(String) extras.get(0));
			System.out.println("Hecho");
			// Execute query
			 statementSQL.executeUpdate();		     

		// Close the Statement and Connection
		} catch (SQLException e ){}    
	}

	public String showImage_Page(String name) throws IOException, ClassNotFoundException, NamingException{
		
		FERSDataConnection conex= new FERSDataConnection(); 
		ArrayList <Place> selection = new ArrayList <Place>();
		Blob imBlob = null;
		InputStream in = null;
		File outimag =new File("C:/Users/JAVA101_01/Desktop/imagenes/ciudades2.jpg");
		String g = null;
		PreparedStatement statementSQL = null;

		BufferedImage bufferedImage = null;
		
		try{			
			Statement sentencia = (conex.getConnection()).createStatement();
			//ResultSet outdata= sentencia.executeQuery("select image from codington.aux_image where nas = ?;");
			statementSQL = conex.getConnection().prepareStatement("select image from codington.aux_image where nas = ?;");
			statementSQL.setString(1, name);
			ResultSet outdata= statementSQL.executeQuery();
			
			while (outdata.next()){				
				Place  places = new Place();
				imBlob=outdata.getBlob("image");								
				 OutputStream out;
			     byte[] bytes = imBlob.getBytes(1, (int) imBlob.length());
			     bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));
			     String p = this.getClass().getName();

			     ImageIO.write(bufferedImage, "JPEG", outimag);
			     //ImageIO.write(bufferedImage, "JPEG", new File("images/ester.jpg")); 
			     //outimag = new File ("C:/Users/JAVA101_01/Desktop/"+ImageIO.write(bufferedImage, "JPEG", new File("C:/Users/JAVA101_01/Desktop/ester.jpg")));
		         String s = outimag.getAbsoluteFile().toString();
		         g = outimag.getAbsolutePath().toString();
			     return g;		     
				
			}
			for (Place element : selection)
				System.out.println("Soy Image fea: \n"+	bufferedImage);
		
		}catch(SQLException e){		
			System.out.println("Ai mai ay problemas\n" + e);
			//return null;
		}	
		return g;
	}

}
