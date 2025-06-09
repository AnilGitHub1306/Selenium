package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class zoomIn_ZoomOut 
{
	@Test
	public void zoomIn_ZoomOut() throws InterruptedException, AWTException 
	{
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		
		Robot br = new Robot();
		
		br.keyPress(KeyEvent.VK_CONTROL);
		br.keyPress(KeyEvent.VK_ADD);
		br.keyRelease(KeyEvent.VK_CONTROL);
		br.keyRelease(KeyEvent.VK_ADD);
		
	}
}
