package screenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Utility;

public class ScreenShot_For_FailedTestCases 
{
	WebDriver driver;

	@Test  
	public void Test1() 
	{
		WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		 System.out.println("Browse opened");
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		 driver.get("https://www.saucedemo.com/v1/");
		 System.out.println("url opened");
		 
		 
		String TitleOfPage =  driver.getTitle();
		 System.out.println("Title Of Page = " + TitleOfPage);
		 
		String URLOfThePage = driver.getCurrentUrl();
		 System.out.println("URL Of The Page = " + URLOfThePage);
		 
		String PageSource = driver.getPageSource();
		 System.out.println("Page Source = " + PageSource);
		 
		Object ClassOfPage=driver.getClass();
		 System.out.println("Class Of Page = " + ClassOfPage);
		 
		String WindowHandleOfPage = driver.getWindowHandle();
		 System.out.println("Window Handle Of Page = " + WindowHandleOfPage);
			
		 Assert.assertEquals(false, true);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		
		System.out.println("Test Failed =" + result.getStatus());
		
		if(ITestResult.FAILURE == result.getStatus())
		{
		
			TakesScreenshot tsobj =(TakesScreenshot)driver;
			File SrcFile= tsobj.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("./screenshot/"+result.getName()+".png");
			FileHandler.copy(SrcFile, DestFile);

			//**********or***********
			
			//	Utility utilobj = new Utility();
			//	utilobj.ScreenshotOfPage(driver, result.getName());
			
			driver.quit();
		}
	}

}
