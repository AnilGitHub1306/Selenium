package Notifications;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DisableNotificationForFirefox1 {
	public static void main(String[] args) throws InterruptedException {
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("dom.webnotifications.enabled", false);      // Disable web notifications
		options.addPreference("dom.push.enabled", false);                  // Disable push notifications
		options.addPreference("geo.enabled", false);                       // Disables geolocation feature
//		options.addPreference("geo.provider.use_corelocation", false);     // Disables core location on macOS
//		options.addPreference("geo.prompt.testing", false);                // Prevents location prompts
//		options.addPreference("geo.prompt.testing.allow", false);          // Denies location access by default

		WebDriver driver = new FirefoxDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.justdial.com/");
		Thread.sleep(10000);
		driver.quit();
	}
}