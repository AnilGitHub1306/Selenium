package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC15_CounrTotalLinkWhenFilterBySamsung 
{
	@Test
	public  void CounrTotalLinkWhenFilterBySamsung () throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("implicit wait applied");
		
		driver.get("https://www.amazon.in/");
		System.out.println("URL Opened");
		
		 WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		 searchbox.click();
		 System.out.println("Search box clicked");
		 searchbox.clear();
		 System.out.println("Search box clear");
		 searchbox.sendKeys("mobiles");
		 System.out.println("Mobile entered in search box");
		 
		 WebElement mag = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		 mag.click();
		 System.out.println("clicked on magnifing ");
		 
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,100)");
		 
		 driver.findElement(By.xpath("//*[@id=\"brandsRefinements\"]/ul/li/span/div/a/i")).click();
		 System.out.println("Clicked on more");
		 
		 List<WebElement> one = driver.findElements(By.xpath("//*[@id=\"brandsRefinements\"]/ul/span/li/span/a"));
	
		 one.addAll(driver.findElements(By.xpath("//*[@id=\"brandsRefinements\"]/ul/li/span/div/div/ul/span/li")));
		 
		 System.out.println("capture one");
		 System.out.println("samsung name checking in one");
		for(WebElement i:one)
		{
			String a= i.getAttribute("aria-label");
			System.out.println(a);
			String b="Samsung";
			 
			if(a.equals(b))
			{System.out.println(a);
				i.click();
			System.out.println("samsung name found and clicked in one");break;}
			else
			{System.out.println("samsung name not found in one");}
		}
			
	
		List<WebElement> links = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
		System.out.println( links.size());
		
		for(WebElement i:links)
		{
			System.out.println(i.getAttribute("href"));
		}
		 
		 
	}
}
