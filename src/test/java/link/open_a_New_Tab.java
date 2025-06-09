package link;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class open_a_New_Tab 
{
	
	@Test
	public void open_a_New_Tab() throws AWTException, InterruptedException
	{
	//	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		List <WebElement> listoflinks = driver.findElements(By.tagName("a"));
		System.out.println(listoflinks.size());
		for(WebElement link : listoflinks )
		{
			String linkText = link.getAttribute("href");
			System.out.println(linkText);
		//	WebElement body = driver.findElement(By.tagName("body"));

			Robot br = new Robot();
			
			br.keyPress(KeyEvent.VK_CONTROL);
			br.keyPress(KeyEvent.VK_T);
			br.keyRelease(KeyEvent.VK_CONTROL);
			br.keyRelease(KeyEvent.VK_T);
			
			List<String> a = new ArrayList<String> (driver.getWindowHandles());
			
			System.out.println(a.size());
			driver.switchTo().window(a.get(1));
			driver.get(linkText);
			Thread.sleep(5000);

			driver.close();
			driver.switchTo().window(a.get(0));
		}
	}
}
