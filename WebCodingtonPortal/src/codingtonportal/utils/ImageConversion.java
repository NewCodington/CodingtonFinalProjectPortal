package codingtonportal.utils;





import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
	
 

}
