package accordian;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAccordians 
{
	@Test
	public void handle_accordian()
	{
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://demoqa.com/accordian");
		
		List <WebElement> accordianList = driver.findElements(By.xpath("//div[@class='card-header']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		List <WebElement> accordianCollapse = driver.findElements(By.xpath("//div[@class='card-header']"));
		
		for(int i=0; i<accordianList.size(); i++)
		{
			WebElement acco= accordianList.get(i);
			js.executeScript("arguments[0].scrollIntoView();",acco );
			
			if(accordianCollapse.get(i).isDisplayed()==true) 
			{System.out.println("TC Pass : Accordian " + i);
			
			}
			else if(accordianCollapse.get(i).isDisplayed()==false)
			{
				accordianList.get(i).click();
				Assert.assertTrue(accordianCollapse.get(i).isDisplayed());
				System.out.println("TC Pass : Accordian Tc pass for" + i);
			}
			else
			{
				System.out.println("TC failed : Accordian Tc failed for" + i);
			}
			
		}
	}

}
