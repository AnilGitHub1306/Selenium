package extentreport;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends ExtentReportGen implements ITestListener{

	public static ExtentTest  extentTest=null;
	
	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extent.createTest(result.getMethod().getMethodName());
		extentTest.log(Status.INFO, "----- Execution STARTED for Method : "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "----- Execution PASS for Method : "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result)  {
		extentTest.log(Status.FAIL, "----- Execution FAILED for Method : "+result.getMethod().getMethodName());
		String screenshotPath = System.getProperty("user.dir") + File.separator + "screenshot"
	            + File.separator + result.getMethod().getMethodName() + "_" + timestamp + ".png";
		
		 File src = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
		 File dest = new File(screenshotPath);
		
		 try 
		 	{FileHandler.copy(src, dest);} 
		 catch (IOException e) 
		 	{e.printStackTrace();}
		 
		 try 
		 	{extentTest.addScreenCaptureFromPath(screenshotPath);} // Adding ss to extent report
		 catch (IOException e) 
		 {e.printStackTrace();} 
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "----- Execution SKIPPED for Method : "+result.getMethod().getMethodName());

	}

	@Override
	public void onStart(ITestContext context) {
		getExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
