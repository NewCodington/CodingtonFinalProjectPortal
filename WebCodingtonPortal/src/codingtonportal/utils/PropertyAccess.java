package codingtonportal.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.jasper.tagplugins.jstl.core.Url;


public class PropertyAccess implements IPropertyAccess {

	@Override
	public String getProperty(String property) throws IOException {
		Properties p = new Properties();    
		InputStream input = null;
		//input = new FileInputStream("/connection.properties");
		
		
		
		
		
		
		
		//input = this.getClass().getClassLoader().getResourceAsStream("/connection.properties");
		//input = new FileInputStream("./connection.properties");    
		
		
		//input = Thread.currentThread().getContextClassLoader().getResourceAsStream("/WEB-INF/properties/connection.properties");   
		
		
		
		
		input=new FileInputStream("C:/Users/JAVA101_01/git/CodingtonFinalProjectPortal/WebCodingtonPortal/build/classes/codingtonportal/utils/files/connection.properties");
		
		// Se carga el archivo de propiedades        
		p.load(input);         
		
		// Se obtiene la propiedad y se devuelve              
		return p.getProperty(property);
	}

	@Override
	public String getConstant(String constant) throws IOException {
		
		Properties p = new Properties();    
		InputStream input = null;
			
		input = new FileInputStream("/src/codingtonportal/utils/files/constant.properties");         
			
		// Se carga el archivo de propiedades        
		p.load(input);         
			
		// Se obtiene la propiedad y se devuelve              
		return p.getProperty(constant);

	}

}
