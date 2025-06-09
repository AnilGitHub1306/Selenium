package practice;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_VerifyTheNewWindowFunctionality 
{

	@Test
	public static void HnadlingNewWindow() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser opned");
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		System.out.println("Implicit wait applied");
		
		driver.get("https://demoqa.com/browser-windows");
		System.out.println("url opened");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		WebElement windowbtn = driver.findElement(By.xpath("//button[@id='windowButton']"));
		
	//	js.executeScript("arguments[0].ScrollIntoView();",windowbtn );
		
		windowbtn.click();
		System.out.println("window button clicked");
		
		ArrayList<String> pageadds = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("windows page addresses captured");
		
		driver.switchTo().window(pageadds.get(1));
		
		WebElement text = driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
		String actualtext = text.getText();
		String expectedtext = "This is a sample page";
		
		Assert.assertEquals(actualtext, expectedtext);
		
		Thread.sleep(3000);
		driver.close();
		System.out.println("Browser closed");
		
		
	}
	
}
