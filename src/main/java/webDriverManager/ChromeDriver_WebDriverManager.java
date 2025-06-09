package webDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriver_WebDriverManager  
{
	public WebDriver driver;
	
	@Test
	public void open_Chrome_Browser_With_WebDriverManager() throws Exception
	{
	//	WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.out.println("Chromediver setup done");
		
		driver = new ChromeDriver();
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
