package fileDownloadUpLoad;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class fileUploading 
{
	@Test
	public void fileDownload() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",  "./driver/chromedriver.exe");
		
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://demoqa.com/upload-download");
			
		WebElement uploadButton = driver.findElement(By.xpath("//input[@id='uploadFile']"));
		String a = "user.dir";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", uploadButton);
		
		String uploadPath = System.getProperty("user.dir");
		uploadButton.sendKeys(uploadPath+"\\download_s\\Capture.JPG");
			
		WebElement feedback = driver.findElement(By.xpath("//input[@id='uploadFile']"));
					
			if(feedback.isDisplayed())
			{
				System.out.println("Test case is pass");
			}
			else
			{System.out.println("Test case is failed");}
			driver.quit(); 
		}

}


