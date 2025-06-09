package Autosugetions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class example1
{
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
	
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("redmi");
		
		Thread.sleep(2000);
		
		String expText="redmi note 12";
		
		
		 List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));
			
		 for(WebElement options:allOptions)
		 {
			 String actText = options.getText();
			 if(actText.equals(expText))
			 {
				 options.click();
				 break;
			 }
		 }		 
	}
}
