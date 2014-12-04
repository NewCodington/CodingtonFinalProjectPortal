package springcodingtonportal.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springcodingtonportal.model.services.ImageServiceJDBC;

@Controller
public class ImageController {
	
		@Autowired
		private ApplicationContext appContext;
		
		private static Logger log = Logger.getLogger(VisitorController.class);
		
		@RequestMapping("/image.htm")
		public @ResponseBody void showImage(HttpServletRequest request, HttpServletResponse response, @RequestParam ("name") String name) throws IOException, SQLException, ClassNotFoundException, NamingException{
			
			response.setContentType("image/gif");
			response.setHeader("cache-control", "no-cache");

		    ImageServiceJDBC image 	= (ImageServiceJDBC) appContext.getBean("ImageServiceJDBC");
			InputStream imInp = image.selectImage(name);

			if(imInp!=null){
				OutputStream out;
				ByteArrayOutputStream buffer = new ByteArrayOutputStream();
				int nRead;
				byte[] data = new byte[1024];
				
				while ((nRead = imInp.read(data, 0, data.length)) != -1) {
				  buffer.write(data, 0, nRead);
				}
			    
				buffer.flush();
				
			    try
			    {
			        out = response.getOutputStream();
			        ImageIO.write(ImageIO.read(new ByteArrayInputStream(buffer.toByteArray())), "png", out);
			        out.close();
			    }
			    catch (IOException ex)
			    {
			       ex.printStackTrace();
			    }
			}
		}
		    
		    @RequestMapping("/imagePlace.htm")
			public @ResponseBody void showImagePlace(HttpServletRequest request, HttpServletResponse response, @RequestParam ("id") int id) throws IOException, SQLException, ClassNotFoundException, NamingException{
				
				response.setContentType("image/gif");
				response.setHeader("cache-control", "no-cache");
			    
				ImageServiceJDBC image 	= (ImageServiceJDBC) appContext.getBean("ImageServiceJDBC");
				InputStream imInp = image.selectImageId(id);
				
				if(imInp!=null){
					OutputStream out;
					
					ByteArrayOutputStream buffer = new ByteArrayOutputStream();
					
					int nRead;
					byte[] data = new byte[99999];
	
					while ((nRead = imInp.read(data, 0, data.length)) != -1) {
					  buffer.write(data, 0, nRead);
					}
				    
					buffer.flush();
					
				    try
				    {
				        out = response.getOutputStream();
				        ImageIO.write(ImageIO.read(new ByteArrayInputStream(buffer.toByteArray())), "png", out);
				        out.close();
				        imInp.close();
				    }
				    catch (IOException ex)
				    {
				       
				    }
				}

	    }
		

	}

