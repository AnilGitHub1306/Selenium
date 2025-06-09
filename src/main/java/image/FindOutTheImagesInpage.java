package image;


import java.net.URL;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindOutTheImagesInpage 
{
	@Test
	public  void BrokenImages () throws Exception
	{
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	
	WebDriver driver =new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	//driver.get("https://demoqa.com/broken");
	driver.get("https://nmk.co.in/recruitment/");
	
	List<WebElement> Image_List=driver.findElements(By.tagName("img"));
	
	System.out.println("Total number of the images is: " +Image_List.size());
	int brokenImage =0;
	
	for(WebElement i : Image_List)
	{
		
		String Imagelink = i.getAttribute("src");
		System.out.println("Image src values : - "+Imagelink);
	
		if(Imagelink==null || Imagelink.isEmpty())
			{System.out.println("Image is empty");}
		else 
			{
			URL url = new  URL(Imagelink);
	
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(Imagelink);
			HttpResponse response = client.execute(request);
	
	if(response.getStatusLine().getStatusCode()!=200) 
		{System.out.println(response.getStatusLine().getStatusCode()+" status code for image   "+Imagelink+" - which is brocken image");;}
	else
		{System.out.println(response.getStatusLine().getStatusCode()+" status code for image   "+Imagelink+"  - which is normal image");}	
			}
	}
	
	System.out.println("Total number of brocken images : "+brokenImage);
	}
}




