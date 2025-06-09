package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{

	static WebDriver driver;
	static JavascriptExecutor js;
	
	public void ScreenshotOfPage(WebDriver driver, String name) throws IOException
	{
		Date d = new Date();
		SimpleDateFormat sdp = new SimpleDateFormat("YYMMddhhmmss");
		String date = sdp.format(d);
				
		TakesScreenshot tsobj =(TakesScreenshot)driver;
		File SrcFile= tsobj.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("./screenshot/"+date+name+".png");
		FileHandler.copy(SrcFile, DestFile);
		
	}
	
	public void ScreenshotOfWebElement( WebDriver driver,WebElement element, String name) throws IOException
	{
		Date d = new Date();
		SimpleDateFormat sdp = new SimpleDateFormat("dd-mm-yy & hh-mm-ss");
		String date = sdp.format(d);
				
		File SrcFile=element.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("./screenshot/"+name+date+".png");
		FileHandler.copy(SrcFile, DestFile);
	}
	
	public void ScrollByPixelDownward(WebDriver driver, int pixel)
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+ pixel+")");
	}
	
	public void ScrollByPixelUpward(WebDriver driver,int pixel)
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(10,"+ pixel+")");
	}
	
	public void ScrollUptoWebElement(WebDriver driver,WebElement element)
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView;",element );
	}
	
	public void ScrollUptoBottomOfPage(WebDriver driver)
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)"	);
	}
	
	public String PropertiesFile (String key) throws FileNotFoundException
	{
		FileInputStream ip = new FileInputStream("C:\\Users\\Anil\\git\\JunFirstWeek2023\\DataFiles\\config.properties");
		
		Properties p = new Properties();
		try {
			p.load(ip);
		 	p.getProperty(key);
		
			}
		catch (IOException e) 
			{
			e.printStackTrace();
			}
		return p.getProperty(key);
	}
}
