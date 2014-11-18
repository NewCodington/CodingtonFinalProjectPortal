package codingtonportal.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyAccess implements IPropertyAccess {

	@Override
	public String getProperty(String property) throws IOException {
		Properties p = new Properties();    
		InputStream input = null;
		
		input = new FileInputStream("./src/codingtonportal/utils/files/connection.properties");         
		
		// Se carga el archivo de propiedades        
		p.load(input);         
		
		// Se obtiene la propiedad y se devuelve              
		return p.getProperty(property);
	}

	@Override
	public String getConstant(String constant) throws IOException {
		
		Properties p = new Properties();    
		InputStream input = null;
			
		input = new FileInputStream("./src/codingtonportal/utils/files/constant.properties");         
			
		// Se carga el archivo de propiedades        
		p.load(input);         
			
		// Se obtiene la propiedad y se devuelve              
		return p.getProperty(constant);

	}

}
