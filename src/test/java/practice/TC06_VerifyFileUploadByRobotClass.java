package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC06_VerifyFileUploadByRobotClass 
{
	@Test
	public  void FileUploadByRobotClass (String[]args) throws AWTException, InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	
	WebDriver driver =new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://demoqa.com/upload-download");
	
	 JavascriptExecutor js = (JavascriptExecutor) driver; 
	 js.executeScript("window.scrollBy(0,100)");
	
	
	WebElement choosefilebutton = driver.findElement(By.id("uploadFile"));
	System.out.println("selenium focus on choosefilebutton");
	js.executeScript("arguments[0].click();", choosefilebutton);
	System.out.println("Clicked choosefilebutton");
	
	Thread.sleep(5000);
	
	Robot rb = new Robot();
	rb.delay(2000);
	
	StringSelection ss = new StringSelection("E:\\Video\\Educational\\Testing\\Velocity\\4 Automation\\Selenium\\Syllabus.docx");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	System.out.println("File Copied");
	rb.delay(2000);
	
	rb.keyPress(KeyEvent.VK_CONTROL);
	rb.keyPress(KeyEvent.VK_V);
	System.out.println("Press v");
	
	rb.keyRelease(KeyEvent.VK_CONTROL);
	rb.keyRelease(KeyEvent.VK_V);
	System.out.println("release v");
	rb.delay(2000);
	
	rb.keyRelease(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);
	System.out.println("enter done");
	rb.delay(2000);
	
	WebElement feedback = driver.findElement(By.xpath("//p[@id=\"uploadedFilePath\"]"));
	 if(feedback.isDisplayed()==true)
	 {System.out.println("Tc is pass");}
	 else
	 {System.out.println("Tc is failed");}
	}
}









	