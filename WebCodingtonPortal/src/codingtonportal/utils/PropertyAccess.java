package codingtonportal.utils;



import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import codingtonportal.utils.IPropertyAccess;


public class PropertyAccess implements IPropertyAccess {

	@Override
	public String getProperty(String property) throws IOException {
		Properties p = new Properties();    
		
		
		InputStream fileInput = this.getClass().getResourceAsStream("files/connection.properties");
		
		// Se carga el archivo de propiedades        
		p.load(fileInput);         
		
		// Se obtiene la propiedad y se devuelve              
		return p.getProperty(property);
	}

	@Override
	public String getConstant(String constant) throws IOException {
		
		Properties p = new Properties();    
			
InputStream fileInput = this.getClass().getResourceAsStream("files/constant.properties");
		
		// Se carga el archivo de propiedades        
		p.load(fileInput);         
		
		// Se obtiene la propiedad y se devuelve              
		return p.getProperty(constant);
	}

}
