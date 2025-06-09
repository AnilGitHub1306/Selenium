package screenshot;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Utility;



public class TC22_TakeScreenshot_Of_WebElement 
{
	static WebDriver driver;
	@Test
	public  void TakeScreenshot_Of_WebElement () throws IOException
	{
		
		WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		 System.out.println("Browse opened");
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		 driver.get("https://www.saucedemo.com/v1/");
		 System.out.println("url opened");
		 
		 WebElement image = driver.findElement(By.xpath("//img[@src='img/Login_Bot_graphic.png']"));
		 
		Utility utilobj = new Utility();
		
		utilobj.ScreenshotOfWebElement(driver,image, "logInPageImage");
		 
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
			
		driver.close();
		System.out.println("Browser closed");
	}
	
	 
}
