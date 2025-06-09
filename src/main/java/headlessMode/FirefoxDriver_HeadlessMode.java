package headlessMode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriver_HeadlessMode 
{

	

	@Test
	public void open_Firefox_Browser_With_HeadlessMode() throws InterruptedException
	{
	WebDriverManager.firefoxdriver().setup();
	System.out.println("firefoxdriver setup done");
	
	//Method1----------------------------
		FirefoxOptions op = new FirefoxOptions();
		op.addArguments("--headless");
	
	//Method2----------------------------
	//   FirefoxBinary br = new FirefoxBinary();
	//	 br.addCommandLineOptions("--headless");
	//	 FirefoxOptions op = new FirefoxOptions();
	//	 op.setBinary(br);
	
	
	WebDriver driver = new FirefoxDriver(op);
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
	driver.quit();
	System.out.println("browser closed");
	}
	
	
}
