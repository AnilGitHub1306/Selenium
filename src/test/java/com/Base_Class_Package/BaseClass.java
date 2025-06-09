package com.Base_Class_Package;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utiltiypackage.UtilityClass;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class BaseClass 
{
	public Logger log =Logger.getLogger("Automation_Practice_Feb2024");
	public ExtentSparkReporter spark ;// Responsible for -Look and Feel of report.
	public ExtentReports extent;            // Create entries and info
	public ExtentTest test;            // Update the status , update the logs
	public WebDriver driver ;            
	
	

	@BeforeClass
	public void extendReportSetup()
	{	
		spark= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport.html");
		spark.config().setTheme(Theme.STANDARD);               // Theme -  Dark, Standard
			
		extent=new ExtentReports();
		extent.attachReporter(spark);
	}
	
	@BeforeMethod
	public void setUp()
	{	
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		log.info("Opening browser");

		driver.manage().window().maximize();
		log.info("Maximising browser");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://demoqa.com/");
		log.info("Url Opened");	
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)					
		{test.log(Status.PASS,"TEST CASE IS PASS: "+result.getName());}/* add name in extent report*/
		
		else if(result.getStatus()==ITestResult.SKIP)
		{test.log(Status.SKIP,"TEST CASE IS SKIP: "+result.getName());}// add name in extent report
		
		
		else if(result.getStatus()==ITestResult.FAILURE)
		{test.log(Status.FAIL,"TEST CASE IS FAILURE: "+result.getName());// add name in extent report
		test.log(Status.FAIL,"TEST CASE IS FAILURE: "+result.getThrowable());  // add error and exceptions in extent report
		String sceenshotpath = UtilityClass.getSceenShot(driver, result.getName());
		test.addScreenCaptureFromPath(sceenshotpath);}   //add screenshot to extent report
		
	driver.quit();
	log.info("Browser closed");
	}

	@AfterClass
	public void extendReportTearDown()
	{extent.flush();}	
}
