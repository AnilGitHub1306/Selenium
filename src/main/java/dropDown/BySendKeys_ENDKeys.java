package dropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BySendKeys_ENDKeys {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");

		WebElement dropDown = driver.findElement(By.xpath("//select [1]"));
		dropDown.click();
		
		Actions act = new Actions(driver);
		
		act.sendKeys(dropDown, Keys.END).perform();
		
		for(int i=1; i<=146;i++) {
			act.sendKeys(Keys.ARROW_UP).click().perform();
		}
		
	}

}
