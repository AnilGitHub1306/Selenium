package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getText 
{
@Test
	public void gettext()
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.get("https://demoqa.com/");
driver.findElement(By.xpath("//h5[text()='Elements']")).click();
//	String textboxtext1=driver.findElement(By.xpath("")).getText();
//	
//	System.out.println(textboxtext);
//	System.out.println(textboxtext1);
	}
}
