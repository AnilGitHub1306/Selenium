package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class disableNotificationInChrome {

	public static void main(String[] args) 
	{
		 
        System.setProperty("webdriver.chome.driver", "./driver/chromedriver.exe");

       ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver();
        

      
        driver.get("https://www.pushengage.com/");

        
       // driver.quit();

	}

}
