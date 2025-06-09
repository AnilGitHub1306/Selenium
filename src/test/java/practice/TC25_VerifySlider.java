package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC25_VerifySlider 
{
	@Test
	public void VerifySlider ()
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/slider");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement sliderbtn = driver.findElement(By.xpath("(//li[@id='item-3'])[3]"));
		
		js.executeScript("arguments[0].scrollIntoView();", sliderbtn);
		
		sliderbtn.click();
		
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));
		js.executeScript("arguments[0].scrollIntoView();", slider);
		
	//	int xOffset = 45;
	
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider,-50, 0).perform();
		
//		String valueAttribute = slider.getAttribute("value");
//		System.out.println(valueAttribute);
//		if(valueAttribute.equals(valueAttribute))
//		{
//			System.out.println(" Slider working fine");
//		}

		
	
	}
}
