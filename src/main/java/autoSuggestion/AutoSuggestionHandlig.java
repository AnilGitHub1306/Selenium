package autoSuggestion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AutoSuggestionHandlig 
{
	@Test
	public void Handle_AutoSuggetions() 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		
		WebElement googleTextBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
		googleTextBox.clear();
		googleTextBox.sendKeys("selenium");
		googleTextBox.click();
		
		List<WebElement> suggetionList = driver.findElements(By.xpath("//ul//li//div[@role='option']"));
		
		System.out.println(suggetionList.size()); 
		
		for(WebElement i: suggetionList)
		{
			if(i.getAttribute("aria-label").equals("selenium testing"))
			{
				i.click();
				break;
			}
		}
		
		driver.quit();
	}
}
//aria-label="selenium testing"