package Scrolling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Utility;

public class Scroll_By_Pixel 
{
	WebDriver driver; 
	
	@Test
	public void Scroll_By_Pixel()
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
	utilObj.ScrollByPixelDownward(driver,200);
	
	driver.quit();
	System.out.println("Browser closed");
	}
}
