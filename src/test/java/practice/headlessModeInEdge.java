package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class headlessModeInEdge 
{

	public void headlessModeFirefox()
	{
		WebDriverManager.edgedriver().setup();
		
		// Create EdgeOptions instance
        EdgeOptions options = new EdgeOptions();

        // Enable headless mode
        options.setCapability("headless", true);

        // Initialize EdgeDriver with EdgeOptions
        WebDriver driver = new EdgeDriver(options);
		System.out.println("Brouser started");
		
		driver.get("https://www.facebook.com/");
		System.out.println("URL opened");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("wait applied");
	}
}
