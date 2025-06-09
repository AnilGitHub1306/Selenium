package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC24_HandleAccordian 
{
	@Test
	public void accordian() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/widgets");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement accordian = driver.findElement(By.xpath("//span[text()='Accordian']"));
		
		js.executeScript("arguments[0].scrollIntoView();", accordian);
		
		accordian.click();
		
		WebElement accordian1 = driver.findElement(By.xpath("//div[text()='What is Lorem Ipsum?']"));
		Thread.sleep(2000);
		accordian1.click();
		
//		Thread.sleep(2000);
    	WebElement accordian1text = driver.findElement(By.xpath("//*[@id=\"accordianContainer\"]/div/div[1]/div[2]"));
		
//		String accordian1textValue = accordian1text.getAttribute("class");
//		System.out.println(accordian1textValue);
//		if(accordian1textValue.equals("collapse show"))
//		{
//			System.out.println("Accordian display the text");
//		}
//		else
//		{
//			System.out.println("Accordian not display the text");
//		}
	//********************************
	
		System.out.println(accordian1text.isDisplayed());
    	
    	if(accordian1text.isDisplayed()==true)
		{
			System.out.println("Accordian display the text");
			
			WebElement p = driver.findElement(By.xpath("//*[@id=\"section1Content\"]/p"));
			String a=p.getText();
			System.out.println(a);
		}
		else
		{
			System.out.println("Accordian not display the text");
		}
    	driver.quit();
	}

}
