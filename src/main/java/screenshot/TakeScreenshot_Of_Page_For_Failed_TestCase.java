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
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TakeScreenshot_Of_Page_For_Failed_TestCase 
{
	public static ChromeDriver driver=null;
	
	public static String date1()
	{Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd & HH-mm-ss");
	String date = sdf.format(d);
	System.out.println(date);
	return date;
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException 
	{

		if(ITestResult.FAILURE==result.getStatus()) 
		{	
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/formsDropDownPage"+result.getMethod().getMethodName()+TakeScreenshot_Of_Page_For_Failed_TestCase.date1()+".png");
		FileHandler.copy(source, dest);
		
		System.out.println("Screenshot taken");
		driver.quit();
		}
	}
	
	@Test
	public void takeScreenshot_Of_Page_For_Failed_TestCase () 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://demoqa.com/accordian");
		
		WebElement formsDropDown = driver.findElement(By.xpath("//div[@class='element-group'][1]"));
		Assert.assertFalse(formsDropDown.isDisplayed());
		System.out.println("assertion is failed");
		Assert.assertTrue(false);
		//Assert.assertTrue(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
