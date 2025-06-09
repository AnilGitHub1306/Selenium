package com.simple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnterTextintoFocussedElement 
{
	WebDriver driver;
	@Test
	public void findTheActiveElement()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/login.do");
		//entering text into the focussed element
		driver.switchTo().activeElement().sendKeys("admin");

	}
}
