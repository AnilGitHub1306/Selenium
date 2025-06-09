package link;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC02_VerifyBrokenLinks 
{ 
	@Test
	public  void BrokenLinks (Object HttpURLConnection) throws Exception
	{
	//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	WebDriverManager.chromedriver().setup();
	WebDriver driver =new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("http://www.deadlinkcity.com/");
	
	List<WebElement> liks=driver.findElements(By.tagName("a"));
	
	int brokenlink=0;
	for(WebElement i:liks)
	{	
		String linkk=i.getAttribute("href");
		
		if(linkk==null || linkk.isEmpty())
			{System.out.println("link is empty");}
		else 
			{URL url = new  URL(linkk);
			
			HttpURLConnection httpocon =(HttpURLConnection) url.openConnection();
			httpocon.connect();
	
			if(  httpocon.getResponseCode()>=400) 
				{
				System.out.println(httpocon.getResponseCode()+" status code for link   "+linkk+" - which is brocken link");brokenlink++;
				if(linkk.equals("http://www.deadlinkcity.com/page-not-found.asp"))
				{
				System.out.println("TC IS PASS");
				brokenlink++;}}
			else
				{System.out.println(httpocon.getResponseCode()+" status code for link   "+linkk+"  - which is normal link");}	
			}System.out.println("Number of broken links - "+ brokenlink);
	}
	
	driver.close();
	
	
	
	
	}
}
