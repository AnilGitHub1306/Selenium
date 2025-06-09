package resizable;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class resizable 
{
	@Test
	public void resiz_The_Element()
	{
		WebDriverManager.chromedriver().setup();
	//	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resizable/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement ele = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		System.out.println(ele.getSize());
		Actions act = new Actions(driver);
		
		act.dragAndDropBy(ele, 50, 20).release(ele).perform();
		
	//	act.click().moveByOffset(50, 50).release().perform();
		
		System.out.println(ele.getSize());
	
	
	
	
	}
}
