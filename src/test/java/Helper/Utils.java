package Helper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
	
	public static String getproprety(String property) throws Exception {
		
		InputStream input = new FileInputStream("src/test/resources/Propreties/propreties");
		
		Properties x= new Properties();
		
		x.load(input);
		return(x.getProperty(property));
		
		
	}

}
