package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC04_VerifyThatUploadworkingFine 
{
	@Test
	public  void UploadworkingFile() throws Exception
	{
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	
	WebDriver driver =new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://demoqa.com/upload-download");
	
	WebElement Downloadbutton = driver.findElement(By.xpath("//input[@type='file']"));
	
	Downloadbutton.sendKeys("C:\\Users\\admin\\Downloads\\sampleFile.jpeg");
	
	
	WebElement feedback = driver.findElement(By.xpath("//p[text()='C:\\fakepath\\sampleFile.jpeg']"));
	String a= feedback.getText();
	String b="C:\\fakepath\\sampleFile.jpeg";
	
	if(feedback.isDisplayed()==true)
	{
		System.out.println("Test case is pass");
	}
	else
	{System.out.println("Test case is failed");}
	driver.quit();
	//Robot robot = new Robot(); 
	
	}
}
