package fileHandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class readpropertiesFile 
{
	@Test
	public void readpropertiesFile() throws IOException
	{
		// Create  FileInputStream object
		// Create Properties class object to read properties file
		// Load file so we can use into our script
		
		FileInputStream f=new FileInputStream("./testData/propertiesFile.properties");
		Properties prop=new Properties();
		prop.load(f);	
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("userName"));
		System.out.println(prop.getProperty("password"));
	}
}
