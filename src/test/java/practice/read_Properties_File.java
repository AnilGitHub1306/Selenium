package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import utility.Utility;

public class read_Properties_File 
{
	@Test
	public void read_PropertiesFile() throws IOException
	{
		FileInputStream ip = new FileInputStream("C:\\Users\\Anil\\git\\JunFirstWeek2023\\DataFiles\\config.properties");
		
		Properties p = new Properties();
		
			p.load(ip);
			String url = p.getProperty("url");
			System.out.println("URL is - "+url);
			
			String Username = p.getProperty("userName");
			System.out.println("Username is - "+Username);
			
			String Password = p.getProperty("password");
			System.out.println("Password is - "+Password);
			
			ip.close();
			
			
		
	
	//	Utility util = new Utility();
	//	String URL = util.PropertiesFile("url");
	//	System.out.println(URL);
	}
}
