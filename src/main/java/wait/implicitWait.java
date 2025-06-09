package wait;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class implicitWait {
	public static void main(String[] args) 
	{
		WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
		driver.get("https://omayo.blogspot.com/");
		
		WebElement dropDownButton = driver.findElement(By.xpath("//button[text()='Dropdown']"));
		dropDownButton.click();
		
		//Here gmail button appered at 3 sec
		WebElement GmailButton = driver.findElement(By.xpath("//a[text()='Gmail']"));
		GmailButton.click();
		
		
		
	}
}
