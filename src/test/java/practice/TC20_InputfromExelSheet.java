package practice;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utility.ScreenshotClass;
import utility.Utility;
import utility.excel;

public class TC20_InputfromExelSheet 
{
Logger log= Logger.getLogger("JunFirstWeek2023");
	@Test
	public void logintodemo() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		PropertyConfigurator.configure("log4j.properties");
		
		driver.get("https://www.saucedemo.com/");
		log.info("url is opened");
		
		Utility utilobj = new Utility();
		utilobj.ScreenshotOfPage(driver, "URLOpened");
		
		WebElement uname = driver.findElement(By.xpath("//input[@id='user-name']"));
		String username = excel.exelsheetmethod(0, 1);
		uname.sendKeys(username);
		log.info("username is passed");
		utilobj.ScreenshotOfPage(driver, "Usernamepassed");
		
		WebElement upass = driver.findElement(By.xpath("//input[@id='password']"));
		String userpassword = excel.exelsheetmethod(1, 1);
		upass.sendKeys(userpassword);
		log.info("password is passed");
		utilobj.ScreenshotOfPage(driver, "Passwordpassed");
		
		WebElement loginbtn = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginbtn.click();
		log.info("login button clicked");
		
		log.info("logindone sussesfully");
		utilobj.ScreenshotOfPage(driver, "HomePage");
		
		driver.close();
		log.info("browser closed");
		
		
		
	}
}
