package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class TC17_Form_DateAndTime 
{
	@Test
	public void DateAndTime () throws AWTException, InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://demoqa.com/automation-practice-form");
	
	 JavascriptExecutor js = (JavascriptExecutor) driver; 
	 js.executeScript("window.scrollBy(0,100)");
	
	
	WebElement date = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
	System.out.println("selenium focus on date");
	js.executeScript("arguments[0].click();", date);
	System.out.println("Clicked date");
	
	Thread.sleep(5000);
	 
	 js.executeScript("window.scrollBy(0,100)");
	
	WebElement year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
	year.click();
	Select s1= new Select (year);
	s1.selectByValue("1993");
	System.out.println("Clicked year");
	
	WebElement month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
	month.click();
	Select s2= new Select (month);
	s2.selectByVisibleText("June");
	System.out.println("Clicked month");
	
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
	
	Thread.sleep(5000);
	
	String a= date.getAttribute("value");
	System.out.println(a);
	String b = "13 Jun 1993";
	if(a.equals(b))
	{System.out.println("tc pass");}
	else
	{System.out.println("tc fail");}
	
	
	}
}
