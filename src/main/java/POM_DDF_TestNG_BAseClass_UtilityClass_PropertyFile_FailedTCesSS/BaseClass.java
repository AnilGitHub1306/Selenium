package POM_DDF_TestNG_BAseClass_UtilityClass_PropertyFile_FailedTCesSS;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass 
{
	WebDriver driver;
	
	public void initializeBrowser() throws IOException 
	{
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		 driver=new ChromeDriver(op);
		driver.get(UtiltyClass.getPFData("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();		
	}

}
