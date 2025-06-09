package fileDownloadUpLoad;

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

public class ByRobotClass {

	@Test
	public  void FileUploadByRobotClass () throws Exception {
	
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.ilovepdf.com/edit-pdf");
		
	JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		
		WebElement selectPDFFile = driver.findElement(By.xpath("//div[@id='uploader']"));
		System.out.println("selenium focus on choosefilebutton");
		selectPDFFile.click();
		System.out.println("Clicked choosefilebutton");
		
		Thread.sleep(5000);
		
		StringSelection filepath = new StringSelection("C:\\Users\\Anil\\Downloads\\January 2024_PaySlip.pdf");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		System.out.println("File Copied");
		
		Robot rb = new Robot();
		rb.delay(2000);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		System.out.println("Press v");
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		System.out.println("release v");
		rb.delay(2000);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("enter done");
		rb.delay(2000);
		
//		WebElement feedback = driver.findElement(By.xpath("//p[@id=\"uploadedFilePath\"]"));
//		 if(feedback.isDisplayed()==true)
//		 {System.out.println("Tc is pass");}
//		 else
//		 {System.out.println("Tc is failed");}

	}
	
}


