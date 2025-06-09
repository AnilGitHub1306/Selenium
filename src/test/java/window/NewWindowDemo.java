package window;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowDemo {
	 public static void main(String[] args) throws InterruptedException {
		    
		    ChromeDriver driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://omayo.blogspot.com/");
		    
		    driver.findElement(By.id("ta1")).sendKeys("Arun Motoori");
		    
		    Thread.sleep(3000);
		    
		    driver.switchTo().newWindow(WindowType.TAB);
		    
		    driver.get("http://www.selenium143.blogspot.com/");
		    
		    driver.findElement(By.linkText("What is Selenium?")).click();
		    
		    Thread.sleep(3000);
		    
		    driver.switchTo().newWindow(WindowType.WINDOW);
		    
		    driver.get("https://selenium-by-arun.blogspot.com/");
		    
		    driver.findElement(By.xpath("//a[@href='https://www.youtube.com/c/QAFox/playlists']/img")).click();

		    Thread.sleep(3000);
		    
		    driver.quit();
		  
		  }

}
