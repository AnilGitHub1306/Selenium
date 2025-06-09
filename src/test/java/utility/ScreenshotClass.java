package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotClass 
{
	static WebDriver driver;
		
	public static void ScreenshotOfPage(String name) throws IOException
	{
		Date d = new Date();
		SimpleDateFormat sdp = new SimpleDateFormat("YYMMddhhmmss");
		String date = sdp.format(d);
				
		TakesScreenshot ts =((TakesScreenshot)driver);
		File SrcFile=ts.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("./screenshot/"+date+name+".png");
		FileHandler.copy(SrcFile, DestFile);
	}
	
	public static void ScreenshotOfWebElement( WebElement element, String name) throws IOException
	{
		Date d = new Date();
		SimpleDateFormat sdp = new SimpleDateFormat("dd-mm-yy & hh-mm-ss");
		String date = sdp.format(d);
				
		File SrcFile=element.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("./screenshot/"+name+date+".png");
		FileHandler.copy(SrcFile, DestFile);
	}
}
