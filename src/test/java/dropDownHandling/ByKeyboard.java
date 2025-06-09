package dropDownHandling;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ByKeyboard {
	
	public static void main(String[] args) throws Exception {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(2000);
		WebElement monthDropDown = driver.findElement(By.xpath("//select[@id='month']"));
		Actions act=new Actions(driver);
		act.click(monthDropDown).perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.PAGE_UP).perform();
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    String selectedOptionText = (String) js.executeScript("return arguments[0].options[arguments[0].selectedIndex].text;", monthDropDown);
	    System.out.println(selectedOptionText);
		Thread.sleep(2000);	Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		  String selectedOptionText1 = (String) js.executeScript("return arguments[0].options[arguments[0].selectedIndex].text;", monthDropDown);
		    System.out.println(selectedOptionText1);
		

	}

}
