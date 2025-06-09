package CustomizedListbox;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class example2_selectNovOption
{
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		Thread.sleep(3000);
		
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		
		Actions act=new Actions(driver);
		act.click(month).perform();
				
		Thread.sleep(2000);
		
		
		//navigate to 1st option using Home Key
		act.sendKeys(Keys.HOME).perform();
		Thread.sleep(2000);
		
		
		//navigate to Nov option
		for(int i=1; i<=10; i++)
		{
			act.sendKeys(Keys.ARROW_DOWN).perform();
		}
		
		Thread.sleep(2000);
		
		
		act.sendKeys(Keys.ENTER).perform();
		
	}
}
