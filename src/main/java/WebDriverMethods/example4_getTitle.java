package WebDriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class example4_getTitle
{
	public static void main(String[] args) throws InterruptedException 
	{
				
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		
		
	//	String title = driver.getTitle();
	//	System.out.println(title);
			
		
		System.out.println(driver.getTitle());
	
		
	}

}
