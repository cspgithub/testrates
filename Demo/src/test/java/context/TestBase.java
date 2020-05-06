package context;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Properties;

public class TestBase {

	protected String server = LoadProperties().getProperty("url");

	public Properties LoadProperties() {

		try {
			InputStream inStream = getClass().getClassLoader().getResourceAsStream("config.properties");
			Properties prop = new Properties();
			prop.load(inStream);
			return prop;
		} catch (Exception e) {
			System.out.println("File not found exception thrown for config.properties file.");
			return null;
		}

	}

	 public static LocalDate locatDate(){
	 LocalDate dt = LocalDate.from(ZonedDateTime.now());
	 return dt;
	
	 }

//	public static String currentLocaldate() {
//
//		// Create object of SimpleDateFormat class and decide the format
//		// 2018-11-28
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//		// get current date time with Date()
//		Date date = new Date();
//
//		// Now format the date
//		String date1 = dateFormat.format(date);
//
//		// Print the Date
//		return date1;
//	}
}
