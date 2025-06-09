package headlessMode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriver_HeadlessMode 
{

	
	@Test
	public void open_Chrome_Browser_With_WebDriverManager() throws Exception
	{
	//	WebDriverManager.chromedriver().setup();
	//	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	//	System.out.println("Chromediver setup done");
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions op = new  ChromeOptions();
	
	//	op.addArguments("headless");
		op.addArguments("--headless");
	//	op.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(op);
		System.out.println("Browser initialised");
	
		driver.get("https://omayo.blogspot.com/");
		System.out.println("Url is opened");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("wait is applied");
		
		String actualTitle =driver.getTitle();
		String expectedTitle="omayo (QAFox.com)";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		driver.quit();
		System.out.println("browser closed");
	}
	
	

	
}
