package BrokenLink;

// Java program to detect broken
// links on the webpage
// Imported Packages
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class example2_BrokenLinks {
	
	public static void main(String[] args) throws IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		List<WebElement> allLinksWebEle = driver.findElements(By.tagName("a")); // Getting All The Links In One List
		System.out.println("Total Link Size: " + allLinksWebEle.size()); // Printing The Total Links Number

		for (WebElement singleElement : allLinksWebEle) 
		{
			String stringURL = singleElement.getAttribute("href");
			
			if(stringURL==null || stringURL.isEmpty())		
			{
				System.out.println("Empty URL field -------");
				continue;
			}
			else if(stringURL.startsWith("javascript") || stringURL.startsWith("mailto"))
			{
				System.out.println("Skipping non-http link: " + stringURL); 
				continue;
			}
			else 
			{
				try 
				{
					URL link = new URL(stringURL);
					HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
				    httpConn.setConnectTimeout(5000); // 5-second connection timeout
			        httpConn.setReadTimeout(5000);    // 5-second read timeout
			        httpConn.setRequestMethod("HEAD");
					httpConn.connect();
					
					int statusCode = httpConn.getResponseCode(); // Getting The Response Code

					if (statusCode >= 400) 		// If The status code Is Greater Than 400, Then It Is Broken Link
						{System.out.println("Broken Link: " + stringURL);} 
					else 
						{System.out.println("Valid Link: " + stringURL);}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		driver.quit();
	}
}
