package mouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ClickActionByJavascripExecutor {
	
	@Test
	public void clickAction() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		
		WebElement clickCheckThisButton=driver.findElement(By.xpath("//input[@id='dte']"));
		
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		
		jsDriver.executeScript("arguments[0].scrollIntoView();", clickCheckThisButton);
		jsDriver.executeScript("arguments[0].click();", clickCheckThisButton);
		
		
		
		
		
		
		
	}

}
