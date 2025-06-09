package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTitle_GetURL_PageSource 
{

	WebDriver driver ;
	@Test
	public void GetTitle_GetURL_PageSource()
	{
		WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		 System.out.println("Browse opened");
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		 driver.get("https://www.saucedemo.com/v1/");
		 System.out.println("url opened");
		 
		String TitleOfPage =  driver.getTitle();
		 System.out.println("Title Of Page = " + TitleOfPage);
		 
		String URLOfThePage = driver.getCurrentUrl();
		 System.out.println("URL Of The Page = " + URLOfThePage);
		 
		String PageSource = driver.getPageSource();
		 System.out.println("Page Source = " + PageSource);
		 
		Object ClassOfPage=driver.getClass();
		 System.out.println("Class Of Page = " + ClassOfPage);
		 
		String WindowHandleOfPage = driver.getWindowHandle();
		 System.out.println("Window Handle Of Page = " + WindowHandleOfPage);	
	}
	
	public void tearDown()
	{
		driver.quit();
		System.out.println("Browser closed");
		
		
	}
}
