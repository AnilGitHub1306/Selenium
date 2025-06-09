package ActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class example4_mouseDoubleClick
{
	public static void main(String[] args) throws InterruptedException 
	{		
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();		
		
		
		WebElement ele = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions act=new Actions(driver);
		
			
//		act.moveToElement(ele).perform();
//		act.doubleClick().perform();
		
	//	act.moveToElement(ele).doubleClick().perform();
		
		
		act.doubleClick(ele).perform();
		
		
	}
}
