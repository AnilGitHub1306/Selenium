package practice;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class headlessModeForAllDriver
{
	@Test
	public void headlessModeForAllDriver() throws InterruptedException
	{
	//	WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
	//	WebDriverManager.edgedriver().setup();
	//	WebDriverManager.iedriver().setup();
	//	WebDriverManager.operadriver().setup();
	//	WebDriverManager.phantomjs().setup();
		
	//	ChromeOptions op = new ChromeOptions();
	//	op.addArguments("headless");
		
		FirefoxOptions op = new FirefoxOptions();
		op.addArguments("headless");
		
	//	EdgeOptions op = new EdgeOptions();
	//	op.addArguments("headless");
		
	//	InternetExplorerOptions  op = new InternetExplorerOptions ();
	//	op.addCommandSwitches("-k");
		
	//  OperaOptions op = new OperaOptions();
	//  op.addArguments("--headless");
		
	//	ChromeDriver driver = new ChromeDriver(op);
		FirefoxDriver driver = new FirefoxDriver(op);
	//	EdgeDriver driver = new EdgeDriver(op);
	//	InternetExplorerDriver driver = new InternetExplorerDriver(op);
		
		System.out.println("browser initialised");
		
		driver.get("https://jqueryui.com/tooltip/");
		System.out.println("URL Opened");
		
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Browser closed");
		
	}

}
