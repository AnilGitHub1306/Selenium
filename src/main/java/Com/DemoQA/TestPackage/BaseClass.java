package Com.DemoQA.TestPackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass 
{
	public WebDriver driver;
	Logger log =Logger.getLogger("JunFirstWeek2023");	
	
	public ExtentHtmlReporter htmlReporter ;     // Responsible for -Look and Feel of report.
	public ExtentReports extent;                 // Create entries and info
	public ExtentTest test;                      // Update the status , update the logs
	
	
	@BeforeTest
	public void extentSetup()
	{
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport.html");
		htmlReporter.config().setDocumentTitle("Automation report");  // Title of the report
		htmlReporter.config().setReportName("Functional report");     // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);               // Theme -  Dark, Standard
	
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("TesterName", "ANIL");
		extent.setSystemInfo("BrowseName", "Chrome");
	}
	
	
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		PropertyConfigurator.configure("log4j.properties");
		
		driver =new ChromeDriver();
		log.info("browser opened");
	//	Reporter.log("browser opened", true);
		
	//	ScreenShot.ScreenShotMethod("browser opened");
	
		driver.manage().window().maximize();
		log.info("Window Maximize");
	//	Reporter.log("Window Maximize", true);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://demoqa.com/");
		log.info("url opened");
	//	Reporter.log("url opened", true);
	//	ScreenShot.ScreenShotMethod("url opened");
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception 
	{
		if(result.getStatus()==ITestResult.SUCCESS)					
		{test.log(Status.PASS,"TEST CASE IS PASS: "+result.getName());}			 // add name in extent report
		
		else if(result.getStatus()==ITestResult.FAILURE)
		{test.log(Status.FAIL,"TEST CASE IS FAILURE: "+result.getName());       // add name in extent report
		test.log(Status.FAIL,"TEST CASE IS FAILURE: "+result.getThrowable());  // add error and exceptions in extent report
			
		 String sceenshotpath = getSceenShot(driver,result.getName());
		 test.addScreenCaptureFromPath(sceenshotpath);}                                    // add screenshot to extent report
			
		else if(result.getStatus()==ITestResult.SKIP)
		{test.log(Status.SKIP,"TEST CASE IS SKIP: "+result.getName());}			// add name in extent report
		
		driver.quit();
		log.info("Browser closed");
	//	Reporter.log("browser closed", true);
	//	ScreenShot.ScreenShotMethod("browser closed");
	}
	public static String getSceenShot(WebDriver driver, String imageName) throws IOException
	{Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy & hh-mm-ss");
	String date = sdf.format(d);

	TakesScreenshot ts = (TakesScreenshot) driver;
	File sourceFile = ts.getScreenshotAs(OutputType.FILE);
	String path= System.getProperty("user.dir")+"/screenshot/"+date+imageName+".png";
	File destFile    = new File(path);
	FileHandler.copy(sourceFile, destFile);
	return path;}
}
