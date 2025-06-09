package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSuggestions
{
	
	public static void main (String[]args)
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		
		WebElement googleSearchBox = driver.findElement(By.xpath("//div[@class='a4bIc']"));
		googleSearchBox.sendKeys("selenium");
		
		List<WebElement> autoSuggestion1 =driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		for(WebElement SingleAutoSuggetion : autoSuggestion1)
		{
			if(SingleAutoSuggetion.getText().equals("selenium webdriver"))
			{
				SingleAutoSuggetion.click();
			}
		}
	
	}
	
}
