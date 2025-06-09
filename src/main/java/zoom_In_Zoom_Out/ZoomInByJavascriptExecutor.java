package zoom_In_Zoom_Out;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZoomInByJavascriptExecutor 
{
	@Test
	public void zoomInByJavascriptExecutor() throws InterruptedException
	{
	//	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Object zoomLevelBefore = js.executeScript("return document.body.style.zoom;");
		System.out.println("Zoom level before: " + zoomLevelBefore);
		
		System.out.println("zooming");
	
		js.executeScript("document.body.style.zoom='200%'");
		Object zoomLevelAfter = js.executeScript("return document.body.style.zoom;");
		System.out.println("Zoom level after: " + zoomLevelAfter);
		
	
		
		
	}
}
