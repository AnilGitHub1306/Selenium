package screenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TakeScreenshot_Of_Page_With_Date 
{
	@Test
	public void takeScreenshot_Of_Page() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/accordian");
		
		WebElement formsDropDown = driver.findElement(By.xpath("//div[@class='element-group'][1]"));
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+TakeScreenshot_Of_Page_With_Date.date1()+"formsDropDownPage.png");
		FileHandler.copy(source, dest);
		
		driver.quit();
	}
	
	
	
	public static String date1()
	{Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd & HH-mm-ss");
	String date = sdf.format(d);
	System.out.println(date);
	return date;
	}
	
	
	
}
