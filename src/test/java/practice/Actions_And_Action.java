package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_And_Action {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/v1/");
		WebElement uname = driver.findElement(By.xpath("//input[@id='user-name']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(uname).click(uname).sendKeys("dfbdsk").build().perform();
		
		Action abc = act.moveToElement(uname).click(uname).sendKeys("dfbdsk").build();
		abc.perform();
		
		
		
//abc.perform();
	}

}
