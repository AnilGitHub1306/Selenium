package log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatLog {
	@Test
	public void createLog() {
//		Logger log = Logger.getLogger("Automation_Practice_Feb2024");
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
//		PropertyConfigurator.configure("log4j.properties");
//		
//		log.info("Browser opened ");
//		
//		driver.get("https://www.google.com/");
//		
//		log.info("URL opened");
//		
//		String actualTitle = driver.getTitle();
//		log.info("actualTitle: ");
//		String expectedTitle = "Google";
//		log.info("expectedTitle: " );
//		
//		Assert.assertEquals(expectedTitle, actualTitle);
//		
//		driver.quit();
//		log.info("Browser closed");
//		log.info("************************************");
		Reporter.log("open browser", true);
		Reporter.log("open browser", true);
	}
}
