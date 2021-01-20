package configurations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configreader {
	
	public static Properties prop;
	
	public static Properties readConfig() throws IOException {
		FileInputStream fis = new FileInputStream("E:\\ework\\tutninja\\src\\main\\java\\configurations\\config.properties");
		prop = new Properties();
		prop.load(fis);
		
		return prop;
	}
	
	

}
