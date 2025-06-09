package dropDownHandling;

import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BynavigateThrowoptions {
	
	public static void main(String[] args) throws Exception {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(3000);

		List<WebElement> monthOptions = driver.findElements(By.xpath("//select[@id='month']//option"));		
		
		
		for(WebElement option:monthOptions )
		{
			String actualText =option.getText();
			if (actualText.equalsIgnoreCase("Mar"))
			{
				System.out.println(actualText);
				option.click();
				break;
			}
		}
		
	}

}
