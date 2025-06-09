package desireCapabilities;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DesireCapabilities 
{
public WebDriver driver;
	
	@Test
	public void open_Chrome_Browser_With_WebDriverManager() throws Exception
	{
	//	WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.out.println("Chromediver setup done");
		
		DesiredCapabilities dp = new DesiredCapabilities();
		Set<String> a = dp.getCapabilityNames();
		System.out.println(a.size());
		
		ChromeOptions op = new ChromeOptions();
		Set<String> b =op.getCapabilityNames();
		System.out.println(b.size());
		System.out.println(b);
		op.setAcceptInsecureCerts(true);
		
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
