package image;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC03_VerifyThatTheBrokenImages 
{	
	@Test
	public  void BrokenImages () throws Exception
	{
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	
	WebDriver driver =new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://demoqa.com/broken");
	
	List<WebElement> Image_List=driver.findElements(By.tagName("img"));
	
	System.out.println("Number of the images is- " +Image_List.size());
	int brokenImage=0;
	for(WebElement i : Image_List)
	{
		String Imagelistas = i.getAttribute("src");
	System.out.println("Image src values - "+Imagelistas);
	
	if(Imagelistas==null || Imagelistas.isEmpty())
	{System.out.println("Image is empty");}
	else 
	{
		URL url = new  URL(Imagelistas);
	
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(Imagelistas);
		HttpResponse response = client.execute(request);
	
	if(response.getStatusLine().getStatusCode()!=200) 
		{System.out.println(response.getStatusLine().getStatusCode()+" status code for image   "+Imagelistas+" - which is brocken image");brokenImage++;}
	else
		{System.out.println(response.getStatusLine().getStatusCode()+" status code for image   "+Imagelistas+"  - which is normal image");}	
	}
	}
}}
