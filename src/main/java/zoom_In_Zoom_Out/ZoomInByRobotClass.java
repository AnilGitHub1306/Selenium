package zoom_In_Zoom_Out;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ZoomInByRobotClass 
{
	@Test
	public void zoomInByRobotClass() throws InterruptedException, Exception
	{
	//	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("zooming");

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ADD);
		r.keyRelease(KeyEvent.VK_SUBTRACT);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
	}
}
