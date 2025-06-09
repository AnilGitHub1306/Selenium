package log;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class example 
{
	
	
	@Test(priority=3)
	public static void log1() throws IOException
	{
		Reporter.log("xyz1");	
		
		WebDriver driver = new ChromeDriver();
		Reporter.log("Browser opened");
		driver.get("https://www.google.com/");
		Reporter.log("Google page opened");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sorcefile = ts.getScreenshotAs(OutputType.FILE);
		File trgFile = new File("C:\\Users\\Anil\\eclipse-workspace\\Automation_Practice_Feb2024\\screenshot\\google.png");
		FileHandler.copy(sorcefile, trgFile);
		Reporter.log("<img src=\"C:\\Users\\Anil\\eclipse-workspace\\Automation_Practice_Feb2024\\screenshot\\google.png\"/>");
		Reporter.log("Screenshot taken");
		driver.quit();
		Reporter.log("pogramm end");
	}
	


	@Test(priority=2) 
	public static void log2()
	{
		Reporter.log("xyz2");	}
	
	@Test(priority=1)
	public static void log3()
	{
		Reporter.log("xyz3");	}
}
