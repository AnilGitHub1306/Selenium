package linksAndText;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.bouncycastle.oer.its.etsi102941.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindOutTheBrokenLinks 
{
	@Test
	public void findOutTheLinks() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",  "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("http://only-testing-blog.blogspot.com/2014/05/login.html");
		
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
					System.out.println(httpocon.getResponseCode()+" Broken Link : "+linkk+" : " +brokenlink++);
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
