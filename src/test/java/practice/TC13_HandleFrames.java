package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC13_HandleFrames 
{
	@Test
	public void framehandling() throws InterruptedException
	{
System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser opned");
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		System.out.println("Implicit wait applied");
		
		driver.get("https://demoqa.com/frames");
		System.out.println("url opened");
		
		WebElement iframe1 = driver.findElement(By.xpath("//*[@id=\"frame1\"]"));
		JavascriptExecutor js =(JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,100)");
		js.executeScript("arguments[0].scrollIntoView();", iframe1);
		
		System.out.println("iframe1 located");
		
		driver.switchTo().frame(iframe1);
		System.out.println("switched to iframe1");
		
		WebElement sampletextiframe2 = driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
		if(sampletextiframe2.isDisplayed()==true)
		{
			String expectedText ="This is a sample page";
			String actualtext = sampletextiframe2.getText();
			System.out.println("actual text - "+actualtext);
			Assert.assertEquals(actualtext, expectedText);
			System.out.println("its iframe1");
		}
		
		driver.switchTo().parentFrame(); 
		
		WebElement parentpagetext = driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]/div[1]/text()"));
		boolean tf = parentpagetext.isDisplayed();
		if(tf==true)
		{
		Assert.assertTrue(tf);
		System.out.println("its a parent page");
		}
		
		WebElement iframe2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		
		System.out.println("iframe2 located");
		
		driver.switchTo().frame(iframe2);
		System.out.println("switched to iframe2");
		
		
		
		
		
		
		
		
		Thread.sleep(4);
		driver.quit();
		System.out.println("browser closed");
		
		
	}
}
