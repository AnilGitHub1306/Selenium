package practice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ExtendReport 
{
	Logger log =Logger.getLogger("JunFirstWeek2023");
	public ExtentHtmlReporter htmlReporter ;     // Responsible for -Look and Feel of report.
	public ExtentReports extent;                 // Create entries and info
	public ExtentTest test;                      // Update the status , update the logs
	WebDriver driver ;
	
	
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
	public void setUp()
	{	
		PropertyConfigurator.configure("log4j.properties");
	//	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.info("Opening browser");
		driver.manage().window().maximize();
		log.info("Maximising browser");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://google.com");
		log.info("Url Opened");
		
	}
	
	
	
	@Test
	public  void VeifyTitleOfPage() 
	{test=extent.createTest("VeifyTitleOfThePage");
	String actualTitle = driver.getTitle();
	log.info("Actual Title of the page - "+actualTitle);
	
	String expectedTitle = "Google";
	Assert.assertEquals(actualTitle, expectedTitle);
	log.info("actualTitle and expected title are not match");

	}
	
	@Test
	public  void VeifyUrlOfPage() 
	{test=extent.createTest("VeifyUrlOfThePage");
	String actualUrl = driver.getCurrentUrl();
	String expectedUrl = "https://www.google.com/";
	Assert.assertEquals(actualUrl, expectedUrl);
	log.info("actualTitle and expected url are not match");
	
	
	}
	
	@Test
	public  void VeifyUrlOfPagefail() 
	{test=extent.createTest("VeifyUrlOfThePagefail");
	String actualUrl = driver.getCurrentUrl();
	String expectedUrl = "https://www.google.comm/";
	Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
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

	}
	
	@AfterTest
	public void extenttearDown()
	{ extent.flush();}
	
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
