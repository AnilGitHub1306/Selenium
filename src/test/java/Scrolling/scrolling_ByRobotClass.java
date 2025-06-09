package Scrolling;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scrolling_ByRobotClass 
{
@Test
	public void scrolling_Till_The_Element_By_Pixel() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com");
		Reporter.log("URL opened",true);
		
		WebElement bookstoreapp = driver.findElement(By.xpath("//h5[text()='Book Store Application']"));
	
		int xpoint=bookstoreapp.getLocation().getX();
	
		
		
		Robot robot = new Robot();


		for(int i=0; i<=i++; i++)
		{
			if(bookstoreapp.isDisplayed()==true)
			{
				bookstoreapp.click();
				break;
			}
			else
			{
				robot.keyPress(KeyEvent.VK_DOWN);
			}
		}
		

		
	
	
	}


}
