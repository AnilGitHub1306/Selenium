package headlessMode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InternetExplorerDriver_HeadlessMode 
{
	public WebDriver driver;
	@Test
	public void open_InterNetExplorer_Browser_With_HeadlessMode() throws InterruptedException
	{
	WebDriverManager.iedriver().setup();
	System.out.println("InterNetExplore driver setup done");
	
	InternetExplorerOptions op = new InternetExplorerOptions();
	op.addCommandSwitches("-k");
	//HeadLess Mode not possible for the IE browser
	driver = new InternetExplorerDriver(op);
	System.out.println("Browser initialised");
	
	driver.manage().window().maximize();
	System.out.println("Browser maximised");
	
	driver.manage().deleteAllCookies();
	System.out.println("Delete All Cookies");
	
//	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//	System.out.println("Page Load Timeout set");
	
	driver.get("https://parabank.parasoft.com/parabank/index.htm");
	System.out.println("Url is opened");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	System.out.println("wait is applied");
	
	
	
	driver.quit();
	System.out.println("browser closed");
	}
	
}
