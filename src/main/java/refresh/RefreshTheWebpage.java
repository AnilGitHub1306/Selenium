package refresh;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RefreshTheWebpage {

	public void refresh_By_Refresh_Method() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.navigate().refresh();
	}

	public void refresh_By_getCurrentUrl_Method() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.get(driver.getCurrentUrl());
		// OR
		driver.navigate().to(driver.getCurrentUrl());
	}

	public void refresh_By_sendKeys_Method() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.F5).perform();
		
	}
}
