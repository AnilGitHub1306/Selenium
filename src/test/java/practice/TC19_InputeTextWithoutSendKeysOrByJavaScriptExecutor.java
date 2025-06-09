package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC19_InputeTextWithoutSendKeysOrByJavaScriptExecutor 
{
	@Test
	public  void InputeTextWithoutSendKeysOrByJavaScriptExecutor () throws Exception
	{
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	
	WebDriver driver =new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://demoqa.com/text-box");
	
	JavascriptExecutor js= (JavascriptExecutor) driver;
	
	WebElement Fname = driver.findElement(By.xpath("//input[@id=\"userName\"]"));
	
	js.executeScript("arguments[0].value='anil';", Fname);
	//ClickMe.click();
	

//	System.out.println("Clicked perform");
	
	
	}
}
