package com.simple;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC02_LogiInToTheSouceDemo 
{

	@Test
	public void method1()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement Pass=driver.findElement(new ByAll(By.xpath("//input[@name='pass']"),By.id("pass"),By.xpath("//input[@placeholder='Password']")));
		Pass.sendKeys("dxhvb,");
		WebElement Pass1=driver.findElement(new ByAll(By.xpath("//input[@name='pass']"),By.id("pass"),By.xpath("//input[@placeholder='Password']")));
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("argument[0].value=’Admin123’;", Pass);
	}
}
