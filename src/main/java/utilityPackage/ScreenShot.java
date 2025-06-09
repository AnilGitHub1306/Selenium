package utilityPackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot 
{
	static WebDriver driver;
	public static void ScreenShotMethod(String name) throws Exception
	{
		TakesScreenshot ts= (TakesScreenshot)driver; 
		 File sourceFile = ts.getScreenshotAs(OutputType.FILE) ;
		 File destFile = new File("./screenshot"+name+".jpg"); 
		 FileHandler.copy(sourceFile, destFile);
	}
}
