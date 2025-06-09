package alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC11_HandleAlertAceeptOrDismissedOnClick 
{

	@Test
	public void HandleAlertAceeptOrDismissedOnClick () throws InterruptedException 
	{
System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser opned");
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		System.out.println("Implicit wait applied");
		
		driver.get("https://demoqa.com/alerts");
		System.out.println("url opened");
		
		WebElement alert = driver.findElement(By.xpath("(//button[text()='Click me'])[3]"));
		JavascriptExecutor js =(JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,100)");
		js.executeScript("arguments[0].scrollIntoView();", alert);
		
		alert.click();
		System.out.println("click alert btn");
		
		Alert alt = driver.switchTo().alert();
		
		alt.accept();
		System.out.println("alet accepted");
		
	//	alt.dismiss();
	//	System.out.println("alert dismiss");
		
		Thread.sleep(4);
		driver.quit();
		System.out.println("browser closed");
		
		
	}
}
