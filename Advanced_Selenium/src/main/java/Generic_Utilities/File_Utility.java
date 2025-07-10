package Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
	/**
	 * This method is used to read the data from properties file(External resourse)
	 * @param key
	 * @return String
	 * @throws Throwable
	 * @author Zeenat
	 */

	public String getKeyAndValue(String key) throws Throwable {
		FileInputStream fs = new FileInputStream("../Advanced_Selenium/data1.property");
		Properties p = new Properties();
		p.load(fs);
		String value = p.getProperty(key);
		return value;
	}
	
}
