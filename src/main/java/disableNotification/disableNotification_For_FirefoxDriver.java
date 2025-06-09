package disableNotification;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class disableNotification_For_FirefoxDriver 
{
	public WebDriver driver;
	@Test
	public void disableNotification_For_FirefoxDriver() throws InterruptedException
	{
	WebDriverManager.firefoxdriver().setup();
	System.out.println("firefoxdriver setup done");
	
	FirefoxOptions op = new FirefoxOptions();
	op.addPreference("dom.webnotifications.enabled", true);
	Set<String> a = op.getCapabilityNames();
	System.out.println(a);
	
	driver = new FirefoxDriver();
	System.out.println("Browser initialised");
	
	driver.manage().window().maximize();
	System.out.println("Browser maximised");
	
	driver.manage().deleteAllCookies();
	System.out.println("Delete All Cookies");
	
	driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	System.out.println("Page Load Timeout set");
	
	driver.get("https://www.justdial.com/");
	System.out.println("Url is opened");
	
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	System.out.println("wait is applied");
	
	Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown()
	{
	//	driver.quit();
		System.out.println("browser closed");
	}
}
