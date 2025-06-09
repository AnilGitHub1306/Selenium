package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class headlessModeInChrome 
{

	@Test
	public void ChromeHeadlessMode()
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
	//	WebDriverManager.chromedriver().setup();
	
		ChromeOptions  Options = new ChromeOptions();
		Options.addArguments("headless");           // Or
	//	Options.addArguments("--headless=new");    
		
		System.out.println("browser property set");
		
		WebDriver driver = new ChromeDriver(Options);
		System.out.println("Brouser started");
		
		driver.get("https://www.facebook.com/");
		System.out.println("URL opened");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("wait applied");
	}
}
