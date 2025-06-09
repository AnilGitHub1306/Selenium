package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utility.Scroling;

public class TC21_PracticeForm 
{	static WebDriver driver;
	@Test
	public void PracticeForm() throws Exception
	{
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	
	WebDriver driver =new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://demoqa.com/automation-practice-form");
	
	WebElement fname= driver.findElement(By.xpath("//input[@id='firstName']"));
	fname.clear();
	fname.sendKeys("Anil");
	System.out.println("First name enter");
	
	WebElement lname= driver.findElement(By.xpath("//input[@id='lastName']"));
	lname.clear();
	lname.sendKeys("simon");
	System.out.println("last name enter");
	
	WebElement email= driver.findElement(By.xpath("//input[@id='userEmail']"));
	email.clear();
	email.sendKeys("anil@examaple.com");
	System.out.println("email enter");
	
	WebElement mobilenumber= driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
	mobilenumber.clear();
	mobilenumber.sendKeys("1234567890");
	System.out.println("mobile number enter");
	
	List<WebElement> gender= driver.findElements(By.xpath("//input[@name='gender']"));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView;", gender);
	//js.executeScript("window.scrollBy(0,250)");
	
	for(WebElement gen:gender)
	{
		if(gen.getAttribute("value").equals("Male"))
		{
			js.executeScript("arguments[0].click();", gen);
			System.out.println("gender male selected");
			break;
		}
	}

	
//	js.executeScript("window.scrollBy(0,100)");
	
	WebElement dateOfBirth= driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
	js.executeScript("arguments[0].scrollIntoView;", dateOfBirth);
	js.executeScript("arguments[0].click();", dateOfBirth);
	System.out.println("clicked on date of birth");
	
	WebElement yearsdrop= driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
	WebElement monthsdrop= driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
	WebElement datesdrop= driver.findElement(By.xpath("//div[@role='option']"));
	
		String year = "2000";
		String month = "Jun";
		String date = "13";
		
		dropdown(yearsdrop,year);
		System.out.println("year selected");
		Thread.sleep(2000);
		dropdown(monthsdrop,month);
		System.out.println("month selected");
		Thread.sleep(2000);
		WebElement dates11= driver.findElement(By.xpath("//div[@aria-label='Choose Thursday, June 1st, 2023']"));
		dates11.click();
		System.out.println("date selected");
	
	}
	
	
	 public static void dropdown(WebElement A , String B)
		{
	Select s= new Select(A);
	List<WebElement> el= s.getOptions();
	for(WebElement i:el)
	{
		if(i.getText().equals(B))
		{
			i.click();
			System.out.println(B+" is selected");
			break;
		}
	}
	}
		
		
	
}
