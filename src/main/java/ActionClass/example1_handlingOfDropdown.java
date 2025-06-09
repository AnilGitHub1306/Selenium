package ActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class example1_handlingOfDropdown
{
	public static void main(String[] args) throws InterruptedException 
	{		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();		
		
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		
		WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(login).perform();
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//div[text()='Gift Cards']")).click();
		
		
	}
}
