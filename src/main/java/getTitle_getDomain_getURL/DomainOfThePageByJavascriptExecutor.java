package getTitle_getDomain_getURL;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DomainOfThePageByJavascriptExecutor 
{
	@Test
	public void domainOfThePageByJavascriptExecutor () 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/questions/index.php");
		
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		
		String s = js.executeScript("return document.domain;").toString();
		System.out.println(s);
		driver.quit();
	}
}
