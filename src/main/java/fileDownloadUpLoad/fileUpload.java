package fileDownloadUpLoad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class fileUpload {
	
	@Test
	public void fileUpload() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		System.out.println("browser opened");
		
		driver.get("https://www.ilovepdf.com/edit-pdf");
		System.out.println("url opened");
		
		WebElement uplodButton = driver.findElement(By.xpath("//a[@id='pickfiles']"));
		System.out.println("button found");
		
		Thread.sleep(10);
		uplodButton.sendKeys("C:\\Users\\Anil\\eclipse-workspace\\Automation_Practice_Feb2024\\csvFile.csv");
	}

}
