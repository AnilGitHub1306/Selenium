package extentreport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGen {
	
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static String timestamp=null;
	
	public static void getExtentReport() {
		
		timestamp=  new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		System.out.println(timestamp);
		String extentReportPath= System.getProperty("user.dir")+File.separator+"reports"+File.separator+"ExtentReport"+timestamp+".html";		
		
		extent = new ExtentReports();
		extent.setSystemInfo("Tester Name", "Anil Adhav");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		spark = new ExtentSparkReporter(extentReportPath);
		extent.attachReporter(spark);
		spark.config().setReportName("Automation Test Report");
		spark.config().setDocumentTitle("Project XYZ - Regression Execution Report");
		
	}

	
}
