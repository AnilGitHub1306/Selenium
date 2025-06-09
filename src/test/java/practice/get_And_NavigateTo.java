package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class get_And_NavigateTo 
{

	@Test 
	public void openUrl()
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("www.google.com");
		driver.navigate().to("www.google.com");
		driver.close();
		
	}
}
