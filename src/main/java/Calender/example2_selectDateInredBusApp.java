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

public class example2_selectDateInredBusApp {
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(op);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");

		// source
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("pune");
		Thread.sleep(2000);

		// dest
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("mumbai");
		Thread.sleep(2000);

		// open date menu
		driver.findElement(By.xpath("//div[@class='labelCalendarContainer']")).click();

		Thread.sleep(4000);

		//navigate to expected month -> Aug
		while (driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][2]")).getText().contains("Sep")==false) 
		{
			System.out.println("Hi");
			Thread.sleep(2000);
			//click on next btn
			driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][3]")).click();
			Thread.sleep(3000);
			System.out.println("Hello");
		}
		
		
		
		

		Thread.sleep(1000);

		List<WebElement> alldates = driver.findElements(By.xpath("//div[@class='DayTiles__CalendarDaysBlock-sc-1xum02u-0 isgDNj']"));

		for (WebElement date : alldates) 
		{
			if (date.getText().contains("4")) 
			{
				date.click();
				break;
			}
		}
	}
}