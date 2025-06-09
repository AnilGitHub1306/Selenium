package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC14_lickActionByJavaScriptExecutor 
{
	@Test
	public void JavaScriptExecutor() throws Exception
	{
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	
	WebDriver driver =new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://demoqa.com/buttons");
	
	JavascriptExecutor js= (JavascriptExecutor) driver;
	
	 Thread.sleep(9000);
	WebElement ClickMe = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
	js.executeScript("window.scrollBy(0,100)");
	//ClickMe.click();
	
//	
	js.executeScript("arguments[0].click();",ClickMe);
	System.out.println("Clicked perform");
	
	
	}
}
