package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class activeElement 
{
	
	@Test
	public  void activeElement() throws InterruptedException 
	{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:8080/login.do");
			//entering text into the focussed element
			driver.switchTo().activeElement().sendKeys("admin");
			Thread.sleep(10000);
			driver.quit();
		}

}
