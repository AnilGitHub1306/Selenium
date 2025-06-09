package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestions1 {

	@Test
	public static void AutoSuggestions () throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		System.out.println("URL enter");
		
		WebElement googleSearchBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
		googleSearchBox.sendKeys("selenium");
		System.out.println("selenium text entered");
		
		// 1. First way
//		List<WebElement> autoSuggestion1 =driver.findElements(By.xpath("//ul[@role='listbox']//li"));
//		System.out.println("all suggestions are captured");
//		Thread.sleep(10000);
//		for(WebElement SingleAutoSuggetion : autoSuggestion1)
//		{
//			if(SingleAutoSuggetion.getText().equals("selenium webdriver"))
//			{
//				SingleAutoSuggetion.click();
//				System.out.println("selenium webdriver found and clicked");
//			}
//		}
//	
		
		//2. second way
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		
		
		driver.quit();
		System.out.println("Browser closed");
	}
}
