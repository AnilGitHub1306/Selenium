package screenshot;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TakeScreenshot_Of_WebElement 
{
	@Test
	public void takeScreenshot_Of_WebElement() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/accordian");
		
		WebElement formsDropDown = driver.findElement(By.xpath("//div[@class='element-group'][1]"));
		
		File source = formsDropDown.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/formsDropDown1.png");
		FileHandler.copy(source, dest);
		
		driver.quit();
		
		
		
	}
}
