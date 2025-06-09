package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC04_VerifyTheFileUpload 
{
	@Test
	public  void FileUpload () throws Exception
	{
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	
	WebDriver driver =new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://demoqa.com/upload-download");
	
	WebElement choosefilebutton = driver.findElement(By.xpath("//input[@id=\"uploadFile\"]"));
	//choosefilebutton.click();
	
	choosefilebutton.sendKeys("E:\\Video\\Educational\\Testing\\Velocity\\4 Automation\\Selenium\\Syllabus.docx");
	
	WebElement feedback = driver.findElement(By.xpath("//p[@id=\"uploadedFilePath\"]"));
	 if(feedback.isDisplayed()==true)
	 {System.out.println("Tc is pass");}
	 else
	 {System.out.println("Tc is failed");}
	
	}
}
