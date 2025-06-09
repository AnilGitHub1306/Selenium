package window;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMoreWindowsDemoTwo {
	public static void main(String[] args) throws InterruptedException {
	    
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://omayo.blogspot.com/");
	    
	    String parentWindowId = driver.getWindowHandle();
	    
	    driver.findElement(By.id("selenium143")).click();
	    
	    driver.findElement(By.linkText("Open a popup window")).click();
	    
	    Set<String> windowIds = driver.getWindowHandles();
	    
	    for(String windowId : windowIds) {
	      
	      driver.switchTo().window(windowId);
	      
	      String currentWindowTitle = driver.getTitle();
	      
	      if(currentWindowTitle.equals("New Window")){
	        String headingText = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
	        System.out.println(headingText);
	        Thread.sleep(3000);
	        driver.close();
	      }else if(currentWindowTitle.contains("Selenium143")) {
	        driver.findElement(By.linkText("What is Selenium?")).click();
	        Thread.sleep(3000);
	        driver.close();
	      }
	      
	    }
	    
	    driver.switchTo().window(parentWindowId);
	    
	    driver.findElement(By.id("ta1")).sendKeys("Arun Motoori");
	    Thread.sleep(3000);
	    driver.quit();

	  }

}
