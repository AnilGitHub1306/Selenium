package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class headlessModeFirefox 
{

	public void headlessModeFirefox()
	{
		WebDriverManager.chromedriver().setup();
		
		FirefoxOptions  Options = new FirefoxOptions();
	//	Options.addArguments("headless");
	//	Options.setBinary("new FirefoxBinary ().addCommandLineOptions(\"headless\")");
		Options.addArguments("headless");
		System.out.println("browser property set");
		
		WebDriver driver = new FirefoxDriver(Options);
		System.out.println("Brouser started");
		
		driver.get("https://www.facebook.com/");
		System.out.println("URL opened");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("wait applied");
	}
}
