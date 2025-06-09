package mouseActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser opned");
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		System.out.println("Implicit wait applied");
		
		driver.get("https://demoqa.com/alerts");
		System.out.println("url opened");
		
		WebElement alert = driver.findElement(By.xpath("(//button[text()='Click me'])[1]"));
		Actions act = new Actions(driver);
		
	}

}
