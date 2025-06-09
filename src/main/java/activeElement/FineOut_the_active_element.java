package activeElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FineOut_the_active_element 
{
	@Test
	public void activeElement() throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/login.do");
		try {
		//entering text into the focused element
		WebElement activeEle = driver.switchTo().activeElement();
		activeEle.sendKeys("pass123");
		}
		catch(Throwable e) 
		{e.printStackTrace();}
		
		Thread.sleep(5000);
		driver.quit();
	}
}
