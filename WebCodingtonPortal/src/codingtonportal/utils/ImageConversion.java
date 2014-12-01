package codingtonportal.utils;





import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
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
	
	public BufferedImage ShowImage() throws IOException, ClassNotFoundException, NamingException{
		
		FERSDataConnection conex= new FERSDataConnection(); 
		ArrayList <Place> selection = new ArrayList <Place>();
		Blob imBlob = null;
		InputStream in = null;
		File outimage= null;
		try{			
			Statement sentencia = (conex.getConnection()).createStatement();
			ResultSet outdata= sentencia.executeQuery("select image from codington.aux_image");			
			while (outdata.next()){
				Place  places = new Place();
				imBlob=outdata.getBlob("image");				
				//places.setImage(outdata.getBlob("image").getBinaryStream());	
				//in = outdata.getBlob("image").getBinaryStream();				
				//OutputStream out=new FileOutputStream(outimage);
			     byte[] bytes = imBlob.getBytes(1, (int) imBlob.length());
			     BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes))
			     //String s=new String(bytes);
		         System.out.println(bufferedImage);  //prints bytes for the string			     
				selection.add(places);
				return bufferedImage;
			}
			for (Place element : selection)
				System.out.println("Soy Image fea: \n"+	element.getImage());
		
		}catch(SQLException e){		
			System.out.println("Ai mai ay problemas\n" + e);
			//return null;
		}	

		//return imBlob;
	}


}
