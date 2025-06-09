package com.simple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01_openTheURL 
{

	public static void main(String[] args) throws InterruptedException
	{
	//	System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriverManager.chromedriver().setup();
	//	WebDriverManager.firefoxdriver().setup();
	//	WebDriverManager.iedriver().setup();
	//	WebDriverManager.edgedriver().setup();
	//	WebDriverManager.operadriver().setup();
		System.out.println("properties are set");

		WebDriver driver = new ChromeDriver();
		System.out.println("chome brosedr is opened");
		
		Thread.sleep(2000);
		
		driver.get("https://www.saucedemo.com/v1/");
		System.out.println("URL is opened");
		
		Thread.sleep(2000);
		
		driver.quit();
		System.out.println("browser closed");
	}
}
