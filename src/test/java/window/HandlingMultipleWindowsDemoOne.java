package window;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWindowsDemoOne {
	public static void main(String[] args) throws InterruptedException {
	    
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://omayo.blogspot.com/");
	    
	    String parentWindowId = driver.getWindowHandle();
	    
	    driver.findElement(By.linkText("Open a popup window")).click();
	    
	    Set<String> windowIds = driver.getWindowHandles();
	    
	    String childWindowId = null;
	    
	    for(String windowId : windowIds) {
	      
	      if(!windowId.equals(parentWindowId)) {
	        childWindowId = windowId;
	      }
	    }
	    
	    driver.switchTo().window(childWindowId);
	    
	    String childWindowHeading = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
	    
	    System.out.println(childWindowHeading);
	    
	    driver.close();
	    
	    driver.switchTo().window(parentWindowId);
	    
	    driver.findElement(By.id("ta1")).sendKeys("Arun Motoori");
	    
	    Thread.sleep(3000);
	    
	    driver.quit();

	  }

}
