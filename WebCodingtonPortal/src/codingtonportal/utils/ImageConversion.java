package codingtonportal.utils;




import java.io.FileInputStream;
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

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import codingtonportal.model.domain.Place;
import codingtonportal.model.services.PlaceServiceImpl;


public class ImageConversion {
    /**
     * @throws ClassNotFoundException 
     * @throws NamingException 
	 * 
	 */

	public void insertImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException, ClassNotFoundException {        
        DiskFileItemFactory factory = new DiskFileItemFactory();            
        ServletFileUpload sfu  = new ServletFileUpload(factory);
        //PlaceServiceImpl  placeService = new PlaceServiceImpl();
        Place place=new Place();
        List<FileItem> items = null;
        FERSDataConnection conex= new FERSDataConnection();
  		PreparedStatement statementSQL = null;
  		InputStream input= null; 
  		FileItem input2= null ;

  		
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
        		System.out.println(fieldValue);
        		extra.add(fieldValue);
        	}
        	else {

        		extra.add(fileItem.getInputStream());
        		input2 = items.get(2);  
        		//input = input2.getInputStream(); // InputStream
        		input = fileItem.getInputStream();
        		
        		System.out.println(input);
        		input.close();
        	}
        }
       
               
             
      
        try {        	
			statementSQL = conex.getConnection().prepareStatement("INSERT INTO codington.aux_image VALUES (?,?);");
			//statementSQL.setBinaryStream(1, input);
			statementSQL.setBlob(1, input);
			//statementSQL.setBinaryStream(1, input.getInputStream(), (int) input.getSize());
		    //statementSQL.setBlob(1, input);
		    statementSQL.setString(2, "besos");
	        statementSQL.executeUpdate();			
			statementSQL.close();
			conex.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No inserto --"+e);
			e.printStackTrace();
		}
            
        
        /*System.IO.MemoryStream ms = new System.IO.MemoryStream();
        // Se guarda la imagen en el buffer
        picFoto.Image.Save(ms, System.Drawing.Imaging.ImageFormat.Jpeg);
        // Se extraen los bytes del buffer para asignarlos como valor para el
        // parámetro.
        cmd.Parameters["@foto"].Value = ms.GetBuffer();

        conn.Open();
        cmd.ExecuteNonQuery();
        conn.Close();*/
	 /*String name = request.getParameter("placeName");
     String description = request.getParameter("description");
     String image = request.getParameter("image");
     String address = request.getParameter("address");	     
     String typePlace = request.getParameter("typePlace");				
     System.out.println(name+"-"+description+"-"+image+"-"+address+"-"+typePlace);*/
     
	}
	
 

}
