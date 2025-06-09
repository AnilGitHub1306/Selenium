package ActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class example2_mouseLeftClick
{
	public static void main(String[] args) throws InterruptedException 
	{		
		

		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//	driver.manage().window().maximize();		
		
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement cart = driver.findElement(By.xpath("//span[text()='Cart']"));
		Actions act=new Actions(driver);
		
			
//		act.moveToElement(cart).perform();
//		act.click().perform();
		//act.moveToElement(cart).click().perform();
		act.click(cart).perform();
		
		
	}
}
