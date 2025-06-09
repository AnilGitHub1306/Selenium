package zoom_In_Zoom_Out;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ZoomInBySendKeys 
{
	@Test
	public void zoomInBySendKeys() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("zooming");
		// To zoom in 3 times
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.ADD).keyUp(Keys.CONTROL).perform();
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).perform();
		
//		for(int i=0; i<3; i++){ 
//			driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ADD));}
	}
}
