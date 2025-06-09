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

public class TC08_VerifyNewWindowMassage 
{

	@Test
	public void  VerifyNewWindowMassage () throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser opned");
		
	//	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		System.out.println("Implicit wait applied");
		
		driver.get("https://demoqa.com/browser-windows");
		System.out.println("url opened");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		WebElement windowbtnmsg = driver.findElement(By.xpath("//button[@id='messageWindowButton']"));
		
		js.executeScript("arguments[0].scrollIntoView();",windowbtnmsg );
		
		windowbtnmsg.click();
		System.out.println("window msg button clicked");
		
		ArrayList<String> pageadds = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("windows page addresses captured");
		
		System.out.println(pageadds.get(1));
		
		driver.switchTo().window(pageadds.get(1));
		WebElement text = driver.findElement(By.xpath("/html/body/text()"));
		String actualtext = text.getText();
		String expectedtext = "New Window Message";
		
		Assert.assertEquals(actualtext, expectedtext);
		
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Browser closed");
	}
}
