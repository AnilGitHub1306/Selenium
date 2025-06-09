package grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Capabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class executeCodeOnGredByThreads {

	public static void main(String[] args) {
		// Replace with your actual Grid Hub IP and port
		String hubUrl = "http://<hub-ip>:<hub-port>/wd/hub";

		new Thread(() -> runTestOnChrome(hubUrl)).start();
		new Thread(() -> runTestOnFirefox(hubUrl)).start();
		new Thread(() -> runTestOnEdge(hubUrl)).start();
	}

	public static void runTestOnChrome(String hubUrl) {
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		runTest(hubUrl, options);
	}

	public static void runTestOnFirefox(String hubUrl) {
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		runTest(hubUrl, options);
	}

	public static void runTestOnEdge(String hubUrl) {
		EdgeOptions options = new EdgeOptions();
		options.setAcceptInsecureCerts(true);
		runTest(hubUrl, options);
	}

	public static void runTest(String hubUrl, Capabilities options) {
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(hubUrl), options);
			driver.get("https://www.google.com"); // More stable for testing
			WebElement element = driver.findElement(By.name("q"));
			element.sendKeys("Selenium Grid");
			element.submit();
			Thread.sleep(3000); // wait for results to load
			System.out.println("[" + Thread.currentThread().getName() + "] Page title is: " + driver.getTitle());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}
}