package window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingStaleElementReferenceExceptionDemo {
	public static void main(String[] args) throws InterruptedException {
	    
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://omayo.blogspot.com/");
	    
	    WebElement blueElement = driver.findElement(By.id("checkbox2"));
	    
	    blueElement.click();
	    
	    Thread.sleep(2000);
	    
	    driver.navigate().to("https://selenium143.blogspot.com/");
	    
	    Thread.sleep(2000);
	    
	    driver.navigate().back();
	    
	    Thread.sleep(2000);
	    
	    blueElement = driver.findElement(By.id("checkbox2"));
	    
	    blueElement.click();

	  }

}
