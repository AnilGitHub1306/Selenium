package linksAndText;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindOutTheTextBoxex 
{
	@Test
	public void findOutTheTextBoxex () throws Exception
	{
		System.setProperty("webdriver.chrome.driver",  "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("http://only-testing-blog.blogspot.com/2014/05/login.html");	
		
		List<WebElement> txtfields = driver.findElements(By.xpath("//input[@type='text' or       @type='password']"));
		 
		int numberOfTextBox = txtfields.size();
		System.out.println(numberOfTextBox);
		
	 	 //for loop to send text In all text box one by one.
	  	for(int a=0; a<txtfields.size();a++)
	   		 {   
	    		 txtfields.get(a).sendKeys("Text"+a+1);
	    	 }
	   	 Thread.sleep(3000);
	   	driver.quit();
	 }

	
}

