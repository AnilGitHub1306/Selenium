package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class headlessModeInPhantomJs 
{
	public void headlessModePhantomJs()
	{
	//	WebDriverManager.phantomjs().setup();
		
	//	WebDriver driver = new PhantomJSDriver();
		System.out.println("Brouser started");
		
		//driver.get("https://www.facebook.com/");
		System.out.println("URL opened");
		
	//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("wait applied");
	}
}
