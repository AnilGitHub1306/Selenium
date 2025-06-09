package Scrolling;

import java.awt.Point;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll_UpTo_WebElement_By_keyboard 
{
	WebDriver driver; 
	
	@Test
	public void Scroll_UpTo_WebElement_By_keyboard() throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	
	driver = new ChromeDriver();
	System.out.println("Browser opened");
	 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://demoqa.com/");
	System.out.println("url opened");

	WebElement bookApplicationbutton = driver.findElement(By.xpath("//h5[text()='Book Store Application']"));
	
	Actions act = new Actions(driver);
	//act.sendKeys(Keys.ARROW_DOWN).perform();
	//int p = bookApplicationbutton.getLocation().getY();
	
	act.moveToElement(bookApplicationbutton).click();
	 
//	boolean visibilityOfbookApplicationbutton=bookApplicationbutton.isSelected();
//	System.out.println(visibilityOfbookApplicationbutton);
//	while(visibilityOfbookApplicationbutton==true)
//	{act.sendKeys(Keys.ARROW_DOWN).
//		 sendKeys(Keys.ARROW_DOWN).
//		 sendKeys(Keys.ARROW_DOWN).
//		 sendKeys(Keys.ARROW_DOWN).
//		 sendKeys(Keys.ARROW_DOWN).perform();
//	Thread.sleep(2000);
//	}
//	System.out.println(visibilityOfbookApplicationbutton);
//	bookApplicationbutton.click();
	
	//driver.quit();
	System.out.println("Browser closed");
	}
}
