package headlessMode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriver_HeadlessMode 
{
	public WebDriver driver;
	@Test
	public void open_Edge_Browser_With_HeadlessMode() throws InterruptedException
	{
	WebDriverManager.edgedriver().setup();
	
	System.out.println("EdgeDriver setup done");
	
	EdgeOptions op = new EdgeOptions();
	op.addArguments("--headless");
	//op.addArguments("--headless=new");

	driver = new EdgeDriver(op);
	System.out.println("Browser initialised");

	driver.get("https://parabank.parasoft.com/parabank/index.htm");
	System.out.println("Url is opened");
	
	driver.quit();
	System.out.println("browser closed");
	}
	
	
}
