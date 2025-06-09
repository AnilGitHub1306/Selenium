package dropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class date_DropDown 
{

	@Test
	public void select_Date_Dropdown()
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		JavascriptExecutor js =(JavascriptExecutor) driver;
		
		WebElement dropDownElement = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		
		js.executeScript("arguments[0].scrollIntoView();",dropDownElement);
		
		dropDownElement.click();
		System.out.println("dropDownElement clicked");
	
		WebElement yearDropDownElement = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		WebElement monthDropDownElement = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		
		
		
		Select s1 = new Select(yearDropDownElement);
		Select s2 = new Select(monthDropDownElement);
		
		
		s1.selectByVisibleText("1993");
		s2.selectByVisibleText("June");
		
		List<WebElement> date1 =  driver.findElements(By.xpath("//div[@role='option']"));
		for(WebElement i : date1)
		{
			String no="13";
			if(i.getText().equals(no))
			{
				i.click();
				break;
			}
		}

		WebElement dateOfbirth = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		
		if(dateOfbirth.getText().equals("13 Jun 1993"))
			{
			System.out.println("TC Pass");
			
			}
	}
	


	
}
