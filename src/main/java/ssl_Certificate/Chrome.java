package ssl_Certificate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chrome 
{
	
	public static void main(String args[])
	
	{
		System.out.println("hgds");
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setAcceptInsecureCerts(false);
		WebDriver driver = new FirefoxDriver(firefoxOptions);
		driver.get("https://self-signed.badssl.com");
	}
	
}
