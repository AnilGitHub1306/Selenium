package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class executingTestOnGrid {
	
	public static WebDriver driver = null;
	
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(@Optional("chrome") String browserName) throws MalformedURLException { 
		String hubUrlAsString = "http://<hub-ip>:<hub-port>/wd/hub"; // 🔁 Replace with actual IP and port
		URL hubUrl = new URL(hubUrlAsString);
		
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			driver = new RemoteWebDriver(hubUrl, options);
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.setAcceptInsecureCerts(true);
			driver = new RemoteWebDriver(hubUrl, options);
			
		} else if (browserName.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.setAcceptInsecureCerts(true);
			driver = new RemoteWebDriver(hubUrl, options);
			
		} else {
			System.out.println("❌ Enter a valid browser name like chrome, firefox, or edge.");
		}
	}
	
	@Test
	public void testMethod() {
		driver.get("https://www.facebook.com/");
		System.out.println("✅ Title: " + driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}


