package extentReport;

import java.io.File;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListner implements IReporter 
{
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setupExtentReport() {
        // Path to store the report
        String reportPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "ExtentReport.html";

        // Create Spark reporter
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setReportName("Functional Test Report");
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setTheme(Theme.DARK);

        // Attach to ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(spark);

        // Add system info
        extent.setSystemInfo("Tester", "Anil");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @Test
    public void demoTest() {
        test = extent.createTest("Demo Test Case");

        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        driver = new ChromeDriver();
        test.log(Status.INFO, "Chrome browser opened");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/");
        test.log(Status.PASS, "Navigated to demoqa.com");

        driver.quit();
        test.log(Status.INFO, "Browser closed");
    }

    @AfterTest
    public void tearDownReport() {
        // Write everything to the report
        extent.flush();
    }
}
