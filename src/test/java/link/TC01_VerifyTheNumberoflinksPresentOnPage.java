package link;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC01_VerifyTheNumberoflinksPresentOnPage 
{	
	@Test
	public  void NumberoflinksPresentOnPage ()
	{
	//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	WebDriverManager.chromedriver().setup();
	WebDriver driver =new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://nmk.co.in/recruitment/");
	
	
	List<WebElement> links=driver.findElements(By.tagName("a"));
	System.out.println(links.size());
	
//	for(int i=0; i<links.size();i++)
//	{
//		String ActualText = links.get(i).getText();
//	//	System.out.println(ActualText);
//		String ExpectedText = "ENGLISH";
//		if(ActualText.equals(ExpectedText))
//		{System.out.println("Test case is pass");}
//	//Assert.assertEquals(ActualText, ExpectedText);
//	
//	}
	
	int max=0;
	for(WebElement i :links)
	{
			String ActualText = i.getText(); 
			String linkk=i.getAttribute("href");
			String ExpectedText = "ENGLISH";
			
			System.out.println(ActualText);
			System.out.println(linkk);
			max++;
		//	if(ActualText.equals(ExpectedText))
		//	{System.out.println("Test case is pass");}
	}
	
	System.out.println(max);
	
	}
}
