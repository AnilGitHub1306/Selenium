package CustomizedListbox;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class example1_selectOption
{
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		System.out.println("Browser opened");
		
		driver.get("https://www.facebook.com/");
		System.out.println("URL opened");
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		System.out.println("Create new account button clicked");
		Thread.sleep(3000);
		
		//step1: 
		WebElement month = driver.findElement(By.xpath("//select[@id='month1']"));
		
		//step2:
		Actions act=new Actions(driver);
		act.click(month).perform();
				
		Thread.sleep(2000);
		
		
		//step3:
		//3A: navigate 1 option to top
		act.sendKeys(Keys.PAGE_UP).perform();
				
		Thread.sleep(2000);
		
		//3B: navigate 1 option to bottom
		act.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(2000);
		
		//3C: select option using enter key
		act.sendKeys(Keys.ENTER).perform();
		driver.quit();
	}
}
