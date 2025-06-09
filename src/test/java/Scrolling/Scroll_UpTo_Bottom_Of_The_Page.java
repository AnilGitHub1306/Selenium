package Scrolling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Utility;

public class Scroll_UpTo_Bottom_Of_The_Page 
{
	WebDriver driver; 
	
	@Test
	public void Scroll_UpTo_Bottom_Of_The_Page()
	{
	WebDriverManager.chromedriver().setup();
	
	driver = new ChromeDriver();
	System.out.println("Browse opened");
	 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://demoqa.com/");
	System.out.println("url opened");

	WebElement bookApplicationbutton = driver.findElement(By.xpath("//h5[text()='Book Store Application']"));
	
	Utility utilObj = new Utility();
	utilObj.ScrollUptoBottomOfPage(driver);
	
	driver.quit();
	System.out.println("Browser closed");
	}
}
