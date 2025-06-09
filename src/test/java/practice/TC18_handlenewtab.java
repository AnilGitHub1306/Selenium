package practice;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC18_handlenewtab 
{
	@Test
	public static void NewTab()
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("https://demoqa.com/browser-windows");
		System.out.println("browser opened with window page"); 
		
		WebElement newTabbtn = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabbtn.click();
		System.out.println("new tab is clicked");
		
		ArrayList<String>pageadds= new ArrayList<String>(driver.getWindowHandles());
		System.out.println("All page addresses captured");
		
		String newTabAdd = pageadds.get(1);
		System.out.println("New tab address is - " + newTabAdd);
		
		driver.switchTo().window(newTabAdd);
		System.out.println("Switched to new tab");
		
		WebElement text = driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
		String actualtext = text.getText();
		String expectedtext = "This is a sample page";
		
		Assert.assertEquals(actualtext, expectedtext);
		
	}
}
