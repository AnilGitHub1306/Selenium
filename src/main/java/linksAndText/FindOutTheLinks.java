package linksAndText;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindOutTheLinks 
{
	@Test
	public void findOutTheLinks()
	{
		System.setProperty("webdriver.chrome.driver",  "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("http://only-testing-blog.blogspot.com/2014/05/login.html");	
		List<WebElement> listOflink = driver.findElements(By.tagName("a"));
		
		System.out.println("Number of link present on page is : "+listOflink.size());
	
		for(WebElement link : listOflink)
		{
			System.out.println(link.getAttribute("href"));
		}
	}
}
