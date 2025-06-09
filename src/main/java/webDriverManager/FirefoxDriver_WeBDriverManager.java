package webDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriver_WeBDriverManager 
{
	public WebDriver driver;
	@Test
	public void open_Firefox_Browser_With_WebDriverManager() throws InterruptedException
	{
	WebDriverManager.firefoxdriver().setup();
	System.out.println("firefoxdriver setup done");
	
	driver = new FirefoxDriver();
	System.out.println("Browser initialised");
	
	driver.manage().window().maximize();
	System.out.println("Browser maximised");
	
	driver.manage().deleteAllCookies();
	System.out.println("Delete All Cookies");
	
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	System.out.println("Page Load Timeout set");
	
	driver.get("https://parabank.parasoft.com/parabank/index.htm");
	System.out.println("Url is opened");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	System.out.println("wait is applied");
	
	Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		System.out.println("browser closed");
	}
}
