package ScrollUpDown;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class example1_ScrollUpDown
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		//scroll down :->  1st parameter: 0,  2nd parameter: +ve
	//	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,350)");
		
	//	Thread.sleep(2000);
				
		//scroll up :->  1st parameter: 0,  2nd parameter: -ve
	//	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-100)");
		
		
//		//scroll right :->  1st parameter: +ve,  2nd parameter: 0
//		((JavascriptExecutor)driver).executeScript("window.scrollBy(100,0)");
//		
//		
//		//scroll left :->  1st parameter: -ve,  2nd parameter: 0
//	   ((JavascriptExecutor)driver).executeScript("window.scrollBy(-50,0)");
		
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		
		act.sendKeys(Keys.ARROW_UP).perform();
		act.sendKeys(Keys.ARROW_UP).perform();
		act.sendKeys(Keys.ARROW_UP).perform();
		act.sendKeys(Keys.ARROW_UP).perform();
		act.sendKeys(Keys.ARROW_UP).perform();
		act.sendKeys(Keys.ARROW_UP).perform();
		act.sendKeys(Keys.ARROW_UP).perform();
		
		
		 
		Thread.sleep(2000);
		driver.quit();
		System.out.println("window closed");
	}
}
