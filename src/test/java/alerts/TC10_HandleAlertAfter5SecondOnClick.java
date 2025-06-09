package alerts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC10_HandleAlertAfter5SecondOnClick 
{

	@Test
	public void HandleAlertAfter5SecondOnClick  () throws InterruptedException
	{
System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser opned");
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		System.out.println("Implicit wait applied");
		
		driver.get("https://demoqa.com/alerts");
		System.out.println("url opened");
		
		WebElement alert = driver.findElement(By.xpath("(//button[text()='Click me'])[2]"));
		alert.click();
		System.out.println("click alert btn");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alt = driver.switchTo().alert();
		
		alt.accept();
		System.out.println("alet accepted");
		
		Thread.sleep(4);
		driver.quit();
		System.out.println("browser closed");
		
		
	}
}
