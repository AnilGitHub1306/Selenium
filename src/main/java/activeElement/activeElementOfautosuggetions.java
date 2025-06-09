package activeElement;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class activeElementOfautosuggetions {

	@Test
	public void activeelement() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

		// WebElement alert = driver.findElement(By.xpath("//button[text()='Stay signed
		// out']"));
		// wait.until(ExpectedConditions.visibilityOf(alert));
		// alert.click();

		WebElement searchArea = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		searchArea.sendKeys("youtub");
		Thread.sleep(10000);
//		WebElement optionField= driver.findElement(By.xpath("(//ul[@class='G43f7e'])[1]"));

		// wait.until(ExpectedConditions.visibilityOf(optionField));

		Actions act = new Actions(driver);

		List<WebElement> listOfOption = driver.findElements(By.xpath("(//ul[@class='G43f7e'])[1]//li"));
		System.out.println("number of oprions visible : " + listOfOption.size());

		for (WebElement option : listOfOption) {
			String optionText = option.getText();
			System.out.println(optionText);

			if (option.getText().equalsIgnoreCase("youtube video")) {
				System.out.println("required option ounf and clicked: ");
				option.click();
				System.out.println("clicked the button");
				break;
			}

		}

		Thread.sleep(3000);
		driver.quit();

	}
}
