package BrokenLink;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class example1_BrokenLinks 
{
	//continue : used to end the current iteration in a for loop, 
	//            and continues to the next iteration
	
    public static void main(String[] args) {
        
        String homePage = "https://www.zlti.com";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(homePage);
        
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        
        
        for( WebElement s1: allLinks)
        {
            url = s1.getAttribute("href");
                    
            if(url == null || url.isEmpty())
            {
            	System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
            if(!url.startsWith(homePage))
            {
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try 
            {           	
                huc = (HttpURLConnection)(new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400)
                {
                    System.out.println(url+":- is a broken link");
                }
                else
                {
                    System.out.println(url+":- is a valid link");
                }
                    
            } 
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }      
        driver.quit();
    }
}