package window;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMoreThanTwoWindowsDemo {
	public static void main(String[] args) throws InterruptedException {
	    
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://omayo.blogspot.com/");
	    
	    driver.findElement(By.id("ta1")).sendKeys("Arun Motoori");
	    
	    String parentWindowId = driver.getWindowHandle();
	    
	    Thread.sleep(3000);
	    
	    driver.findElement(By.id("selenium143")).click();
	    
	    Thread.sleep(3000);
	    
	    Set<String> windowIds = driver.getWindowHandles();
	    
	    String selenium143ChildWindowId = null;
	    
	    for(String windowId : windowIds) {
	      
	      if(!windowId.equals(parentWindowId)) {
	        selenium143ChildWindowId = windowId;
	      }
	      
	    }
	    
	    Thread.sleep(3000);
	    
	    driver.findElement(By.linkText("Open a popup window")).click();
	    
	    windowIds = driver.getWindowHandles();
	    
	    String newWindowChildWindowId = null;
	    
	    for(String windowId : windowIds) {
	      
	      if(!windowId.equals(parentWindowId) && !windowId.equals(selenium143ChildWindowId)) {
	        newWindowChildWindowId = windowId;
	      }
	    }
	    
	    driver.switchTo().window(newWindowChildWindowId);
	    
	    String childWindowHeading = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
	    System.out.println(childWindowHeading);
	    driver.close();
	    
	    driver.switchTo().window(parentWindowId);
	    
	    driver.findElement(By.name("q")).sendKeys("Arun");
	    
	    Thread.sleep(3000);
	    
	    driver.switchTo().window(selenium143ChildWindowId);
	    
	    driver.findElement(By.linkText("What is Selenium?")).click();
	    
	    Thread.sleep(3000);
	    
	    driver.close();
	    
	    driver.switchTo().window(parentWindowId);
	    
	    driver.findElement(By.id("ta1")).clear();
	    
	    driver.findElement(By.name("q")).clear();
	    
	    Thread.sleep(3000);
	    
	    driver.quit();
	    
	  }

}
