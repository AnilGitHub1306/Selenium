package ActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class example5_mouseDragAndDrop
{
	public static void main(String[] args) throws InterruptedException 
	{		
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();		
		
		
		WebElement src = driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
		WebElement dest = driver.findElement(By.xpath("(//div[@class='ui-widget-content'])[3]"));
		
		Actions act=new Actions(driver);
		
		act.dragAndDrop(src, dest).perform();	
		Action x=  act.click(dest).build();
		x.perform();
	}

	
		
	
}
