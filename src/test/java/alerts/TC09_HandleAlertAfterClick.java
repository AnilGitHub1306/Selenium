package alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC09_HandleAlertAfterClick 
{
	@Test
	public void HandleAlertAfterClick ()
	{
System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser opned");
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		System.out.println("Implicit wait applied");
		
		driver.get("https://demoqa.com/alerts");
		System.out.println("url opened");
		
		WebElement alert = driver.findElement(By.xpath("(//button[text()='Click me'])[1]"));
		
		alert.click();
		System.out.println("click alert btn");
		
		Alert alt = driver.switchTo().alert();
		
		alt.accept();
		System.out.println("alet accepted");
		
		
		driver.quit();
		System.out.println("browser closed");
		
		
	}
}
