package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC23_Select_Multiple_Options_In_dropdown 
{

	public void Selectmultipleoptionsindropdown()
	{
		System.setProperty("webdriver.chrome.driver","./driver.chromedriver.exe"); 
				 WebDriver driver = new ChromeDriver(); 
				 
				driver.get("file:///C:/Users/Jordan/Desktop/Velocity%20Testing1/HTML/Select_Country1.html"); 
				 
				//Step.1 : Identify the webElement which need to be handling and store 
				
				WebElement country = 
				driver.findElement(By.xpath("//select[@id='1234']")); 
				 
				//Step.2: Create an object of select class which accept WebElement 
				
				 Select sm = new Select(country); 
				 
				//Step.3 : USe select class method to select options
				 sm.selectByIndex(0); 
				 sm.selectByVisibleText("England"); 
	} 
}
	

