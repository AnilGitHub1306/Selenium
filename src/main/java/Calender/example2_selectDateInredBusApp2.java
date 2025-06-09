package Calender;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class example2_selectDateInredBusApp2 {
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(op);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");

		// open date menu
		driver.findElement(By.xpath("//div[@id='onwardCal']")).click();
		Thread.sleep(4000);

		List<WebElement> dates = driver.findElements(By.xpath("//span[text()='1']"));
		
		
		
		

		

	}
}